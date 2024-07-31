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

	// id로 조회
	public ProfessorInfoDto selectProfessorById(Integer id);

	// 페이지별 교수 조회
	public List<Professor> selectProfessorList(ProfessorListForm professorListForm);
	public List<Professor> selectProfessorList(String deptId,String proId,int limit,int offset);
	public List<Professor> selectProfessorList(int limit, int offset);
	
	// 전체 교수 조회
	public List<Professor> selectProfessorList();

	// 페이지, 과별 교수조회
	public List<Professor> selectByDepartmentId(ProfessorListForm professorListForm);

	// id로 교수 조회
	public List<Professor> selectByProfessorId(ProfessorListForm professorListForm);

	// 페이징 처리 위한 전체 교수 수 조회
	public Integer selectProfessorAmount();
	public Integer selectProfessorAmount(String deptId, String proId);

	// 페이징 처리 위한 과 교수 수 조회
	public Integer selectProfessorAmountByDeptId(Integer deptId);

	// 교수 소속 받아오기
	public String selectProfessorDeptById(int id);
}
