package com.zzg.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzg.entity.Table;
import com.zzg.mapper.TableMapper;
import com.zzg.service.TableService;

@Service
public class TableServiceImpl implements TableService {
	@Autowired
	private TableMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(Table record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public Table selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<Table> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Table record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateDeleteFlag(Map map) {
		// TODO Auto-generated method stub
		return mapper.updateDeleteFlag(map);
	}

	@Override
	public int update(Table record) {
		// TODO Auto-generated method stub
		return mapper.update(record);
	}

	@Override
	public List<Table> select(Map map) {
		// TODO Auto-generated method stub
		return mapper.select(map);
	}

	@Override
	public int unbind(String sid) {
		// TODO Auto-generated method stub
		return mapper.unbind(sid);
	}

	@Override
	public List<Table> selectBySids(List<String> sids) {
		// TODO Auto-generated method stub
		return mapper.selectBySids(sids);
	}
}
