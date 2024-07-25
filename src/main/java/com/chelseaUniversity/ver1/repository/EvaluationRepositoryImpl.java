package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Evaluation;
import com.chelseaUniversity.ver1.repository.interfaces.EvaluationRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class EvaluationRepositoryImpl implements EvaluationRepository {

	private static final String INSERT = " insert into evaluation_tb values(null, ?,?,?,?,?,?,?,?,?,?) ";
	private static final String SELECT_BY_ID = " SELECT e.*, s.name FROM evaluation_tb AS e JOIN subject_tb AS s ON e.subject_id = s.id WHERE s.professor_id = ? ";

	@Override
	public int insert(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Evaluation> selectEvaluationByProfessorId(Integer professorId) {
		List<Evaluation> evaluationList = new ArrayList<>();
		Evaluation evaluation = new Evaluation();
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
			pstmt.setInt(1, professorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				evaluationList.add(Evaluation.builder().studentId(rs.getInt("student_id"))
						.subjectId(rs.getInt("subject_id")).answer1(rs.getInt("answer1")).answer2(rs.getInt("answer2"))
						.answer3(rs.getInt("answer3")).answer4(rs.getInt("answer4")).answer5(rs.getInt("answer5"))
						.answer6(rs.getInt("answer6")).answer7(rs.getInt("answer7"))
						.suggestions(rs.getString("improvements")).subjectName(rs.getString("name"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evaluationList;
	}

}
