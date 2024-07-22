package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.PreStuSub;
import com.chelseaUniversity.ver1.model.dto.response.StuSubAppDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubDayTimeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubSumGradesDto;
import com.chelseaUniversity.ver1.repository.interfaces.PreStuSubRepository;

public class PreStuSubRepositoryImpl implements PreStuSubRepository{

	@Override
	public PreStuSub selectByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StuSubAppDto> selectListByStudentIdAndSemester(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StuSubSumGradesDto selectSumGrades(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StuSubDayTimeDto> selectDayTime(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PreStuSub> selectBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
