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
	
	// 학생이 수강한 연도 조회
	public List<GradeDto> selectSubYearByStudentId(Integer studentId);
	
	// 학생이 수강한 학기 조회
	public List<GradeDto> selectSemesterByStudentId(Integer studentId);
	
	// 금학기 성적 조회
	public List<GradeDto> selectGradeDtoBySemester( Integer studentId, Integer semester,  Integer subYear);	
	
	// 학기별 성적조회 (전체 조회)
	public List<GradeDto> selectGradeDtoByStudentId(Integer studentId);
	
	// 학기별 성적조회 (선택 조회)
	public List<GradeDto> selectGradeDtoBytype(Integer studentId, Integer subYear, Integer semester, String type);

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
	
	// 연도 누계성적 조회
	public List<MyGradeDto> gradeinquiryBysubYear(Integer studentId, Integer subYear);
	
	
}
