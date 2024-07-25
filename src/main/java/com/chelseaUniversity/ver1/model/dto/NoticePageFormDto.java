package com.chelseaUniversity.ver1.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticePageFormDto {
	
	
	// 페이징 처리
	private Integer page;
	private String keyword;
	private String type;
}
