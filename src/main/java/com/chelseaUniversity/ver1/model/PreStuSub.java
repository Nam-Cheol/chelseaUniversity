package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreStuSub {

	private Integer studentId;
	private Integer subjectId;
	
	public PreStuSub(Integer studentId, Integer subjectId) {
		this.studentId = studentId;
		this.subjectId = subjectId;
	}

	public PreStuSub() {
	}
	
}
