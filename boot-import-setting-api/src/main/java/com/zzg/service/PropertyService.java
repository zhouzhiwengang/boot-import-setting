package com.zzg.service;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.Property;

public interface PropertyService extends BaseService<Property> {
	// 通用更新函数
	public void update(Map<String,Object> map);
	
	// 通用查询函数
	public List<Property> select(Map<String,Object> map);

}
