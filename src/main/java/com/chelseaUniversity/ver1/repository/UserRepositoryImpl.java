package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.ChangePasswordDto;
import com.chelseaUniversity.ver1.model.dto.response.PrincipalDto;
import com.chelseaUniversity.ver1.repository.interfaces.UserRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	private final String GET_USER_LOGIN = " SELECT * FROM user_tb WHERE id = ? and password = ? ";
	private final String GET_STUDENT_BYID = " SELECT * FROM student_tb WHERE id = ?";
	private final String GET_PROFESSOR_BYID = " SELECT * FROM professor_tb WHERE id = ?";
	private final String GET_STAFF_BYID = " SELECT * FROM staff_tb WHERE id = ?";
	
	// 로그인 검사
	@Override
	public User selectById_Password(int id , String password) {
		User principal = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_USER_LOGIN)){
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				principal = User.builder().id(rs.getInt("id"))
						.password(rs.getString("password"))
						.userRole(rs.getString("user_role")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return principal;
	}

	// 로그인성공시 유저정보 받아오기
	// 학생 정보 받아오기
	@Override
	public String studentById(int id) {
		String name = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_STUDENT_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	// 교수 정보 받아오기
	@Override
	public String professorById(int id) {
		String name = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_PROFESSOR_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	// 교직원 정보 받아오기
	@Override
	public String staffById(int id) {
		String name = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_STAFF_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	
	@Override
	public int updatePassword(ChangePasswordDto changePasswordDto) {
		return 0;
	}

	@Override
	public int insertToUser(User user) {
		return 0;
	}

	
	

}
