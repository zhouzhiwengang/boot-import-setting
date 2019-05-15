package com.zzg.mapper;

import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.DataSource;

public interface DataSourceMapper extends BaseMapper<DataSource> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(DataSource record);
}