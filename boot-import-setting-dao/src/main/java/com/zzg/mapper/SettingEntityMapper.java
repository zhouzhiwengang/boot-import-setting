package com.zzg.mapper;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.SettingEntity;

public interface SettingEntityMapper extends BaseMapper<SettingEntity> {

	// 通过功能功能查询
	public List<SettingEntity> select(Map map);

	// 通用功能删除
	public void delete(Map map);

}