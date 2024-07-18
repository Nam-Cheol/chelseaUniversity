package com.chelseaUniversity.ver1.model.dto;

import lombok.Data;

/**
 * 비밀번호 찾기 폼
 * @author 김지현
 *
 */
@Data
public class FindPasswordFormDto {

	private String name;
	private Integer id;
	private String email;
	private String userRole;
	
}
