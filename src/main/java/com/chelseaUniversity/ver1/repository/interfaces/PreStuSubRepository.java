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

	
	// 예비 수강 신청 내역 추가
	int insert(Integer studentId, Integer subjectId);
	
	// 예비 수강 신청 내역에 해당 강의가 있는 학생들 조회
	List<PreStuSub> selectBySubjectId(Integer subjectId);
	
}
