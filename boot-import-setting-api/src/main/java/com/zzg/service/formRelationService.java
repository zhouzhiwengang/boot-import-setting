package com.zzg.service;

import java.util.List;
import java.util.Map;

import com.zzg.common.core.service.BaseService;
import com.zzg.entity.formRelation;

public interface formRelationService extends BaseService<formRelation> {
	// 通用查询
	List<formRelation> select(Map map);

}
