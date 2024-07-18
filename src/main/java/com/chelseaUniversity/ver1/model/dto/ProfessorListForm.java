package com.chelseaUniversity.ver1.model.dto;

import lombok.Data;

/**
 * 교수 리스트 보기 폼
 * @author 김지현
 */
@Data
public class ProfessorListForm {

	private Integer deptId;
	private Integer professorId;
	private Integer page;
	
}
