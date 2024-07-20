package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.chelseaUniversity.ver1.model.Professor;
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
		// TODO Auto-generated method stub
		return null;
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
