package com.chelseaUniversity.ver1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SyllabusDto {

	private int subjectId;
	private String overview;
	private String objective;
	private String textbook;
	private String program;

}
