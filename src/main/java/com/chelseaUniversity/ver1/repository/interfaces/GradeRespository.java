package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.GradeDto;
import com.chelseaUniversity.ver1.model.dto.response.GradeForScholarshipDto;
import com.chelseaUniversity.ver1.model.dto.response.MyGradeDto;

/**
 * 
 * @author 편용림
 *
 */
public interface GradeRespository {
	
	// 금학기 성적 조회
	public List<GradeDto> selectGradeDtoBySemester( Integer studentId, Integer semester,  Integer subYear);	
	
	// 전체 찾는거
	public List<GradeDto> selectGradeDtoByStudentIdAndSubYear( Integer studentId,  Integer subYear,  Integer semester);

	// 누계성적 조회
	public MyGradeDto  selectMyGradeDtoBySemester(Integer studentId, Integer subYear, Integer semester);
		
	/**
	 * @author 서영
	 * 장학금 유형 결정을 위한 성적 평균을 가져옴
	 */
	public GradeForScholarshipDto findAvgGradeByStudentIdAndSemester(Integer studentId, Integer subYear, Integer semester);

	// 전체 누계성적 조회
	public List<MyGradeDto> selectMyGradeDtoByStudentId(Integer studentId);
	
}
