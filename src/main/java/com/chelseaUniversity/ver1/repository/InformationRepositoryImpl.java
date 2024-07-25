package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.CollegeAndDeptInfoDTO;
import com.chelseaUniversity.ver1.repository.interfaces.InformationRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class InformationRepositoryImpl implements InformationRepository{

	private static final String SELECT_DEPT_ID = " SELECT name FROM department_tb WHERE id = ? ";
	private static final String SELECT_PROFESSOR_NAME = " SELECT name FROM professor_tb WHERE id = ? ";
	private static final String SELECT_COLLEGE_NAME = " SELECT name FROM college_tb WHERE id = ? ";
	private static final String SELECT_COLLEGE_AND_DEPT_INFO = " SELECT d.id AS id, d.name AS d_name, c.name AS c_name FROM department_tb AS d JOIN college_tb AS c ON d.college_id = c.id ";
	
	@Override
	public String changeDeptNameByDeptId(int deptId) {
		
		String deptName = null;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_DEPT_ID)){
			
			pstmt.setInt(1, deptId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				deptName = rs.getString("name");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deptName;
	}

	@Override
	public String changeProNameByProId(int professorId) {

		String professorName = null;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_PROFESSOR_NAME)){
			
			pstmt.setInt(1, professorId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				professorName = rs.getString("name");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return professorName;
	}

	@Override
	public String changeCollegeNameByCollegeId(int collegeId) {

		String collegeName = null;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_COLLEGE_NAME)){
			
			pstmt.setInt(1, collegeId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				collegeName = rs.getString("name");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return collegeName;
	}

	@Override
	public List<CollegeAndDeptInfoDTO> collegeAndDeptInfo() {
		List<CollegeAndDeptInfoDTO> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_COLLEGE_AND_DEPT_INFO)){
			
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	

}
