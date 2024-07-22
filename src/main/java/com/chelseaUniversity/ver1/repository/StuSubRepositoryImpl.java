package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubAppDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubDayTimeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubSumGradesDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoForProfessorDto;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubRepository;

public class StuSubRepositoryImpl implements StuSubRepository{

	@Override
	public List<StudentInfoForProfessorDto> selectBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGradeByStudentIdAndSubjectId(UpdateStudentGradeDto updateStudentGradeDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StuSub selectByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {

		
		
		
		
		
		
		
		
		
		
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
	public List<StuSubDayTimeDto> selectDayTime(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Integer studentId, Integer subjectId) {

		
		
		
		
		
		
		
		
		
		
		return 0;
	}

	@Override
	public int delete(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StuSubAppDto> selectJoinListByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCompleteGradeByStudentIdAndSubjectId(Integer studentId, Integer subjectId, Integer completeGrade) {
		// TODO Auto-generated method stub
		return 0;
	}

}
