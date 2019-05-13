package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.ColumnValidate;
import com.zzg.mapper.ColumnValidateMapper;
import com.zzg.service.ColumnValidateService;

@Service
public class ColumnValidateServiceImpl implements ColumnValidateService {
	@Autowired
	private ColumnValidateMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(ColumnValidate record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public ColumnValidate selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<ColumnValidate> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ColumnValidate record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateDeleteFlag(Map map) {
		// TODO Auto-generated method stub
		return mapper.updateDeleteFlag(map);
	}

	@Override
	public int update(ColumnValidate record) {
		// TODO Auto-generated method stub
		return mapper.update(record);
	}

}
