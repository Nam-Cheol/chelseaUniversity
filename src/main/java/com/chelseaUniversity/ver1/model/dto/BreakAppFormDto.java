package com.chelseaUniversity.ver1.model.dto;
import lombok.Data;

/**
 * @author 서영
 *
 */

@Data
public class BreakAppFormDto {
	
	private Integer studentId;
	private Integer studentGrade;
	private Integer fromYear;
	private Integer fromSemester;
	private Integer toYear;
	private Integer toSemester;
	private String type;
	
}
