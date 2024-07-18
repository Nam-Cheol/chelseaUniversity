package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.ChangePasswordDto;
import com.chelseaUniversity.ver1.model.dto.response.PrincipalDto;

public interface UserRepository {
	
	// 로그인용
	public PrincipalDto selectById(Integer userId);
	
	// 패스워드 변경
	public int updatePassword(ChangePasswordDto changePasswordDto);
	
	// id 이용해서 user_tb에 insert
	public int insertToUser(User user);

}
