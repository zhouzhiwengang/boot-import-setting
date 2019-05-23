package com.zzg.mapper;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.Property;

public interface PropertyMapper extends BaseMapper<Property> {
	// 通用更新函数
	public void update(Map<String, Object> map);
	
	// 通用查询函数
	public List<Property> select(Map<String,Object> map);
}