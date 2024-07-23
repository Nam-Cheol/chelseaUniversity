package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StuSubDetail {

	private Integer id;
	private String name;
	private String deptName;
	private Integer absent;
	private Integer lateness;
	private Integer homework;
	private Integer midExam;
	private Integer finalExam;
	private Integer convertedMark;
	private String grade;
	
	
}
