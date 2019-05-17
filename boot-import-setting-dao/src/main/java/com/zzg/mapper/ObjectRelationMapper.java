package com.zzg.mapper;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.ObjectRelation;
import com.zzg.entity.pack.ObjectRelationPack;

public interface ObjectRelationMapper extends BaseMapper<ObjectRelation> {
	
	List<ObjectRelationPack> select(Map map);
}