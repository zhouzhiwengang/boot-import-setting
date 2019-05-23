package com.zzg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.entity.SettingImport;
import com.zzg.mapper.SettingImportMapper;
import com.zzg.service.SettingImportService;

@Service
public class SettingImportServiceImpl implements SettingImportService {
	@Autowired
	private SettingImportMapper mapper;

	@Override
	public int deleteByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sid);
	}

	@Override
	public int insert(SettingImport record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public SettingImport selectByPrimaryKey(String sid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(sid);
	}

	@Override
	public List<SettingImport> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(SettingImport record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public void updateDeleteFlag(Map map) {
		// TODO Auto-generated method stub
		mapper.updateDeleteFlag(map);
	}

}
