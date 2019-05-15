package com.zzg.service;

import java.util.Map;
import com.zzg.common.core.service.BaseService;
import com.zzg.entity.DataSource;

public interface DataSourceService extends BaseService<DataSource> {

	// 更新通用功能
	int updateDeleteFlag(Map map);

	int update(DataSource record);
}
