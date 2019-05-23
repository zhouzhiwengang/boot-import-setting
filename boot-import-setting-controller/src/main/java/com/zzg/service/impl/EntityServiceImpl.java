package com.zzg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.Entity;
import com.zzg.mapper.EntityMapper;
import com.zzg.service.EntityService;

@Service
public class EntityServiceImpl implements EntityService {
	@Autowired
	private EntityMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(Entity record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public Entity selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<Entity> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Entity record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Entity> selectBySids(List<String> sids) {
		// TODO Auto-generated method stub
		return mapper.selectBySids(sids);
	}

}
