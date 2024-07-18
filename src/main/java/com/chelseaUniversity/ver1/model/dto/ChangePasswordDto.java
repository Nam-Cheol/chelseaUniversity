package com.chelseaUniversity.ver1.model.dto;

import lombok.Data;

@Data
public class ChangePasswordDto {

	private String beforePassword;
	private String afterPassword;
	private String passwordCheck;
	private Integer id;
	
}
