package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.dto.CreateStudentDto;
import com.chelseaUniversity.ver1.model.dto.FindIdFormDto;
import com.chelseaUniversity.ver1.model.dto.FindPasswordFormDto;
import com.chelseaUniversity.ver1.model.dto.StudentListForm;
import com.chelseaUniversity.ver1.model.dto.UserUpdateDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.UserInfoForUpdateDto;

/**
 * Student DAO
 * 
 * @author 김지현
 */
public interface StudentRepository {

	// student_tb에 insert
	public int insertToStudent(CreateStudentDto createStudentDto);

	/**
	 * @author 서영 전체 학생의 id만 가져오기
	 */
	public List<Integer> selectIdList();

	/**
	 * @author 서영 특정 학생의 정보 가져오기
	 */
	public Student selectByStudentId(Integer studentId);

	// 페이지별 학생 조회
	public List<Student> selectStudentList(String deptId, String studentId, int limit, int offset);

	public List<Student> selectStudentList(int limit, int offset);

	// 페이지, 과별 학생조회
	public List<Student> selectByDepartmentId(StudentListForm studentListForm);

	// 학번으로 학생 조회
	public List<Student> selectByStudentIdList(StudentListForm studentListForm);

	// 페이징 처리 위한 전체 학생 수 조회
	public Integer selectStudentAmount();

	public Integer selectStudentAmount(String deptId, String studentId);



}
