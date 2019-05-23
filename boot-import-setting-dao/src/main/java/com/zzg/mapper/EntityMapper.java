package com.zzg.mapper;

import java.util.List;

import com.zzg.common.core.mapper.BaseMapper;
import com.zzg.entity.Entity;

public interface EntityMapper extends BaseMapper<Entity> {
	List<Entity> selectBySids(List<String> sids);
}