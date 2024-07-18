package com.chelseaUniversity.ver1.model.dto;

import lombok.Data;

/**
 * 
 * @author 박성희
 *
 */
@Data
public class TuitionFormDto {
	private String studentId;
	private String semester;
	private boolean status;
}
