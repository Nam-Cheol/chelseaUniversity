package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.dto.DepartmentFormDto;

/*
 *  박성희
 *  학과 repository
 */

public interface DepartmentRepository {
	
	public Department selectById(Integer id);
	public List<Department> selectAll();
	public int updateDepartment(int id, String name, int collegeId);
	public int insert(String name, int collegeId);
	
	// 페이징 전체 리스트
	public List<Department> getAllDepartment(int limit, int offset);
	public int getTotalDepartmentCount();
	
}
