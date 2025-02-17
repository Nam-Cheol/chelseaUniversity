package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.CollTuit;
import com.chelseaUniversity.ver1.model.Tuition;

/**
 * @author 서영
 *
 */

public interface TuitionRepository {

	// 특정 학생의 등록금 내역 조회
	public List<Tuition> selectByStudentId(Integer studentId);
	
	// 학생의 학과-단과대를 기준으로 등록금액 조회
	public CollTuit selectTuiAmountByStudentId(Integer studentId);
	
	// 등록금 고지서 생성
	public int insert(Tuition tuition);

	// 등록금 납부
	public int updateStatus(Integer studentId, Integer tuiYear, Integer semester);
	
	// 등록금 금액 전체 리스트
	public List<Tuition> selectAmount();
	
	// 등록금 금액 생성
	public int insertAmount(int id, int amount);
	
	// 등록금 금약 변경 id --> amount
	public int updateByIdAndAmount(int id, int amount);
	
}