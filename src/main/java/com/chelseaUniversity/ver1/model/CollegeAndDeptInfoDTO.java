package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CollegeAndDeptInfoDTO {

	String id;
	String dName;
	String cName;
	
}
