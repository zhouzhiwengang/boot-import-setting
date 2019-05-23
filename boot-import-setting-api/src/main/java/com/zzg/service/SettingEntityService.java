package com.zzg.service;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.SettingEntity;

public interface SettingEntityService extends BaseService<SettingEntity> {
	
	// 通用功能功能查询
	public List<SettingEntity> select(Map map);
	
	// 通用功能删除
	public void delete(Map map);

}
