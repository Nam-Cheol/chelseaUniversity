package com.chelseaUniversity.ver1.model.dto;

import java.sql.Date;

import lombok.Data;

/**
 * staff_tb insert용
 * @author 김지현
 *
 */
@Data
public class CreateStaffDto {

	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	
}
