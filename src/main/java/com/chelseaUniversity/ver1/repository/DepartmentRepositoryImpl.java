package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.dto.DepartmentFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.DepartmentRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class DepartmentRepositoryImpl implements DepartmentRepository{

	// TODO - Define 클래스로 이동 쿼리문
	public final String SELECT_DEPT_BY_ID = " SELECT * from department_tb WHERE id = ? ";
	
	@Override
	public int insert(DepartmentFormDto departmentFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Department selectById(Integer id) {
		Department department = null;
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_DEPT_BY_ID)){
				
				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					department = Department.builder()
								.id(rs.getInt("id"))
								.name(rs.getString("name"))
								.collegeId(rs.getInt("college_id"))
								.build();
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return department;
	}

	@Override
	public List<Department> selectByDepartmentDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByDepartmentDto(DepartmentFormDto departmentFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
