package com.zzg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.common.core.id.generator.IdGenerator;
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.Entity;
import com.zzg.entity.Property;
import com.zzg.entity.SettingEntity;
import com.zzg.entity.SettingEntityField;
import com.zzg.entity.SettingImport;
import com.zzg.service.ColumnService;
import com.zzg.service.EntityService;
import com.zzg.service.PropertyService;
import com.zzg.service.SettingEntityFieldService;
import com.zzg.service.SettingEntityService;
import com.zzg.service.SettingImportService;
import com.zzg.service.TableService;

@Controller
@RequestMapping("/api/setting")
public class SettingImportController {
	// 局部静态常量定义
	public static final String MASTER = "1"; // 主表
	public static final String SECOND = "2"; // 从表

	@Autowired
	private SettingImportService service;
	@Autowired
	private SettingEntityService settingEntityService;
	@Autowired
	private TableService tableService;
	@Autowired
	private ColumnService columnService;
	@Autowired
	private EntityService entityService;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private SettingEntityFieldService settingEntityFieldService;

	// 分页查询
	@RequestMapping("/allSettings")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<SettingImport> list = service.selectAll();

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

		return "setting/setting";
	}

	// 跳转至新增页面
	@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
	public String insertPage(Model model) {
		return "setting/add";
	}

	// 插入
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public String insert(SettingImport entity) {
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
		return "redirect:/api/setting/allSettings";
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
		return "redirect:/api/setting/allSettings";
	}

	@RequestMapping(value = "/mapping")
	public String mapping(Model model, String sid) {
		model.addAttribute("setting_import_id", sid);

		// 表对象
		List<Entity> tables = entityService.selectAll();
		Map<String, String> tableMap = tables.stream()
				.collect(Collectors.toMap(Entity::getEntityObject, Entity::getSid));
		model.addAttribute("tableMap", tableMap);

		// 主从类型
		Map<String, String> typeMap = new HashMap<String, String>();
		typeMap.put("主表", "1");
		typeMap.put("从表", "2");
		model.addAttribute("typeMap", typeMap);

		// 已配置主表
		Map<String, Object> master = new HashMap<String, Object>();
		master.put("settingImportId", sid);
		master.put("isMaster", MASTER);
		List<SettingEntity> masters = settingEntityService.select(master);
		if (masters != null && masters.size() > 0) {
			List<String> ids = masters.stream().map(SettingEntity::getEntityId).collect(Collectors.toList());
			model.addAttribute("master", entityService.selectBySids(ids));
		}
		// 已配置从表
		Map<String, Object> second = new HashMap<String, Object>();
		second.put("settingImportId", sid);
		second.put("isMaster", SECOND);
		List<SettingEntity> seconds = settingEntityService.select(second);
		if (seconds != null && seconds.size() > 0) {
			List<String> secondIds = seconds.stream().map(SettingEntity::getEntityId).collect(Collectors.toList());
			model.addAttribute("second", entityService.selectBySids(secondIds));
		}
		// 数据移除，重新跳转至字段控件首页
		return "setting/mapping";
	}

	// 添加主表
	@RequestMapping(value = "/master-insert")
	public String masterInsert(Model model, String settingImportId) {

		model.addAttribute("settingImportId", settingImportId);

		// 表对象
		List<Entity> tables = entityService.selectAll();
		Map<String, String> tableMap = tables.stream()
				.collect(Collectors.toMap(Entity::getEntityObject, Entity::getSid));
		model.addAttribute("entityMap", tableMap);

		// 主从类型
		Map<String, String> typeMap = new HashMap<String, String>();
		typeMap.put("主表", "1");
		typeMap.put("从表", "2");
		model.addAttribute("typeMap", typeMap);
		return "setting/formadd";
	}

	// 添加从表
	@RequestMapping(value = "/form-entity-insert")
	public String formTableInsert(Model model, String settingImportId, String entityId) {

		model.addAttribute("settingImportId", settingImportId);
		model.addAttribute("entityId", entityId);

		// 表对象
		List<Entity> tables = entityService.selectAll();
		Map<String, String> tableMap = tables.stream()
				.collect(Collectors.toMap(Entity::getEntityObject, Entity::getSid));
		model.addAttribute("entityMap", tableMap);

		// 主从类型
		Map<String, String> typeMap = new HashMap<String, String>();
		typeMap.put("主表", "1");
		typeMap.put("从表", "2");
		model.addAttribute("typeMap", typeMap);
		return "setting/formadd";
	}

	@RequestMapping(value = "/mapping-insert")
	public String mappingInsert(SettingEntity entity) {
		// 主键初始化
		IdGenerator idWorker = new IdGenerator(0, 1);
		String sid = String.valueOf(idWorker.nextId());
		entity.setSid(sid);

		// 判断是添加主表还是从表
		if (entity.getIsMaster().equalsIgnoreCase(MASTER)) {
			// 获取路径
			Entity table = entityService
					.selectByPrimaryKey(entity.getEntityId().substring(1, entity.getEntityId().length()));
			entity.setEntityId(table.getSid());
			String path = "/" + table.getEntityObject().toLowerCase();
			entity.setDepath("1");
			entity.setParentId(null);
			entity.setPath(path);
			// 默认始化值
			entity.setCreateDt(new Date());
			entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
			entity.setState(GlobalConstant.ENABLE);
			entity.setVersion(GlobalConstant.DEFAULT_VALUE);
			settingEntityService.insert(entity);

		} else if (entity.getIsMaster().equalsIgnoreCase(SECOND)) {
			// 获取父类深度
			String[] strs = entity.getEntityId().split(",");
			// 主表sid
			String masterSid = strs[0];
			// 从表sid
			String secondSis = strs[1];

			// 设置从表的Id
			entity.setEntityId(secondSis);
			// 获取路径
			Entity table = entityService.selectByPrimaryKey(secondSis);
			String path = "/" + table.getEntityObject().toLowerCase();

			// 查询主表关系记录
			Map<String, Object> masterMap = new HashMap<String, Object>();
			masterMap.put("settingImportId", entity.getSettingImportId());
			masterMap.put("entityId", masterSid);
			settingEntityService.select(masterMap).stream().forEach(item -> {
				String parentId = item.getSid();
				Integer childDepath = Integer.valueOf(item.getDepath()) + 1;
				String childPath = item.getPath() + path;
				entity.setParentId(parentId);
				entity.setDepath("" + childDepath);
				entity.setPath(childPath);
				// 默认始化值
				entity.setCreateDt(new Date());
				entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
				entity.setState(GlobalConstant.ENABLE);
				entity.setVersion(GlobalConstant.DEFAULT_VALUE);
			});
			settingEntityService.insert(entity);
		}

		return "redirect:/api/setting/allSettings";
	}

	@RequestMapping(value = "/mapping-delete")
	public String mappingDelete(String isMaster, String settingImportId, String tableId) {

		if (isMaster.equalsIgnoreCase(MASTER)) {
			// 主表移除
			Map<String, Object> masterMap = new HashMap<String, Object>();
			masterMap.put("settingImportId", settingImportId);
			masterMap.put("entityId", tableId);
			settingEntityService.select(masterMap).stream().forEach(item -> {
				// like 移除(路径)
				Map<String, Object> deleteMap = new HashMap<String, Object>();
				deleteMap.put("path", item.getPath());
				settingEntityService.delete(deleteMap);
			});

		} else {
			// 查询主表关系记录
			Map<String, Object> masterMap = new HashMap<String, Object>();
			masterMap.put("settingImportId", settingImportId);
			masterMap.put("entityId", tableId);
			settingEntityService.select(masterMap).stream().forEach(item -> {
				// 从表移除
				settingEntityService.deleteByPrimaryKey(item.getSid());
			});
		}
		return "redirect:/api/setting/allSettings";
	}

	@RequestMapping(value = "/banding")
	public String banding(Model model, String sid) {
		// 查询实体 涉及属性
		Map<String, Object> parame = new HashMap<String, Object>();
		parame.put("entityId", sid);
		List<Property> propertys = propertyService.select(parame);
		if (propertys != null && propertys.size() > 0) {
			model.addAttribute("propertys", propertys);
		}

		// 查询实体对象信息
		Entity entity = entityService.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);

		return "setting/banding";
	}

	@RequestMapping(value = "/banding-form")
	public String bandingForm(Model model, String entityId, String propertyId, String entityPackage,
			String entityObject, String propertyName, String propertyType) {
		model.addAttribute("entityId", entityId);
		model.addAttribute("propertyId", propertyId);
		model.addAttribute("entityPackage", entityPackage);
		model.addAttribute("entityObject", entityObject);
		model.addAttribute("propertyName", propertyName);
		model.addAttribute("propertyType", propertyType);
		return "setting/banding-form";
	}

	@RequestMapping(value = "/banding-insert")
	public String bandingInsert(SettingEntityField entity) {

		// 主键初始化
		IdGenerator idWorker = new IdGenerator(0, 1);
		String sid = String.valueOf(idWorker.nextId());
		entity.setSid(sid);
		// 默认始化值
		entity.setCreateDt(new Date());
		entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
		entity.setState(GlobalConstant.ENABLE);
		entity.setVersion(GlobalConstant.DEFAULT_VALUE);
		settingEntityFieldService.insert(entity);

		return "redirect:/api/setting/allSettings";
	}

}
