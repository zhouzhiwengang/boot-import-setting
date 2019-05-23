package com.zzg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.entity.Entity;
import com.zzg.entity.Property;
import com.zzg.service.EntityService;
import com.zzg.service.PropertyService;

@Controller
@RequestMapping("/api/entity")
public class EntityController {
	@Autowired
	private EntityService service;
	@Autowired
	private PropertyService propertyService;

	// 分页查询
	@RequestMapping("/allEntitys")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<Entity> list = service.selectAll();

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

		return "entity/entity";
	}
	
	// 实体对象关联实体属性列表
	@RequestMapping("/propertys")
	public String getPropertys(Model model, String sid){
		Map<String,Object> parame = new HashMap<String,Object>();
		parame.put("entityId", sid);
		List<Property> list = propertyService.select(parame);
		
		model.addAttribute("list", list);
		return "entity/propertys";
	}
	

}
