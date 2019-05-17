package com.zzg.controller;

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
import com.zzg.common.core.id.generator.IdGenerator;
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.ObjectRelation;
import com.zzg.entity.Objects;
import com.zzg.entity.Table;
import com.zzg.entity.pack.ObjectRelationPack;
import com.zzg.service.ObjectRelationService;
import com.zzg.service.ObjectsService;
import com.zzg.service.TableService;

@Controller
@RequestMapping("/api/object-relation")
public class ObjectRelationController {
	// 局部静态常量定义
	public static final String MASTER = "1"; // 主表
	public static final String SECOND = "2"; // 从表

	@Autowired
	private ObjectRelationService service;
	@Autowired
	private TableService tableService;
	@Autowired
	private ObjectsService objectsService;

	// 查询业务对象信息，业务对象绑定主表,业务对象绑定的从表
	@RequestMapping(value = "/relation")
	public String binding(Model model, String sid) {
		// 业务对象信息查询
		Objects entity = objectsService.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);

		// 查询业务对象绑定的主表信息
		Map<String, Object> masterMap = new HashMap();
		masterMap.put("tableType", MASTER);
		masterMap.put("busObjectId", sid);
		List<ObjectRelationPack> master = service.select(masterMap);
		System.out.println("master结构输出:" + JSON.toJSON(master));
		model.addAttribute("master", master);

		// 查询业务对象绑定的从表信息
		Map<String, Object> secondMap = new HashMap();
		secondMap.put("tableType", SECOND);
		secondMap.put("busObjectId", sid);
		List<ObjectRelationPack> second = service.select(secondMap);
		System.out.println("second结构输出:" + JSON.toJSON(second));
		model.addAttribute("second", second);

		return "relation/relation";
	}

	// 业务对象绑定表
	@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
	public String insertPage(Model model, String busObjectId,
			@RequestParam(value = "busTableId", required = false, defaultValue = "") String busTableId) {
		// 业务对象
		model.addAttribute("busObjectId", busObjectId);
		model.addAttribute("busTableId", busTableId);

		// 表对象
		List<Table> tables = tableService.selectAll();
		Map<String, String> tableMap = tables.stream().collect(Collectors.toMap(Table::getName, Table::getSid));
		model.addAttribute("tableMap", tableMap);

		// 主从类型
		Map<String, String> typeMap = new HashMap<String, String>();
		typeMap.put("主表", "1");
		typeMap.put("从表", "2");
		model.addAttribute("typeMap", typeMap);

		// 关系类型
		Map<String, String> releationMap = new HashMap<String, String>();
		releationMap.put("一对一", "1");
		releationMap.put("一对多", "2");
		model.addAttribute("releationMap", releationMap);

		return "relation/add";
	}

	// 插入
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public String insert(ObjectRelation entity) {
		// 主键初始化
		IdGenerator idWorker = new IdGenerator(0, 1);
		String sid = String.valueOf(idWorker.nextId());
		entity.setSid(sid);

		// 判断是添加主表还是从表
		if (entity.getTableType().equalsIgnoreCase(MASTER)) {
			String busTableId = entity.getBusTableId().substring(1, entity.getBusTableId().length());
			// 获取路径
			Table table = tableService.selectByPrimaryKey(busTableId);
			entity.setBusTableId(busTableId);
			String path = "/" + table.getCode().toLowerCase();
			entity.setDepath(1);
			entity.setParentId(null);
			entity.setPath(path);
			service.insert(entity);

		} else if (entity.getTableType().equalsIgnoreCase(SECOND)) {
			// 获取父类深度
			String[] strs = entity.getBusTableId().split(",");
			// 主表sid
			String masterSid = strs[0];
			// 从表sid
			String secondSis = strs[1];

			// 设置从表的Id
			entity.setBusTableId(secondSis);
			// 获取路径
			Table table = tableService.selectByPrimaryKey(secondSis);
			String path = "/" + table.getCode().toLowerCase();

			// 查询主表关系记录
			Map<String, Object> masterMap = new HashMap<String, Object>();
			masterMap.put("busTableId", masterSid);
			masterMap.put("busObjectId", entity.getBusObjectId());
			service.select(masterMap).stream().forEach(item -> {
				String parentId = item.getSid();
				Integer childDepath = item.getDepath() + 1;
				String childPath = item.getPath() + path;
				entity.setParentId(parentId);
				entity.setDepath(childDepath);
				entity.setPath(childPath);
			});
			service.insert(entity);
		}
		return "redirect:/api/object/allObjects";
	}

	// 删除
	@RequestMapping(value = "/delete", method = { RequestMethod.GET })
	public String delete(String sid) {
		service.deleteByPrimaryKey(sid);
		return "redirect:/api/object/allObjects";
	}

}
