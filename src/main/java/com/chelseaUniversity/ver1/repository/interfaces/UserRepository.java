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
	
	// id 이용해서 user_tb에 insert
	public int insertToUser(User user);

	// 아이디찾기
	public int findId(String name,String email);
	
	// 비밀번호 찾기
	public String findPassword(int id,String name);
}
