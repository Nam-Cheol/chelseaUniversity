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
	private static final String SELECT_BY_STUDENT = " SELECT * FROM evaluation_tb WHERE student_id = ? ";
	@Override
	public int insert(Evaluation evaluation) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT)){
			pstmt.setInt(1, evaluation.getStudentId());
			pstmt.setInt(2, evaluation.getSubjectId());
			pstmt.setInt(3, evaluation.getAnswer1());
			pstmt.setInt(4, evaluation.getAnswer2());
			pstmt.setInt(5, evaluation.getAnswer3());
			pstmt.setInt(6, evaluation.getAnswer4());
			pstmt.setInt(7, evaluation.getAnswer5());
			pstmt.setInt(8, evaluation.getAnswer6());
			pstmt.setInt(9, evaluation.getAnswer7());
			pstmt.setString(10, evaluation.getSuggestions());
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
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

	@Override
	public List<Evaluation> selectEvaluationByStudentId(int studentId) {
		List<Evaluation>evaluationList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_STUDENT)){
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Evaluation evaluation = Evaluation.builder().studentId(rs.getInt("student_id")).subjectId(rs.getInt("subject_id")).build();
				evaluationList.add(evaluation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return evaluationList;
	}

}
