package com.zzg.mapper;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.Table;

public interface TableMapper extends BaseMapper<Table> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Table record);
	
	// 通用select 查询
	List<Table> select(Map map);
		
	// 表解绑指定数据源
	int unbind(String sid);
	
	List<Table> selectBySids(List<String> sids);

}