package com.chelseaUniversity.ver1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SyllabusDto {

	private int subject_id;
	private String overview;
	private String objective;
	private String textbook;
	private String program;

}
