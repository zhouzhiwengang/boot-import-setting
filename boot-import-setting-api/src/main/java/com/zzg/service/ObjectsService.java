package com.zzg.service;

import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.Objects;

public interface ObjectsService extends BaseService<Objects> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Objects record);
}
