package com.chelseaUniversity.ver1.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GradeDto {
	
	private Integer subYear;
	private Integer semester;
	private Integer subjectId;
	private Integer evaluationId;
	private String name;
	private String type;
	private String grade;
	private String grades;
	private String gradeValue;
	
}
