package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.chelseaUniversity.ver1.model.CollTuit;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class TuitionRepositoryImpl implements TuitionRepository {

	// TODO - Define 클래스로 이동해야 할 쿼리문
	public final String SELECT_TUI_AMOUNT_BY_STU_ID = " SELECT amount FROM coll_tuit_tb WHERE college_id = (SELECT d.college_id FROM student_tb AS s JOIN department_tb AS d ON s.dept_id = d.id WHERE s.id = ?) ";
	public final String INSERT_TUITION = " INSERT INTO tuition_tb (student_id, tui_year, semester, tui_amount, sch_type, sch_amount) VALUES (?, ?, ?, ?, ?, ?) ";

	@Override
	public List<Tuition> selectByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuition> selectByStudentIdAndStatus(Integer studentId, Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	// 학생 등록금액 확인
	@Override
	public CollTuit selectTuiAmountByStudentId(Integer studentId) {
		CollTuit collTuit = null;
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_TUI_AMOUNT_BY_STU_ID);
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				collTuit = new CollTuit();
				collTuit.setAmount(rs.getInt("amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collTuit;
	}

	@Override
	public int insert(Tuition tuition) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_TUITION)) {
				pstmt.setInt(1, tuition.getStudentId());
				pstmt.setInt(2, tuition.getTuiYear());
				pstmt.setInt(3, tuition.getSemester());
				pstmt.setInt(4, tuition.getTuiAmount());
				pstmt.setInt(5, tuition.getSchType());
				pstmt.setInt(6, tuition.getSchAmount());
				rsCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsCount;
	}

	@Override
	public Tuition selectByStudentIdAndSemester(Integer studentId, Integer tuiYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStatus(Integer studentId, Integer tuiYear, Integer semester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
