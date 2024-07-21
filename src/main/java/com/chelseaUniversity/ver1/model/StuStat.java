package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class StuStat {

	private Integer id;
	private Integer studentId;
	private String status;
	private Date fromDate;
	private Date toDate;
	
}
