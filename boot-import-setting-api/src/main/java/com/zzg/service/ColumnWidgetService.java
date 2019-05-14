package com.zzg.service;

import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.ColumnWidget;

public interface ColumnWidgetService extends BaseService<ColumnWidget> {
	// 功能删除方法
	int updateDeleteFlag(Map map);
	
	int update(ColumnWidget record);

}
