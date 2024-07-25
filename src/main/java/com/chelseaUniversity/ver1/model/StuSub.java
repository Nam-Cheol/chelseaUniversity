package com.chelseaUniversity.ver1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StuSub {

	private Integer id;
	private Integer studentId;
	private Integer subjectId;
	private String grade;
	private Integer completeGrade;
}
