package com.chelseaUniversity.ver1.model;

import com.chelseaUniversity.ver1.utill.NumberUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 서영
 *
 */

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Tuition {

	private Integer studentId;
	private Integer tuiYear;
	private Integer semester;
	private Integer tuiAmount;
	private Integer schType;
	private Integer schAmount;
	private Boolean status;
	
	private Integer id;
	private Integer amount;
	private String name;
	/**
	 * @return 금액 형식으로 변환한 등록금
	 */
	public String tuiFormat() {
		return NumberUtil.numberFormat(tuiAmount);
	}
	
	/**
	 * @return 금액 형식으로 변환한 장학금
	 */
	public String schFormat() {
		return NumberUtil.numberFormat(schAmount);
	}
	
	/**
	 * @return 금액 형식으로 변환한 납부금
	 */
	public String paymentFormat() {
		Integer payAmount = tuiAmount - schAmount;
		return NumberUtil.numberFormat(payAmount);
	}

	public Tuition(Integer studentId, Integer tuiYear, Integer semester, Integer tuiAmount, Integer schType, Integer schAmount) {
		super();
		this.studentId = studentId;
		this.tuiYear = tuiYear;
		this.semester = semester;
		this.tuiAmount = tuiAmount;
		this.schType = schType;
		this.schAmount = schAmount;
	}
	
	
	
}
