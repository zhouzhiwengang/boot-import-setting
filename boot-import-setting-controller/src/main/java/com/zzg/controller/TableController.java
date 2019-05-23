package com.zzg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.common.core.id.generator.IdGenerator;
import com.zzg.common.core.mysql.convert.FieldType;
import com.zzg.common.core.mysql.convert.PropertyConvert;
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.Column;
import com.zzg.entity.Entity;
import com.zzg.entity.Table;
import com.zzg.service.ColumnService;
import com.zzg.service.EntityService;
import com.zzg.service.TableService;

@Controller
@RequestMapping("/api/table")
public class TableController {
	@Autowired
	private TableService service;
	@Autowired
	private ColumnService columnService;
	@Autowired
	private EntityService entityService;

	// 分页查询
	@RequestMapping("/allTables")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<Table> list = service.selectAll();

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

		return "table/table";
	}

	// 跳转至新增页面
	@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
	public String insertPage(Model model) {
		return "table/add";
	}

	// 插入
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public String insert(Table entity) {
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
		return "redirect:/api/table/allTables";
	}

	// 跳转至更新页面
	@RequestMapping(value = "/updatePage")
	public String update(Model model, String sid) {
		Table entity = service.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);
		return "table/update";
	}

	// 数据更新
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(Table entity) {
		service.update(entity);
		// 字段控件更新成功，跳转至字段控件首页
		return "redirect:/api/table/allTables";
	}

	// 删除
	@RequestMapping(value = "/delete")
	public String delete(String sid, Integer version) {
		Map<String, Object> parames = new HashMap<String, Object>();
		parames.put("sid", sid);
		parames.put("deleteFlag", GlobalConstant.DELETE_FLAG_YES); // 删除状态
		parames.put("version", version);
		service.updateDeleteFlag(parames);
		// 数据移除，重新跳转至字段控件首页
		return "redirect:/api/table/allTables";
	}

	// 绑定页面
	@RequestMapping(value = "/binding")
	public String binding(Model model, String sid) {
		// 表数据查询
		Table entity = service.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);
		// 表涉及已绑定字段查询
		Map<String, Object> bindParame = new HashMap<String, Object>();
		bindParame.put("busTableId", sid);
		List<Column> bindColumns = columnService.select(bindParame);
		model.addAttribute("bindColumns", bindColumns);
		// 表涉及未绑定字段查询
		Map<String, Object> unBindParame = new HashMap<String, Object>();
		unBindParame.put("notBusTableId", sid);
		List<Column> unBindColumns = columnService.select(unBindParame);
		model.addAttribute("unbindColumns", unBindColumns);

		return "table/binding";
	}

	// 字段绑定指定表
	@RequestMapping(value = "/bind")
	public String bind(String sid, String busTableId, Integer version) {
		Column record = new Column();
		record.setSid(sid);
		record.setBusTableId(busTableId);
		record.setVersion(version);
		columnService.update(record);
		return "redirect:/api/table/binding";
	}

	// 指定字段移除表
	@RequestMapping(value = "/unbind")
	public String unbind(String sid) {
		columnService.unbind(sid);
		return "redirect:/api/table/binding";
	}

	// 生成表对应实体对象记录
	@RequestMapping(value = "/entity")
	public String entity(String sid) {
		// 查询表记录
		Table table = service.selectByPrimaryKey(sid);
		Entity entity = new Entity();
		// 实体对象记录数据初始化
		IdGenerator idWorker = new IdGenerator(0, 1);
		String id = String.valueOf(idWorker.nextId());
		entity.setSid(id);
		// 默认始化值
		entity.setCreateDt(new Date());
		entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
		entity.setState(GlobalConstant.ENABLE);
		// 表相关属性设置
		entity.setTableId(sid);
		entity.setEntityPackage(table.getCode());
		entity.setEntityObject(table.getEntity());
		entityService.insert(entity);
		return "redirect:/api/entity/allEntitys";
	}

}
