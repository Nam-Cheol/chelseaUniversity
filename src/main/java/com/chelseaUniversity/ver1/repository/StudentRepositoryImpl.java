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

	// TODO - 나중에 Define 클래스로 이동
	public static final String INSERT_STUDENT_SQL = " INSERT INTO student_tb(name,birth_date,gender,address,tel,dept_id,entrance_date,email) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	public static final String SELECT_ALL_STUDENT_SQL = " SELECT * FROM student_tb ORDER BY id limit ? offset ? ";
	public static final String COUNT_ALL_STUDENT_SQL = " SELECT count(*) FROM student_tb ";
	public static final String SELECT_STUDENT_BY_DEPT_ID = " SELECT * FROM student_tb WHERE dept_id LIKE ? ";
	public static final String SELECT_STUDENT_BY_ID = " SELECT * FROM student_tb WHERE id LIKE ?";
	public static final String SELECT_ALL_STUDENTS_ID = " SELECT id FROM student_tb ";
	public static final String SELECT_STU_DEPT_AND_STU_ID = " SELECT * FROM student_tb WHERE id LIKE ? AND dept_id LIKE ? LIMIT ? OFFSET ? ";
	public static final String COUNT_STU_BY_ID = " SELECT count(*) FROM student_tb where id LIKE ? AND dept_id LIKE ? ";

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
				pstmt.setDate(7, createStudentDto.getEntranceDate());
				pstmt.setString(8, createStudentDto.getEmail());
				rowCount = pstmt.executeUpdate();
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

	@Override
	public Integer selectIdByCreateStudentDto(CreateStudentDto createStudentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdList() {
		List<Integer> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_STUDENTS_ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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

	/**
	 * 교직원 -> 학생 검색 조회
	 */
	@Override
	public List<Student> selectStudentList(String deptId, String studentId, int limit, int offset) {
		List<Student> studentList = new ArrayList<>();
		if (deptId == null) {
			deptId = "";
		}
		if (studentId == null) {
			studentId = "";
		}
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_STU_DEPT_AND_STU_ID);
			pstmt.setString(1, "%" + studentId + "%");
			pstmt.setString(2, "%" + deptId + "%");
			pstmt.setInt(3, limit);
			pstmt.setInt(4, offset);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					studentList.add(Student.builder().id(rs.getInt("id")).name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
							.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
							.deptId(rs.getInt("dept_id")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
							.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date"))
							.build());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public List<Student> selectByDepartmentId(StudentListForm studentListForm) {

		List<Student> student = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_BY_DEPT_ID)) {
			pstmt.setString(1, "%" + studentListForm.getDeptId() + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					student.add(Student.builder().id(rs.getInt("id")).name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
							.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
							.deptId(rs.getInt("dept_id")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
							.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date"))
							.build());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;

	}

	@Override
	public List<Student> selectByStudentIdList(StudentListForm studentListForm) {
		List<Student> student = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_BY_ID)) {
			pstmt.setString(1, "%" + studentListForm.getStudentId() + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					student.add(Student.builder().id(rs.getInt("id")).name(rs.getString("name"))
							.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
							.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
							.deptId(rs.getInt("dept_id")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
							.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date"))
							.build());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;

	}

	/**
	 * 페이지 개수를 확인하기 위해 학생 전체 수 조회
	 */
	@Override
	public Integer selectStudentAmount() {

		int totalStudents = 0;

		try (Connection conn = DBUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL_STUDENT_SQL);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				totalStudents = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return totalStudents;
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

	public Student selectByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectStudentList(int limit, int offset) {
		List<Student> allStudentList = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_STUDENT_SQL)) {
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allStudentList.add(Student.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).grade(rs.getInt("grade")).semester(rs.getInt("semester"))
						.entranceDate(rs.getDate("entrance_date")).graduationDate(rs.getDate("graduation_date"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allStudentList;
	}

	@Override
	public Integer selectStudentAmount(String deptId, String studentId) {
		int totalStudents = 0;

		if (deptId == null) {
			deptId = "";
		}
		if (studentId == null) {
			studentId = "";
		}
		try (Connection conn = DBUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(COUNT_STU_BY_ID);
			pstmt.setString(1, "%" + deptId + "%");
			pstmt.setString(2, "%" + studentId + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				totalStudents = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return totalStudents;
	}

}
