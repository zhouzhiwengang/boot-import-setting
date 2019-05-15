package com.zzg.service;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.Column;

public interface ColumnService extends BaseService<Column> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Column record);
	
	// 通用select 查询
	List<Column> select(Map map);
	
	// 字段解绑指定表
	int unbind(String sid);
}
