package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Schedule {

	private Integer id;
	private Integer staffId;
	private Date startDay;
	private Date endDay;
	private String information;
	private Integer years;
	private Integer months;
}
