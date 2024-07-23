package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Department {

	private Integer id;
	private String name;
	private Integer collegeId;
}
