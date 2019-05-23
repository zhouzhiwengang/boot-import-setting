package com.zzg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.SettingEntityField;
import com.zzg.mapper.SettingEntityFieldMapper;
import com.zzg.service.SettingEntityFieldService;

@Service
public class SettingEntityFieldServiceImpl implements SettingEntityFieldService {
	@Autowired
	private SettingEntityFieldMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(SettingEntityField record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public SettingEntityField selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<SettingEntityField> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(SettingEntityField record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
