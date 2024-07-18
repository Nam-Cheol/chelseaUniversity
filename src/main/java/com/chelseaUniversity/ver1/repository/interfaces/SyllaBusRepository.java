package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.dto.SyllaBusFormDto;

/**
 * 
 * 
 * @author 박성희
 */
public interface SyllaBusRepository {

	// 강의 등록 시, 강의 ID만 미리 저장
	public Integer insertOnlySubId(Integer subjectId);
	
	// 강의 삭제 시, 해당 강의 ID의 계획서 삭제
	public int delete(Integer subjectId);
	/**
	 * 강의계획서 업데이트
	 * @author 김지현
	 * @param syllaBusFormDto
	 * @return 실행 row count
	 */
	public int updateSyllabus(SyllaBusFormDto syllaBusFormDto);

}
