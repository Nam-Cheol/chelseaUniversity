package com.chelseaUniversity.ver1.model.dto.response;

import com.chelseaUniversity.ver1.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrincipalDto {

	private Integer id;
	private String password;
	private String userRole;
	private String name;
	
}
