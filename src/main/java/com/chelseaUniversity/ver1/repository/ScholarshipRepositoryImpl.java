package com.chelseaUniversity.ver1.repository;

import com.chelseaUniversity.ver1.model.Scholarship;
import com.chelseaUniversity.ver1.model.StuSch;
import com.chelseaUniversity.ver1.repository.interfaces.ScholarshipRepository;

public class ScholarshipRepositoryImpl implements ScholarshipRepository{

	@Override
	public Scholarship selectByStudentIdAndSemester(Integer studentId, Integer schYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCurrentSchType(StuSch stuSch) {
		// TODO Auto-generated method stub
		return 0;
	}

}
