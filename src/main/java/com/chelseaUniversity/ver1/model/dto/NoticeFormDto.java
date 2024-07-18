package com.chelseaUniversity.ver1.model.dto;

import java.sql.Timestamp;

import com.chelseaUniversity.ver1.utill.TimestampUtil;

import lombok.Data;
/**
 * 
 * @author 박성희
 *
 */
@Data
public class NoticeFormDto {
	private Integer id;
	private Integer noticeId;
	private String category;
	private String title;
	private String content;
	private Integer views;
	private Timestamp createdTime;
//	private MultipartFile file;
	private String originFilename;
	private String uuidFilename;
	
	// 공지 시간 처리 (날짜 시간)
	public String timeFormat() {
		TimestampUtil timestampUtil = new TimestampUtil();
		return timestampUtil.dateTimeToString(createdTime);
	}
	
	// 공지 시간 처리 (날짜)
	public String dateFormat() {
		TimestampUtil timestampUtil = new TimestampUtil();
		return timestampUtil.dateToString(createdTime);
	}
	
}
