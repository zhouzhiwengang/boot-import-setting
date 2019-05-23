package com.zzg.mapper;

import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.SettingImport;

public interface SettingImportMapper extends BaseMapper<SettingImport> {

	// 通用更新删除标识
	public void updateDeleteFlag(Map map);
}