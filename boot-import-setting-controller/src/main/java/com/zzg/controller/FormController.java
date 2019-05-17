package com.zzg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.common.core.id.generator.IdGenerator;
import com.zzg.common.core.tree.TreeBuilder;
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.Objects;
import com.zzg.entity.formRelation;
import com.zzg.entity.forms;
import com.zzg.entity.pack.ObjectRelationPack;
import com.zzg.service.ColumnService;
import com.zzg.service.ObjectRelationService;
import com.zzg.service.ObjectsService;
import com.zzg.service.TableService;
import com.zzg.service.formRelationService;
import com.zzg.service.formsService;

@Controller
@RequestMapping("/api/form")
public class FormController {
	@Autowired
	private formsService service;
	@Autowired
	private formRelationService formrelationService;
	@Autowired
	private ObjectsService objectsService;
	@Autowired
	private ObjectRelationService objectRelationService;
	@Autowired
	private TableService tableService;
	@Autowired
	private ColumnService columnService;
	
	// 分页查询
		@RequestMapping("/allForms")
		public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
				@RequestParam(defaultValue = "10") int pageSize) {
			// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
			PageHelper.startPage(pageNo, pageSize);
			List<forms> list = service.selectAll();

			PageInfo pageInfo = new PageInfo(list);
			model.addAttribute("pageInfo", pageInfo);
			// 获得当前页
			model.addAttribute("pageNum", pageInfo.getPageNum());
			// 获得一页显示的条数
			model.addAttribute("pageSize", pageInfo.getPageSize());
			// 是否是第一页
			model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
			// 获得总页数
			model.addAttribute("totalPages", pageInfo.getPages());
			// 是否是最后一页
			model.addAttribute("isLastPage", pageInfo.isIsLastPage());

			return "form/form";
		}

		// 跳转至新增页面
		@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
		public String insertPage(Model model) {
			return "form/add";
		}

		// 插入
		@RequestMapping(value = "/insert", method = { RequestMethod.POST })
		public String insert(forms entity) {
			// 主键初始化
			IdGenerator idWorker = new IdGenerator(0, 1);
			String sid = String.valueOf(idWorker.nextId());
			entity.setSid(sid);
			// 默认始化值
			entity.setCreateDt(new Date());
			entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
			entity.setState(GlobalConstant.ENABLE);
			entity.setVersion(GlobalConstant.DEFAULT_VALUE);
			service.insert(entity);
			// 字段控件新增成功，调整至字段控件首页
			return "redirect:/api/form/allForms";
		}
		
		// 绑定
		@RequestMapping(value = "/binding", method = { RequestMethod.GET })
		public String binding(Model model, String busFormId){
			forms form = service.selectByPrimaryKey(busFormId);
			// 自定义表单ID
			model.addAttribute("form", form);
			
			// list 转 map
			List<Objects> list = objectsService.selectAll();
			Map<String,String> map = list.stream().collect(
	                Collectors.toMap(Objects::getName, Objects::getSid));
			model.addAttribute("dataType", map);
			return "form/binding";
		}
		
		// 业务表单与业务对象关系绑定
		@RequestMapping(value = "/binding-insert", method = { RequestMethod.POST })
		public String bindingInsert(formRelation entity){
			// 主键初始化
			IdGenerator idWorker = new IdGenerator(0, 1);
			String sid = String.valueOf(idWorker.nextId());
			entity.setSid(sid);
			
			formrelationService.insert(entity);
			return "redirect:/api/form/allForms";
		}
		
		// 设计表单
		@RequestMapping(value = "/design", method = { RequestMethod.GET})
		public String design(String sid){
			// 查询表单关联业务对象
			Map<String,Object> parames = new HashMap<String,Object>();
			parames.put("busFormId", sid);
			List<formRelation> relation = formrelationService.select(parames);
			
			// 如果表单未绑定业务对象,直接跳转至绑定业务对象的页面,进行绑定
			if(relation != null && relation.size() > 0){
				// 查询业务对象涉及表
				Map<String,Object> parame = new HashMap<String,Object>();
				parame.put("busObjectId", relation.get(0).getBusObjectId());
				List<ObjectRelationPack> list = objectRelationService.select(parame);
				
				// 树形结构构建
				List<TreeBuilder.Node> nodes = new ArrayList<TreeBuilder.Node>();
				List<TreeBuilder.Node> tree = null;
				if(list != null && list.size() > 0){
					for(ObjectRelationPack item : list){
						// 主键
						String busObjectId = item.getSid();
						// 处理根节点为null 情况,则为项目根节点
						String parentId = Optional.ofNullable(item.getParentId()).orElse("NULL");
						// 路径
						String path = item.getPath();
						// 深度
						Integer depth = item.getDepath();
						TreeBuilder.Node node = new TreeBuilder.Node(busObjectId,parentId,path,depth);
						// 填充节点的数据form
						node.setForm(tableService.selectByPrimaryKey(item.getBusTableId()));
						// 填充节点的数据to
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("busTableId", item.getBusTableId());
						node.setTo(columnService.select(map));
						nodes.add(node);
					}
					if(nodes != null && nodes.size() > 0){
						TreeBuilder builder = new TreeBuilder(nodes);
						tree = builder.buildTree();
					}
				}
				System.out.println("json tree 数据：" +  JSON.toJSONString(tree));
				return "form/design";
			} else {
				// 跳转表单绑定业务界面
				return "";
			}
			
		}
}
