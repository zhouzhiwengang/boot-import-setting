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
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.common.core.id.generator.IdGenerator;
import com.zzg.common.core.result.Result;
import com.zzg.constant.GlobalConstant;
import com.zzg.entity.ColumnValidate;
import com.zzg.service.ColumnValidateService;

@Controller
@RequestMapping("/api/column-validate")
public class ColumnValidateController {
	@Autowired
	private ColumnValidateService service;

	// 分页查询
	@RequestMapping("/allColumnValidates")
	public String getPage(Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		// 注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。
		PageHelper.startPage(pageNo, pageSize);
		List<ColumnValidate> list = service.selectAll();

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

		return "validate/validate";
	}

	// 跳转至新增页面
	@RequestMapping(value = "/insertPage", method = { RequestMethod.GET })
	public String insertPage() {
		return "validate/add";
	}

	// 插入
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public String insert(ColumnValidate entity) {
		IdGenerator idWorker = new IdGenerator(0, 0);
		String sid = String.valueOf(idWorker.nextId());
		entity.setSid(sid);
		// 默认始化值
		entity.setCreateDt(new Date());
		entity.setDeleteFlag(GlobalConstant.DELETE_FLAG_NO);
		entity.setState(GlobalConstant.ENABLE);
		entity.setVersion(GlobalConstant.DEFAULT_VALUE);
		service.insert(entity);
		// 字段验证规则新增成功，调整至字段验证首页
		return "redirect:/api/column-validate/allColumnValidates";
	}

	// 更新
	@RequestMapping(value = "/updatePage")
	public String update(Model model, String sid) {
		ColumnValidate entity = service.selectByPrimaryKey(sid);
		model.addAttribute("entity", entity);
		return "validate/update";
	}

	// 更新
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(ColumnValidate entity) {
		service.update(entity);
		// 字段验证规则新增成功，调整至字段验证首页
		return "redirect:/api/column-validate/allColumnValidates";
	}

	// 删除
	@RequestMapping(value = "/delete")
	public String delete(String sid,Integer version) {
		Map<String, Object> parames = new HashMap<String, Object>();
		parames.put("sid", sid);
		parames.put("deleteFlag",GlobalConstant.DELETE_FLAG_YES ); // 删除状态
		parames.put("version", version);
		service.updateDeleteFlag(parames);
		return "redirect:/api/column-validate/allColumnValidates";
	}

}
