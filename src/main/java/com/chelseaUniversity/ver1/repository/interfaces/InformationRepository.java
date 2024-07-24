package com.chelseaUniversity.ver1.repository.interfaces;

public interface InformationRepository {

	int changeDeptNameByDeptId(String deptName);
	
	String changeProNameByProId(int professorId);
	
	String changeCollegeNameByCollegeId(int collegeId);
	
}
