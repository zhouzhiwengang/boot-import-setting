package com.zzg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.common.core.id.generator.IdGenerator;
import com.zzg.common.core.result.Result;
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.ColumnValidate;
import com.zzg.entity.ColumnWidget;
import com.zzg.service.ColumnWidgetService;

@Controller
@RequestMapping("/api/column-widget")
public class ColumnWidgetController {
	@Autowired
	private ColumnWidgetService service;

	// 分页查询
	@RequestMapping("/allColumnWidgets")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<ColumnWidget> list = service.selectAll();

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

		return "widget/widget";
	}

	// 跳转至新增页面
	@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
	public String insertPage(Model model) {
		// 构建页面初始化加载数据
		Map<String,Integer> map = getInitDate();
		model.addAttribute("dataType", map);
		
		Map<String,Integer> sourceMap = getSourceTypeDate();
		model.addAttribute("sourceType", sourceMap);
		return "widget/add";
	}

	// 插入
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public String insert(ColumnWidget entity) {
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
		return "redirect:/api/column-widget/allColumnWidgets";
	}

	// 跳转至更新页面
	@RequestMapping(value = "/updatePage")
	public String update(Model model, String sid) {
		ColumnWidget entity = service.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);
		return "widget/update";
	}

	// 数据更新
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(ColumnWidget entity) {
		service.update(entity);
		// 字段控件更新成功，跳转至字段控件首页
		return "redirect:/api/column-widget/allColumnWidgets";
	}

	// 删除
	@RequestMapping(value = "/delete")
	public String delete(String sid, Integer version) {
		Map<String, Object> parames = new HashMap<String, Object>();
		parames.put("sid", sid);
		parames.put("deleteFlag",GlobalConstant.DELETE_FLAG_YES ); // 删除状态
		parames.put("version", version);
		service.updateDeleteFlag(parames);
		// 数据移除，重新跳转至字段控件首页
		return "redirect:/api/column-widget/allColumnWidgets";
	}
	
	// 页面数据初始化
	public Map getInitDate(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("字符串", 1);
		map.put("文本", 2);
		map.put("日期", 3);
		map.put("数字", 4);
		return map;
	}
	
	public Map getSourceTypeDate(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("本地", 1);
		map.put("数据字典", 2);
		return map;
	}
}
