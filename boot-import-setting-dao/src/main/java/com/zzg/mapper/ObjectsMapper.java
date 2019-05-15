package com.zzg.mapper;

import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.Objects;

public interface ObjectsMapper extends BaseMapper<Objects> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Objects record);
}