package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.dto.CreateStudentDto;
import com.chelseaUniversity.ver1.model.dto.FindIdFormDto;
import com.chelseaUniversity.ver1.model.dto.FindPasswordFormDto;
import com.chelseaUniversity.ver1.model.dto.StudentListForm;
import com.chelseaUniversity.ver1.model.dto.UserUpdateDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.UserInfoForUpdateDto;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository{

	@Override
	public int insertToStudent(CreateStudentDto createStudentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer selectIdByCreateStudentDto(CreateStudentDto createStudentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoForUpdateDto selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudent(UserUpdateDto userUpdateDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StudentInfoDto selectStudentInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectIdByNameAndEmail(FindIdFormDto findIdFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectStudentByIdAndNameAndEmail(FindPasswordFormDto findPasswordFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectStudentList(StudentListForm studentListForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectByDepartmentId(StudentListForm studentListForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectByStudentId(StudentListForm studentListForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectStudentAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectStudentAmountByDeptId(Integer deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudentGradeAndSemester1_2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentGradeAndSemester2_1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentGradeAndSemester2_2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentGradeAndSemester3_1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentGradeAndSemester3_2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentGradeAndSemester4_1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentGradeAndSemester4_2() {
		// TODO Auto-generated method stub
		return 0;
	}

}
