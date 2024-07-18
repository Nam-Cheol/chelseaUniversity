package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.PreStuSub;
import com.chelseaUniversity.ver1.model.dto.response.StuSubAppDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubDayTimeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubSumGradesDto;

/**
 * @author 서영
 *
 */
public interface PreStuSubRepository {

	// 학생의 예비 수강 신청 내역에 해당 강의가 있는지 조회
	PreStuSub selectByStudentIdAndSubjectId(Integer studentId, Integer subjectId);
	
	// 학생의 이번 학기 전체 예비 수강 신청 내역 조회
	List<StuSubAppDto> selectListByStudentIdAndSemester( Integer studentId, Integer subYear, Integer semester);
	
	// 학생의 예비 수강 신청 학점 조회
	StuSubSumGradesDto selectSumGrades( Integer studentId, Integer subYear, Integer semester);
	
	// 학생의 예비 수강 신청 내역 시간표 조회
	List<StuSubDayTimeDto> selectDayTime(Integer studentId);
	
	// 예비 수강 신청 내역 추가
	int insert(Integer studentId, Integer subjectId);
	
	// 예비 수강 신청 내역 삭제
	int delete( Integer studentId, Integer subjectId);
	
	// 예비 수강 신청 내역에 해당 강의가 있는 학생들 조회
	List<PreStuSub> selectBySubjectId(Integer subjectId);
	
}
