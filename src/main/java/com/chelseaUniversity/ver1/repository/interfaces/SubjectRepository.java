package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Subject;
import com.chelseaUniversity.ver1.model.dto.AllSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.CurrentSemesterSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.model.dto.response.ReadSyllabusDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectForProfessorDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectPeriodForProfessorDto;

/*
 *  박성희
 *  강의 repository
 */

public interface SubjectRepository {
	
	/**
	 * @author 서영
	 * @return 전체 강의 정보
	 */
	public List<SubjectFormDto> selectDtoAll(int limit, int offset);
	public List<SubjectFormDto> selectDtoSearch(int limit, int offset, String query, String type, String deptId, String name, int checkNum);
	/*
	 * @author 김지현
	 * @param id
	 * @return
	 */
	public Subject selectSubjectById(Integer id);
	
	public List<Subject> selectAll();

	/**
	 * @author 서영
	 * 현재 인원 수정 (1명 추가 or 삭제 or 0으로 초기화)
	 */
	public int updateNumOfStudent(Integer id, String type);
	
	
	/**
	 * @author 서영
	 * 정원 >= 신청인원인 강의의 id 리스트
	 */
	public List<Integer> selectIdByLessNumOfStudent();
	
	/**
	 * @author 서영
	 * 정원 < 신청인원인 강의의 id 리스트
	 */
	public List<Integer> selectIdByMoreNumOfStudent();
	int getTotalBoardCount(); 	
	
	public List<Subject> selectSubject();
	public int insert(String subjectName, int professorId, String roomId, int deptId, String type, int subYear, int semester, String subDay, int startTime, int endTime, int grades, int capacity, int numOfStudent);
	
	public List<Subject> getAllSubject(int limit, int offset);
	public int getTotalSubjectCount();
	
}
