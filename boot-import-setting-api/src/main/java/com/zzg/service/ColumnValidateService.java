package com.zzg.service;

import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.ColumnValidate;

public interface ColumnValidateService extends BaseService<ColumnValidate> {
	// 更新通用功能
	int updateDeleteFlag(Map map);
	
	int update(ColumnValidate record);
}
