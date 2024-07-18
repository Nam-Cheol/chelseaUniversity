package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.dto.CreateStaffDto;
import com.chelseaUniversity.ver1.model.dto.FindIdFormDto;
import com.chelseaUniversity.ver1.model.dto.FindPasswordFormDto;
import com.chelseaUniversity.ver1.model.dto.UserUpdateDto;
import com.chelseaUniversity.ver1.model.dto.response.UserInfoForUpdateDto;

/**
 * Staff DAO
 * 
 * @author 김지현
 */
public interface StaffRepository {

	// staff_tb에 insert
	public int insertToStaff(CreateStaffDto createStaffDto);

	// staff_tb에서 자동 생성된 id 받아오기
	public Integer selectIdByCreateStaffDto(CreateStaffDto createStaffDto);

	// 업데이트용 정보 읽기
	public UserInfoForUpdateDto selectByUserId(Integer userId);

	// 유저정보 업데이트
	public int updateStaff(UserUpdateDto userUpdateDto);
	
	// id로 staff 모델 불러오기
	public Staff selectStaffById(Integer Id);
	
	// id 찾기
	public Integer selectIdByNameAndEmail(FindIdFormDto findIdFormDto);
	
	// password 발급용 model 확인
	public Integer selectStaffByIdAndNameAndEmail(FindPasswordFormDto findPasswordFormDto);

}
