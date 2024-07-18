package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;

/**
 * stu_sub_detail_tb DAO
 * @author 김지현
 *
 */
public interface StuSubDetailRepository {
	
	// 학생 성적 업데이트
	int updateGrade(UpdateStudentGradeDto updateStudentGradeDto);

	/**
	 * @author 서영
	 */
	int insert( Integer id, Integer studentId, Integer subjectId);
	
}
