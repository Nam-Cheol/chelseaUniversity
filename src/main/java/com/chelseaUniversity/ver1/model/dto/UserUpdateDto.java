package com.chelseaUniversity.ver1.model.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
	
	private Integer userId;
	private String address;
	private String tel;
	private String email;
	
}
