package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StuSub {

	private Integer id;
	private Integer studentId;
	private Integer subjectId;
	private String grade;
	private Integer completeGrade;
}
