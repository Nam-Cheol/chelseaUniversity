package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StuStat {

	private Integer id;
	private Integer studentId;
	private String status;
	private Date fromDate;
	private Date toDate;
	
}
