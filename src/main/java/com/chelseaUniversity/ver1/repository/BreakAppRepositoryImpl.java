package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.model.dto.BreakAppFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.BreakAppRepository;

public class BreakAppRepositoryImpl implements BreakAppRepository{

	@Override
	public int insert(BreakAppFormDto breakAppFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BreakApp> selectByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BreakApp> selectByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreakApp selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Integer id, String status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
