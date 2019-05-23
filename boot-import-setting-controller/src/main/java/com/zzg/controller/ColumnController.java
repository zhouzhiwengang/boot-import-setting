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
import com.zzg.constant.MySQLConstant;
import com.zzg.entity.Column;
import com.zzg.entity.ColumnWidget;
import com.zzg.entity.Entity;
import com.zzg.entity.Property;
import com.zzg.service.ColumnService;
import com.zzg.service.PropertyService;

@Controller
@RequestMapping("/api/column")
public class ColumnController {
	@Autowired
	private ColumnService service;
	@Autowired
	private PropertyService propertyService;

	// 分页查询
	@RequestMapping("/allColumns")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<Column> list = service.selectAll();

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

		return "field/field";
	}

	// 跳转至新增页面
	@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
	public String insertPage(Model model) {
		Map<String, Object> map = MySQLConstant.getMySQLDataType();
		model.addAttribute("dataType", map);
		return "field/add";
	}

	// 插入
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public String insert(Column entity) {
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
		return "redirect:/api/column/allColumns";
	}

	// 跳转至更新页面
	@RequestMapping(value = "/updatePage")
	public String update(Model model, String sid) {
		Column entity = service.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);
		Map<String, Object> map = MySQLConstant.getMySQLDataType();
		model.addAttribute("dataType", map);

		Map<String, Object> requiredMap = new HashMap<String, Object>();
		requiredMap.put("否", "2");
		requiredMap.put("是", "1");
		model.addAttribute("requiredMap", requiredMap);

		Map<String, Object> primaryMap = new HashMap<String, Object>();
		primaryMap.put("否", "2");
		primaryMap.put("是", "1");
		model.addAttribute("primaryMap", primaryMap);
		return "field/update";
	}

	// 数据更新
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(Column entity) {
		service.update(entity);
		// 字段控件更新成功，跳转至字段控件首页
		return "redirect:/api/column/allColumns";
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
		return "redirect:/api/column/allColumns";
	}

	// 属性实体文件创建
	@RequestMapping(value = "/property")
	public String property(String sid) {
		Column column = service.selectByPrimaryKey(sid);
		Property entity = new Property();
		// 实体对象记录数据初始化
		IdGenerator idWorker = new IdGenerator(0, 1);
		String id = String.valueOf(idWorker.nextId());
		entity.setSid(id);
		// 默认始化值
		entity.setCreateDt(new Date());
		entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
		entity.setState(GlobalConstant.ENABLE);

		// 字段属性设置
		entity.setColumnId(sid);
		entity.setPropertyName(PropertyConvert.getProperty(column.getCode()));
		entity.setPropertyType(FieldType.getType(column.getType()));

		propertyService.insert(entity);
		// 数据移除，重新跳转至字段控件首页
		return "redirect:/api/property/allPropertys";
	}

}
