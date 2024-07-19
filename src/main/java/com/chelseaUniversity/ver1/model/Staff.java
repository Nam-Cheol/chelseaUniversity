package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Staff {

	private Integer id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Date hireDate;
	
}
