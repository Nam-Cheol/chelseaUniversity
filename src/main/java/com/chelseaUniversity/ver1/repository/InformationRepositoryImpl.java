package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chelseaUniversity.ver1.repository.interfaces.InformationRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class InformationRepositoryImpl implements InformationRepository{

	private static final String SELECT_DEPT_ID = " SELECT id FROM department_tb WHERE name = ? ";
	private static final String SELECT_PROFESSOR_NAME = " SELECT name FROM professor_tb WHERE id = ? ";
	private static final String SELECT_COLLEGE_NAME = " SELECT name FROM college_tb WHERE id = ? ";
	
	@Override
	public int changeDeptNameByDeptId(String deptName) {
		
		int deptId = 0;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_DEPT_ID)){
			
			pstmt.setString(1, deptName);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				deptId = rs.getInt("id");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deptId;
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

	

}
