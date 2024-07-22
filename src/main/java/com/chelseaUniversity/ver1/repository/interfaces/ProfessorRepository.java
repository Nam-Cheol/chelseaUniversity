package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Professor;
import com.chelseaUniversity.ver1.model.dto.CreateProfessorDto;
import com.chelseaUniversity.ver1.model.dto.FindIdFormDto;
import com.chelseaUniversity.ver1.model.dto.FindPasswordFormDto;
import com.chelseaUniversity.ver1.model.dto.ProfessorListForm;
import com.chelseaUniversity.ver1.model.dto.UserUpdateDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.UserInfoForUpdateDto;

public interface ProfessorRepository {

	// staff_tb에 insert
	public int insertToProfessor(CreateProfessorDto createProfessorDto);

	// 유저정보 업데이트
	public int updateProfessor(UserUpdateDto userUpdateDto);

	// id로 조회
	public ProfessorInfoDto selectProfessorById(Integer id);

	// id 찾기
	public Integer selectIdByNameAndEmail(FindIdFormDto findIdFormDto);

	// password 발급용 model 확인
	public Integer selectProfessorByIdAndNameAndEmail(FindPasswordFormDto findPasswordFormDto);

	// 페이지별 교수 조회
	public List<Professor> selectProfessorList(ProfessorListForm professorListForm);

	// 페이지, 과별 교수조회
	public List<Professor> selectByDepartmentId(ProfessorListForm professorListForm);

	// id로 교수 조회
	public List<Professor> selectByProfessorId(ProfessorListForm professorListForm);

	// 페이징 처리 위한 전체 교수 수 조회
	public Integer selectProfessorAmount();

	// 페이징 처리 위한 과 교수 수 조회
	public Integer selectProfessorAmountByDeptId(Integer deptId);

}
