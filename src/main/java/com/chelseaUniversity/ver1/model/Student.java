package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Student {
	
	private Integer id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Integer deptId;
	private Integer grade;
	private Integer semester;
	private Date entranceDate;
	private Date graduationDate;
}
