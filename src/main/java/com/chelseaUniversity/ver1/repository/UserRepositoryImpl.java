package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.ChangePasswordDto;
import com.chelseaUniversity.ver1.model.dto.response.PrincipalDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
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
	public StudentInfoDto studentById(int id) {
		StudentInfoDto student = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_STUDENT_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				student = StudentInfoDto.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.tel(rs.getString("tel")).email(rs.getString("email")).deptId(rs.getInt("dept_id"))
						.grade(rs.getInt("grade")).semester(rs.getInt("semester")).entranceDate(rs.getDate("entrance_date"))
						.graduationDate(rs.getDate("graduation_date")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	// 교수 정보 받아오기
	@Override
	public ProfessorInfoDto professorById(int id) {
		ProfessorInfoDto professor = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_PROFESSOR_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				professor = ProfessorInfoDto.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("id")).hireDate(rs.getDate("hire_date")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professor;
	}

	// 교직원 정보 받아오기
	@Override
	public Staff staffById(int id) {
		Staff staff = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_STAFF_BYID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				staff = Staff.builder().id(rs.getInt("id")).name(rs.getString("name")).birthDate(rs.getDate("birth_date"))
						.gender(rs.getString("gender")).address(rs.getString("address")).tel(rs.getString("tel"))
						.email(rs.getString("email")).hireDate(rs.getDate("hire_date")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff;
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
