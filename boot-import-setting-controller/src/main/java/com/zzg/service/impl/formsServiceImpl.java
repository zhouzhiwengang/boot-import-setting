package com.zzg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.forms;
import com.zzg.mapper.formsMapper;
import com.zzg.service.formsService;

@Service
public class formsServiceImpl implements formsService {
	@Autowired
	private formsMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(forms record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public forms selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<forms> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(forms record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

}
