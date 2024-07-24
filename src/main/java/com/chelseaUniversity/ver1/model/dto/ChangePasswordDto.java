package com.chelseaUniversity.ver1.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePasswordDto {

	private String beforePassword;
	private String afterPassword;
	private String passwordCheck;
	private Integer id;
	
}
