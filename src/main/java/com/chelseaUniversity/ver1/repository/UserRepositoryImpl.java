package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.ChangePasswordDto;
import com.chelseaUniversity.ver1.model.dto.response.PrincipalDto;
import com.chelseaUniversity.ver1.repository.interfaces.UserRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	@Override
	public PrincipalDto selectById(Integer userId) {
		PrincipalDto principal = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(null)){
		} catch (Exception e) {
			e.printStackTrace();
		}
		return principal;
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
