package com.zzg.mapper;

import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.ColumnWidget;

public interface ColumnWidgetMapper extends BaseMapper<ColumnWidget> {
	int updateDeleteFlag(Map map);
}