package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoStatListDto;
import com.chelseaUniversity.ver1.repository.interfaces.StuStatRepository;

public class StuStatRepositoryImpl implements StuStatRepository{

	@Override
	public List<StuStat> selectByStudentIdOrderbyIdDesc(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Integer studentId, String status, String toDate, Integer breakAppId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOldStatus(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentInfoStatListDto> selectStuStatListBystudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
