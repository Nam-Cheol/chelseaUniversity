package com.chelseaUniversity.ver1.model;

import java.sql.Date;

import com.chelseaUniversity.ver1.utill.DateUtil;

import lombok.Builder;
import lombok.Data;

/**
 * @author 서영
 * 휴학 신청 내역
 */
@Data
@Builder
public class BreakApp {

	private Integer id;
	private Integer studentId;
	private Integer studentGrade;
	private Integer fromYear;
	private Integer fromSemester;
	private Integer toYear;
	private Integer toSemester;
	private String type;
	private Date appDate;
	private String status;
	
	public String appDateFormat() {
		return DateUtil.dateFormat(appDate);
	}
	
}
