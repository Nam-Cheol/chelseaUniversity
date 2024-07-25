package com.chelseaUniversity.ver1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StuSubDetail {

	private Integer id;
	private Integer subjectId;
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
