package com.zzg.service;

import java.util.List;
import java.util.Map;
import com.zzg.common.core.service.BaseService;
import com.zzg.entity.Column;
import com.zzg.entity.Table;

public interface TableService extends BaseService<Table> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Table record);
	
	// 通用select 查询
	List<Table> select(Map map);
		
	// 表解绑指定数据源
	int unbind(String sid);
	
	List<Table> selectBySids(List<String> sids);
}

