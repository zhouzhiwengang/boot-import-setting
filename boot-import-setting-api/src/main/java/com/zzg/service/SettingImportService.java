package com.zzg.service;

import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.SettingImport;

public interface SettingImportService extends BaseService<SettingImport> {
	// 通用更新删除标识
	public void updateDeleteFlag(Map map);
}
