package com.chelseaUniversity.ver1.model.dto;

import com.chelseaUniversity.ver1.utill.NumberUtil;

import lombok.Data;
/**
 * 
 * @author 박성희
 *
 */
@Data
public class CollTuitFormDto {
	private Integer collegeId;
	private String 	name;
	private Integer amount;

	public String amountFormat() {
		return NumberUtil.numberFormat(amount);
	}
	
}
