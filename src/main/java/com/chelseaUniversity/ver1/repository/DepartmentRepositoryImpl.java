package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.dto.DepartmentFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.DepartmentRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class DepartmentRepositoryImpl implements DepartmentRepository{

	// TODO - Define 클래스로 이동 쿼리문
	public final String SELECT_DEPT_BY_ID = " SELECT * from department_tb WHERE id = ? ";
	public final String SELECT_ALL = " SELECT * FROM department_tb ";
	public final String UPDATE_DEPARTMENT = " UPDATE department_tb SET name = ? , college_id = ? where id = ? ";
	public final String INSERT_DEPARTMENT = " INSERT INTO department_tb( name, college_id ) VALUES ( ? , ? ) ";
	
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

	@Override
	public List<Department> selectAll() {
		List<Department> departmentList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL)){
				ResultSet set = pstmt.executeQuery();
				conn.commit();
				while (set.next()) {
					Department department = Department.builder()
							  			.id(set.getInt("id"))
							  			.name(set.getString("name"))
							  			.collegeId(set.getInt("college_id"))
							  			.build();
					departmentList.add(department);				
					}
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return departmentList;
	}

	@Override
	public int updateDepartment(int id, String name, int collegeId) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_DEPARTMENT)){
				pstmt.setString(1, name);
				pstmt.setInt(2, collegeId);
				pstmt.setInt(3, id);
				rowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return rowCount;
	}

	@Override
	public int insert(String name, int collegeId) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_DEPARTMENT)){
				pstmt.setString(1, name);
				pstmt.setInt(2, collegeId);
				rowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return rowCount;
	}

}
