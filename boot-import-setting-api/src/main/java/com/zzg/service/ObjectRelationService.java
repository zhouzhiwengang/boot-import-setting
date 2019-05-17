package com.zzg.service;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.ObjectRelation;
import com.zzg.entity.pack.ObjectRelationPack;

public interface ObjectRelationService extends BaseService<ObjectRelation> {
	List<ObjectRelationPack> select(Map map);
}
