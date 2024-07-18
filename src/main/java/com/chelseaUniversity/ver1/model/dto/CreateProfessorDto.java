package com.chelseaUniversity.ver1.model.dto;

import java.sql.Date;

import lombok.Data;

/**
 * professor_tb insert용
 * @author 김지현
 *
 */
@Data
public class CreateProfessorDto {

	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private Integer deptId;
	private String email;
	
}
