package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.DataSource;
import com.zzg.mapper.DataSourceMapper;
import com.zzg.service.DataSourceService;

@Service
public class DataSourceServiceImpl implements DataSourceService {
	@Autowired
	private DataSourceMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(DataSource record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public DataSource selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<DataSource> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DataSource record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateDeleteFlag(Map map) {
		// TODO Auto-generated method stub
		return mapper.updateDeleteFlag(map);
	}

	@Override
	public int update(DataSource record) {
		// TODO Auto-generated method stub
		return mapper.update(record);
	}

}
