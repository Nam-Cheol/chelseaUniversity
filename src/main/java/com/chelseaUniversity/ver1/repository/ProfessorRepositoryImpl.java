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

public class ProfessorRepositoryImpl implements ProfessorRepository{

	// TODO - 나중에 Define 클래스로 이동
	public static final String INSERT_PROFESSOR_SQL = " INSERT INTO professor_tb(name,birth_date,gender,address,tel,dept_id,email) VALUES (?, ?, ?, ?, ?, ?, ?) ";
	public static final String SELECT_ALL_PROFESSOR_SQL = " SELECT * FROM professor_tb ORDER BY id limit 20 offset 21 ";
	public static final String COUNT_ALL_PROFESSOR_SQL = " SELECT count(*) FROM professor_tb ORDER BY id " ;
	public static final String SELECT_PROFESSOR_BY_DEPT_ID = " SELECT * FROM professor_tb WHERE dept_id = ? ";
	public static final String SELECT_PROFESSOR_BY_ID = " SELECT * FROM professor_tb WHERE id = ? ";
	
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
	public Integer selectIdByCreateProfessorDto(CreateProfessorDto createProfessorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoForUpdateDto selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProfessor(UserUpdateDto userUpdateDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Professor selectProfessorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorInfoDto selectProfessorInfoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
		
		List<Professor> allProfessorList = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PROFESSOR_SQL)) {
			pstmt.setInt(1, professorListForm.getPage());
//			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allProfessorList.add(Professor.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.birthDate(rs.getDate("birth_date")).gender(rs.getString("gender"))
						.address(rs.getString("address")).tel(rs.getString("tel")).email(rs.getString("email"))
						.deptId(rs.getInt("dept_id")).hireDate(rs.getDate("hireDate"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allProfessorList;
	}

	@Override
	public List<Professor> selectByDepartmentId(ProfessorListForm professorListForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> selectByProfessorId(ProfessorListForm professorListForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectProfessorAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectProfessorAmountByDeptId(Integer deptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
