package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Schedule {

	private Integer id;
	private Integer staffId;
	private Date startDay;
	private Date endDay;
	private String information;
	private Integer years;
	private Integer months;
}
