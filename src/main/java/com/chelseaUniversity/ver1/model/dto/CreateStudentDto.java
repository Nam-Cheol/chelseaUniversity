package com.chelseaUniversity.ver1.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * student_tb insert용
 * @author 김지현
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreateStudentDto {

	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private Integer deptId;
	private Date entranceDate;
	private String email;
	
}
