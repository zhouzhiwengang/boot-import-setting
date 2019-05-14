package com.zzg.mapper;

import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.Column;

public interface ColumnMapper extends BaseMapper<Column> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Column record);
}