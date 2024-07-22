package com.chelseaUniversity.ver1.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 장학금 유형 결정을 위한 성적을 가져오는 Dto
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeForScholarshipDto {

	private Integer studentId;
	private Integer subYear;
	private Integer semester;
	private Double avgGrade;
	
}
