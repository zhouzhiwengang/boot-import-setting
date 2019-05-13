package com.zzg.mapper;

import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.ColumnValidate;

public interface ColumnValidateMapper extends BaseMapper<ColumnValidate> {
	int updateDeleteFlag(Map map);
	
	int update(ColumnValidate record);
}