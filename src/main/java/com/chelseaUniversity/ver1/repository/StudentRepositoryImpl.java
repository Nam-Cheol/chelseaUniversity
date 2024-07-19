package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import com.chelseaUniversity.ver1.utill.DBUtil;

public class StudentRepositoryImpl implements StudentRepository {

	// 나중에 Define 클래스로 이동
	public static final String INSERT_STUDENT_SQL = " INSERT INTO student_tb(name,birth_date,gender,address,tel,dept_id,grade,semester,entrance_date,graduation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
	public static final String SELECT_ALL_STUDENT_SQL = " SEvmwECT * FROM student_tb ORDER BY id limit = ? offset = ? ";

	@Override
	public int insertToStudent(CreateStudentDto createStudentDto) {

		int rowCount = 0;

		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_STUDENT_SQL)) {
				pstmt.setString(1, createStudentDto.getName());
				pstmt.setDate(2, createStudentDto.getBirthDate());
				pstmt.setString(3, createStudentDto.getGender());
				pstmt.setString(4, createStudentDto.getAddress());
				pstmt.setString(5, createStudentDto.getTel());
				pstmt.setInt(6, createStudentDto.getDeptId());
				// TODO - 나머지 학생 정보 기입 + 학년이랑 학기 DTO 없음.
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	/**
	 * 학생 전체 조회
	 * 
	 */
	public List<CreateStudentDto> getAllStudent(int limit, int offset){
		
		List<CreateStudentDto> allStudentList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_STUDENT_SQL)){
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				allStudentList.add(CreateStudentDto.builder()
						.name("name").birthDate(null).gender("").address("").tel("").deptId(null).entranceDate(null).email("").build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allStudentList;
		
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
