package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.ChangePasswordDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;

public interface UserRepository {
	
	// 로그인용
	public User selectById_Password(int id, String password);
	
	public StudentInfoDto studentById(int id);
	
	public ProfessorInfoDto professorById(int id);
	
	public Staff staffById(int id);
	
	// 패스워드 변경
	public int updatePassword(ChangePasswordDto changePasswordDto);
	
	// 아이디찾기
	public int findId(String name,String email);
	
	// 비밀번호 찾기
	public String findPassword(int id,String name);
	
	// 학생유저 정보 변경
	public int updateStudent(StudentInfoDto student);
	
	// 교수유저 정보 변경
	public int updateProfessor(ProfessorInfoDto professor);
	
	// 교직원 유저 정보 변경
	public int updateStaff(Staff staff);
}
