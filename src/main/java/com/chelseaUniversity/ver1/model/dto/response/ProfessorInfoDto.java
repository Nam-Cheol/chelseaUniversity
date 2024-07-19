package com.chelseaUniversity.ver1.model.dto.response;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorInfoDto {

	private Integer id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Integer deptId;
	private Date hireDate;
	private String deptName;
	private String collegeName;
}
