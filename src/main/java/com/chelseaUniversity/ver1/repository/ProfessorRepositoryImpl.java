package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Professor;
import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.dto.CreateProfessorDto;
import com.chelseaUniversity.ver1.model.dto.FindIdFormDto;
import com.chelseaUniversity.ver1.model.dto.FindPasswordFormDto;
import com.chelseaUniversity.ver1.model.dto.ProfessorListForm;
import com.chelseaUniversity.ver1.model.dto.UserUpdateDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.UserInfoForUpdateDto;
import com.chelseaUniversity.ver1.repository.interfaces.ProfessorRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class ProfessorRepositoryImpl implements ProfessorRepository {

	public static final String INSERT_PROFESSOR_SQL = " INSERT INTO professor_tb(name,birth_date,gender,address,tel,dept_id,email) VALUES (?, ?, ?, ?, ?, ?, ?) ";
	public static final String SELECT_ALL_PROFESSOR_SQL = " SELECT * FROM professor_tb ORDER BY id limit ? offset ? ";
	public static final String COUNT_ALL_PROFESSOR_SQL = " SELECT count(*) FROM professor_tb ";
	public static final String COUNT_PROFESSOR_BY_DEPT_ID = " SELECT count(*) FROM professor_tb WHERE dept_id = ? ";
	public static final String SELECT_PROFESSOR_BY_DEPT_ID = " SELECT * FROM professor_tb WHERE dept_id = ? ";
	public static final String SELECT_PROFESSOR_BY_ID = " SELECT * FROM professor_tb AS p LEFT JOIN department_tb AS d ON p.dept_id = d.id WHERE p.id = ?; ";

	@Override
	public int insertToProfessor(CreateProfessorDto createProfessorDto) {

		int rowCount = 0;

		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_PROFESSOR_SQL)) {
				pstmt.setString(1, createProfessorDto.getName());
				pstmt.setDate(2, createProfessorDto.getBirthDate());
				pstmt.setString(3, createProfessorDto.getGender());
				pstmt.setString(4, createProfessorDto.getAddress());
				pstmt.setString(5, createProfessorDto.getTel());
				pstmt.setInt(6, createProfessorDto.getDeptId());
				pstmt.setString(7, createProfessorDto.getEmail());
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
	public int updateProfessor(UserUpdateDto userUpdateDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProfessorInfoDto selectProfessorById(Integer id) {
		ProfessorInfoDto professorInfoDto = new ProfessorInfoDto();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_PROFESSOR_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				professorInfoDto = ProfessorInfoDto.builder().id(rs.getInt("p.id")).name(rs.getString("p.name"))
				.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
				.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
				.deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date"))
				.deptName(rs.getString("d.name")).collegeId(rs.getInt("college_id")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professorInfoDto;
	}

	@Override
	public Integer selectIdByNameAndEmail(FindIdFormDto findIdFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectProfessorByIdAndNameAndEmail(FindPasswordFormDto findPasswordFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> selectProfessorList(ProfessorListForm professorListForm) {
		List<Professor> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PROFESSOR_SQL);
			pstmt.setInt(1, 20);
			pstmt.setInt(2, professorListForm.getPage());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(Professor.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Professor> selectByDepartmentId(ProfessorListForm professorListForm) {
		List<Professor> list = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_PROFESSOR_BY_DEPT_ID);
			pstmt.setInt(1, professorListForm.getDeptId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(Professor.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Professor> selectByProfessorId(ProfessorListForm professorListForm) {
		List<Professor> list = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_PROFESSOR_BY_ID);
			pstmt.setInt(1, professorListForm.getProfessorId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(Professor.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hire_date")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer selectProfessorAmount() {

		int totalProfessors = 0;

		try (Connection conn = DBUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL_PROFESSOR_SQL);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				totalProfessors = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return totalProfessors;
	}

	@Override
	public Integer selectProfessorAmountByDeptId(Integer deptId) {
		int totalProfessors = 0;

		try (Connection conn = DBUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(COUNT_PROFESSOR_BY_DEPT_ID);
			pstmt.setInt(1, deptId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				totalProfessors = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return totalProfessors;
	}

}
