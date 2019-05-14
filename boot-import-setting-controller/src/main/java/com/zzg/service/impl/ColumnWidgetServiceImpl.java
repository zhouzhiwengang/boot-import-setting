package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.ColumnWidget;
import com.zzg.mapper.ColumnWidgetMapper;
import com.zzg.service.ColumnWidgetService;

@Service
public class ColumnWidgetServiceImpl implements ColumnWidgetService {
	@Autowired
	private ColumnWidgetMapper mapper;
	

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(ColumnWidget record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public ColumnWidget selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<ColumnWidget> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ColumnWidget record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateDeleteFlag(Map map) {
		// TODO Auto-generated method stub
		return mapper.updateDeleteFlag(map);
	}

	@Override
	public int update(ColumnWidget record) {
		// TODO Auto-generated method stub
		return mapper.update(record);
	}

}
