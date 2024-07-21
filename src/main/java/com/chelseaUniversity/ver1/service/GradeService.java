package com.chelseaUniversity.ver1.service;

import com.chelseaUniversity.ver1.model.dto.response.GradeForScholarshipDto;

public class GradeService {
	/**
	 * @author 서영 성적 평균 가져오기
	 */
	public GradeForScholarshipDto readAvgGrade(Integer studentId, Integer subYear, Integer semester) {
		GradeForScholarshipDto gradeEntity = gradeRespository.findAvgGradeByStudentIdAndSemester(studentId, subYear,
				semester);
		return gradeEntity;
	}
}
