package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubAppDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubDayTimeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubSumGradesDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoForProfessorDto;

public interface StuSubRepository {


	/**
	 * stu_sub_tb의 grade 컬럼에 성적 입력
	 * 
	 * @author 김지현
	 * @return 실행 결과 row 수
	 */
	void updateGradeByStudentIdAndSubjectId(StuSubDetail stuSubDetail);

	/**
	 * @author 서영 수강 신청 관련
	 */
	// 학생의 수강 신청 내역에 해당 강의가 있는지 조회
	StuSub selectByStudentIdAndSubjectId(Integer studentId, Integer subjectId);


	// 수강 신청 내역 추가
	int insert(Integer studentId, Integer subjectId);

	// 예비 수강신청 실패한 과목
	int insertFailSub(Integer studentId, Integer subjectId);
}
