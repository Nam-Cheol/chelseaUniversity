package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Evaluation;
import com.chelseaUniversity.ver1.model.dto.EvaluationDto;
import com.chelseaUniversity.ver1.model.dto.MyEvaluationDto;

/**
 * 
 * @author 편용림
 *
 */
public interface EvaluationRepository {
	
	// 강의 평가 제출 (학생)
	public int insert(EvaluationDto evaluationFormDto);
	
	// 강의평가 했는지 조회 (학생)
	public Evaluation selectEvaluation(Integer studentId);
	
	// 강의평가 조회 (교수)
	public List<MyEvaluationDto> selectMyEvaluationDtoByProfessorId(Integer professorId);
	// 과목별 강의평가 조회 (교수)
	public List<MyEvaluationDto> selectEvaluationDtoByprofessorIdAndName(Integer professorId, String Name);
	// 강의평가 과목 조회 (교수)
	public List<MyEvaluationDto> selectEvaluationDto(Integer professorId);
}
