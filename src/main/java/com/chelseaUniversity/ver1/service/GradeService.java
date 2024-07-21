package com.chelseaUniversity.ver1.service;

import com.chelseaUniversity.ver1.model.dto.response.GradeForScholarshipDto;
import com.chelseaUniversity.ver1.repository.GradeRespositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.GradeRespository;

public class GradeService {
	
	GradeRespository gradeRespository = new GradeRespositoryImpl();
	GradeForScholarshipDto gradeEntity;
	
	/**
	 * 학생 성적 평균
	 */
	public GradeForScholarshipDto readAvgGrade(Integer studentId, Integer subYear, Integer semester) {
		GradeForScholarshipDto gradeEntity = gradeRespository.findAvgGradeByStudentIdAndSemester(studentId, subYear,
				semester);
		return gradeEntity;
	}
}
