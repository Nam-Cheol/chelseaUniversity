package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.model.dto.BreakAppFormDto;

/**
 * @author 서영
 *
 */
public interface BreakAppRepository {

	// 휴학 신청하기
	public int insert(BreakAppFormDto breakAppFormDto);
	
	// 학생의 휴학 신청 조회하기
	public List<BreakApp> selectByStudentId(Integer studentId);
	
	// TODO - 추가, 하나의 휴학신청서 가져오기
	public BreakApp selectByStudentIdOne(Integer studentId);
	
	// 처리되지 않은 휴학 신청 조회하기 (교직원용)
	public List<BreakApp> selectByStatus(String status);
	
	// 특정 휴학 신청서 조회하기
	public BreakApp selectById(Integer id);
	
	// 휴학 신청 취소하기 (학생용)
	public int deleteById(Integer id);
	
	// 휴학 신청 처리하기 (교직원용)
	public int updateById(Integer id, String status);
	
}
