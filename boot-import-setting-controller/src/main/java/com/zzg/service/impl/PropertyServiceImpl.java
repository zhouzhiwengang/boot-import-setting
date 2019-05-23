package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.Property;
import com.zzg.mapper.PropertyMapper;
import com.zzg.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(Property record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public Property selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<Property> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Property record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		mapper.update(map);
	}

	@Override
	public List<Property> select(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.select(map);
	}

}
