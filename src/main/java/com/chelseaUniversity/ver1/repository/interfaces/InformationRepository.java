package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.CollegeAndDeptInfoDTO;

public interface InformationRepository {

	String changeDeptNameByDeptId(int deptId);
	
	String changeProNameByProId(int professorId);
	
	String changeCollegeNameByCollegeId(int collegeId);
	
	List<CollegeAndDeptInfoDTO> collegeAndDeptInfo();
	
}
