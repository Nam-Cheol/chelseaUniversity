package com.chelseaUniversity.ver1.model;

import lombok.Data;

@Data
public class StuSub {

	private Integer id;
	private Integer studentId;
	private Integer subjectId;
	private String grade;
	private Integer completeGrade;
}
