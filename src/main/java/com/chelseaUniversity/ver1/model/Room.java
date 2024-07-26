package com.chelseaUniversity.ver1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {

	private String id;
	private Integer collegeId;
	
}
