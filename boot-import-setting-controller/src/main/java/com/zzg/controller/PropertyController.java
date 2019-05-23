package com.zzg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
@RequestMapping("/api/property")
public class PropertyController {
	@Autowired
	private PropertyService service;
	@Autowired
	private EntityService entityService;

	// 分页查询
	@RequestMapping("/allPropertys")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<Property> list = service.selectAll();

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

		return "property/property";
	}
	
	// 绑定实体对象
	@RequestMapping("/binding")
	public String binding(Model model,String sid) {
		model.addAttribute("sid", sid);
		Map<String,String> map = entityService.selectAll().stream().collect(Collectors.toMap(Entity::getEntityObject, Entity::getSid));
		model.addAttribute("entityMap", map);
		return "property/binding";
	}
	
	// 实体属性绑定对应实体对象
	@RequestMapping("/entity-binding")
	public String entityBinding(String sid,String entityId){
		Map<String,Object> parame = new HashMap<String,Object>();
		parame.put("sid", sid);
		parame.put("entityId", entityId);
		service.update(parame);
		return "redirect:/api/property/allPropertys";
	}
	
	
	
}
