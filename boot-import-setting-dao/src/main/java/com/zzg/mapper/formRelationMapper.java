package com.zzg.mapper;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.formRelation;

public interface formRelationMapper extends BaseMapper<formRelation> {
	// 通用查询
	List<formRelation> select(Map map);
}