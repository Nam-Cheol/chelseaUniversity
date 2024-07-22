package com.chelseaUniversity.ver1.service;

import java.util.List;

import com.chelseaUniversity.ver1.model.Professor;
import com.chelseaUniversity.ver1.model.dto.ProfessorListForm;
import com.chelseaUniversity.ver1.repository.ProfessorRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ProfessorRepository;

public class ProfessorService {

	private ProfessorRepository professorRepository = new ProfessorRepositoryImpl();
	
	public Integer readProfessorAmount(ProfessorListForm professorListForm) {

		Integer amount = null;
		if (professorListForm.getDeptId() != null) {
			amount = professorRepository.selectProfessorAmountByDeptId(professorListForm.getDeptId());
		} else {
			amount = professorRepository.selectProfessorAmount();
		}

		return amount;
	}
	
	public List<Professor> readProfessorList(ProfessorListForm professorListForm) {
		List<Professor> list = null;
		if (professorListForm.getProfessorId() != null) {
			list = professorRepository.selectByProfessorId(professorListForm);
		} else if (professorListForm.getDeptId() != null) {
			list = professorRepository.selectByDepartmentId(professorListForm);
		} else {
			list = professorRepository.selectProfessorList(professorListForm);
		}

		return list;
	}
	
}
