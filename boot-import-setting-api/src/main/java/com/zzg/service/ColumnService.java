package com.zzg.service;

import java.util.Map;
import com.zzg.common.core.service.BaseService;
import com.zzg.entity.Column;

public interface ColumnService extends BaseService<Column> {
	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(Column record);
}
