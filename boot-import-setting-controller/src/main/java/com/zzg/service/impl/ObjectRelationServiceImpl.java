package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzg.entity.ObjectRelation;
import com.zzg.entity.pack.ObjectRelationPack;
import com.zzg.mapper.ObjectRelationMapper;
import com.zzg.service.ObjectRelationService;

@Service
public class ObjectRelationServiceImpl implements ObjectRelationService{
	@Autowired
	private ObjectRelationMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(ObjectRelation record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public ObjectRelation selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<ObjectRelation> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ObjectRelation record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ObjectRelationPack> select(Map map) {
		// TODO Auto-generated method stub
		return mapper.select(map);
	}
}
