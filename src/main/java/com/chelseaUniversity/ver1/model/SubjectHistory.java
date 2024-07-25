package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectHistory {

	String id;
	String title;
	String professorName;
	String grades;
	String subDay;
	String startTime;
	String endTime;
	String roomId;
	String capacity;
	String numOfStudent;
	
}
