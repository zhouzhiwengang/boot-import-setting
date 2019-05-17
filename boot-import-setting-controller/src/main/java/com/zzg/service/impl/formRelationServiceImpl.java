package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.formRelation;
import com.zzg.mapper.formRelationMapper;
import com.zzg.service.formRelationService;

@Service
public class formRelationServiceImpl implements formRelationService {
	@Autowired
	private formRelationMapper mapper;
	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(formRelation record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public formRelation selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<formRelation> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(formRelation record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<formRelation> select(Map map) {
		// TODO Auto-generated method stub
		return mapper.select(map);
	}

}
