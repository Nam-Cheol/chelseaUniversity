package com.chelseaUniversity.ver1.model;


import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notice {

	private Integer id;
	private String category;
	private String title;
	private String content;
	private Integer views;
	private Timestamp createdTime;
	
	private String uuidFilename;
	private String originFilename;
	
	public String setUpImage() {
		return "/images/uploads/" + uuidFilename;
	} 
}
