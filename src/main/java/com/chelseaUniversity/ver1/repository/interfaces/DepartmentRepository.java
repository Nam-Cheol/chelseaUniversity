package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.dto.DepartmentFormDto;

/*
 *  박성희
 *  학과 repository
 */

public interface DepartmentRepository {
	public int insert(DepartmentFormDto departmentFormDto);
	
	public Department selectById(Integer id);
	public List<Department> selectByDepartmentDto();
	public int deleteById(Integer id);
	public int updateByDepartmentDto(DepartmentFormDto departmentFormDto);
	public List<Department> selectAll();
	public int updateDepartment(int id, String name, int collegeId);
	public int insert(String name, int collegeId);
	
}
