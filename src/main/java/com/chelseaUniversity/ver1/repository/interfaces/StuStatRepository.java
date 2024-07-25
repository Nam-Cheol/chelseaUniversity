package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoStatListDto;

/**
 * @author 서영
 * 학적 변동
 */
public interface StuStatRepository {

	// 해당 학생의 모든 학적 변동 내역 조회
	public List<StuStat> selectByStudentIdOrderbyIdDesc(Integer studentId);
	
	// 학생의 학적 상태 생성
	public int insert( Integer studentId,  String status, String toDate, Integer breakAppId);

	// 학생의 기존 학적 상태의 to_date를 now()로 변경 
	public int updateOldStatus(Integer id);
	
	// 학생 ID 값으로 STATUS 가져오기
	public StuStat selectStatusByStudentId(int id);
	
	/**
	 * 학생 내정보 조회에 학적변동리스트
	 * @author 김지현
	 */
	public List<StudentInfoStatListDto> selectStuStatListBystudentId(Integer studentId);
	
	// 기존 재학상태 -> 휴학
	public int updateStatusToBreak(String status, Integer id);
}
