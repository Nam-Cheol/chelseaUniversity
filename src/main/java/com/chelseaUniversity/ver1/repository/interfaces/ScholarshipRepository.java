package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.Scholarship;
import com.chelseaUniversity.ver1.model.StuSch;

/**
 * @author 서영
 *
 */

public interface ScholarshipRepository {

	// 학생의 특정 학기 장학금 유형에 따른 최대 지원 금액
	public Scholarship selectByStudentIdAndSemester( Integer studentId, Integer schYear, Integer semester);
	
	// 학생의 이번 학기 장학금 유형 결정
	public int insertCurrentSchType(StuSch stuSch);
	
}
