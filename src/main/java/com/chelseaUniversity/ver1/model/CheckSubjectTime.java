package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckSubjectTime {

	String subDay;
	String startTime;
	String endTime;
	
}
