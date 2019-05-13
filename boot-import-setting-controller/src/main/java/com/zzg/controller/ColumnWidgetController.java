package com.zzg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.zzg.common.core.result.Result;
import com.zzg.entity.ColumnValidate;
import com.zzg.entity.ColumnWidget;
import com.zzg.service.ColumnWidgetService;

@Controller
@RequestMapping("/api/column-widget")
public class ColumnWidgetController {
	@Autowired
	private ColumnWidgetService service;
	
	// 分页查询
		@RequestMapping("/page")
		public Result getPage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
			//注意:分页代码PageHelper.startPage(pageNo,pageSize);只对其后的第一个查询有效。	
			PageHelper.startPage(pageNo,pageSize);
			List<ColumnWidget> list = service.selectAll();
			Result result = new Result();
			result.setData("list", list);
			result.setData("limit", pageNo);
			result.setData("page", pageSize);
			result.setData("total", list.size());
			return result;
		}
		
		// 插入
		@RequestMapping(value="/insert", method={RequestMethod.POST})
		@ResponseBody
		public Result insert(@RequestBody ColumnWidget entity) {
			int num = service.insert(entity);
			return Result.ok().setData("num", num);
		}
		
		// 更新
		@RequestMapping(value="/update", method={RequestMethod.POST})
		@ResponseBody
		public Result update(@RequestBody ColumnWidget entity) {
			int num = service.updateByPrimaryKey(entity);
			if(num > 0){
				return Result.ok();
			}
			return Result.error("更新失败");
		}
		
		// 删除
		@RequestMapping(value="/delete", method={RequestMethod.POST})
		@ResponseBody
		public Result delete(@RequestParam String sid) {
			Map<String,Object> parames = new HashMap<String,Object>();
			parames.put("sid", sid);
			parames.put("deleteFlag", "2"); // 删除状态
			int num = service.updateDeleteFlag(parames);
			if(num > 0){
				return Result.ok();
			}
			return Result.error("更新失败");
		}
}
