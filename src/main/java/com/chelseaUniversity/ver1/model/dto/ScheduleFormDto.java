package com.chelseaUniversity.ver1.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleFormDto {

	private Integer id;
	private Integer staffId;
	private String startDay;
	private String endDay;
	private String information;
}
