package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Evaluation;

public interface EvaluationRepository {

	public int insert(Evaluation evaluation);

	public List<Evaluation> selectEvaluationByProfessorId(Integer professorId);

	public List<Evaluation> selectEvaluationByStudentId(int studentId);
}
