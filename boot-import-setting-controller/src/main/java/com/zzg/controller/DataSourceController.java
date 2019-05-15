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
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.Column;
import com.zzg.entity.DataSource;
import com.zzg.entity.Table;
import com.zzg.service.DataSourceService;
import com.zzg.service.TableService;

@Controller
@RequestMapping("/api/data-source")
public class DataSourceController {
	@Autowired
	private DataSourceService service;
	@Autowired
	private TableService tableService;
	
	// 分页查询
		@RequestMapping("/allDataSources")
		public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
				@RequestParam(defaultValue = "10") int pageSize) {
			// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
			PageHelper.startPage(pageNo, pageSize);
			List<DataSource> list = service.selectAll();

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

			return "datasource/datasource";
		}

		// 跳转至新增页面
		@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
		public String insertPage(Model model) {
			return "datasource/add";
		}

		// 插入
		@RequestMapping(value = "/insert", method = { RequestMethod.POST })
		public String insert(DataSource entity) {
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
			return "redirect:/api/data-source/allDataSources";
		}
		
		// 跳转至更新页面
		@RequestMapping(value = "/updatePage")
		public String update(Model model, String sid) {
			DataSource entity = service.selectByPrimaryKey(sid);
			model.addAttribute("entity", entity);
			return "datasource/update";
		}

		// 数据更新
		@RequestMapping(value = "/update", method = { RequestMethod.POST })
		public String update(DataSource entity) {
			service.update(entity);
			// 字段控件更新成功，跳转至字段控件首页
			return "redirect:/api/data-source/allDataSources";
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
			return "redirect:/api/data-source/allDataSources";
		}
		
		
		// 绑定页面
		@RequestMapping(value = "/binding")
		public String binding(Model model, String sid) {
			// 表数据查询
			DataSource entity = service.selectByPrimaryKey(sid);
			model.addAttribute("entity", entity);
			// 表涉及已绑定字段查询
			Map<String, Object> bindParame = new HashMap<String, Object>();
			bindParame.put("dataSourceId", sid);
			List<Table> bindTables = tableService.select(bindParame);
			model.addAttribute("bindTables", bindTables);
			// 表涉及未绑定字段查询
			Map<String, Object> unBindParame = new HashMap<String, Object>();
			unBindParame.put("notDataSourceId", sid);
			List<Table> unBindTables = tableService.select(unBindParame);
			model.addAttribute("unBindTables", unBindTables);
			return "datasource/binding";
		}

		// 表绑定指定数据源
		@RequestMapping(value = "/bind")
		public String bind(String sid, String dataSourceId, Integer version) {
			Table record = new Table();
			record.setSid(sid);
			record.setDataSourceId(dataSourceId);
			record.setVersion(version);
			tableService.update(record);
			return "redirect:/api/data-source/binding";
		}

		// 指定表移除数据源
		@RequestMapping(value = "/unbind")
		public String unbind(String sid) {
			tableService.unbind(sid);
			return "redirect:/api/data-source/binding";
		}
	
	
	
}
