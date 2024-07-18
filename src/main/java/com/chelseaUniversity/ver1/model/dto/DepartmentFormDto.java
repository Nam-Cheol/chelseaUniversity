package com.chelseaUniversity.ver1.model.dto;

import lombok.Data;

/**
 * 
 * @author 박성희
 *
 */
@Data
public class DepartmentFormDto {
	private Integer id;
	private String name;
	private Integer collegeId;
	private String collegeName;
}
