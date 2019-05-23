package com.zzg.service;

import java.util.List;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.Entity;

public interface EntityService extends BaseService<Entity> {
	
	List<Entity> selectBySids(List<String> sids);

}
