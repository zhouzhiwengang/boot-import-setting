package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzg.entity.SettingEntity;
import com.zzg.mapper.SettingEntityMapper;
import com.zzg.service.SettingEntityService;

@Service
public class SettingEntityServiceImpl implements SettingEntityService {
	@Autowired
	private SettingEntityMapper mapper;
	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(SettingEntity record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public SettingEntity selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<SettingEntity> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(SettingEntity record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SettingEntity> select(Map map) {
		// TODO Auto-generated method stub
		return mapper.select(map);
	}

	@Override
	public void delete(Map map) {
		// TODO Auto-generated method stub
		mapper.delete(map);
	}

}
