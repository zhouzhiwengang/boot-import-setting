package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.Objects;
import com.zzg.mapper.ObjectsMapper;
import com.zzg.service.ObjectsService;

@Service
public class ObjectsServiceImpl implements ObjectsService {
	@Autowired
	private ObjectsMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(Objects record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public Objects selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<Objects> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Objects record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateDeleteFlag(Map map) {
		// TODO Auto-generated method stub
		return mapper.updateDeleteFlag(map);
	}

	@Override
	public int update(Objects record) {
		// TODO Auto-generated method stub
		return mapper.update(record);
	}

}
