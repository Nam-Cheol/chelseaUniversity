package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chelseaUniversity.ver1.model.Scholarship;
import com.chelseaUniversity.ver1.model.StuSch;
import com.chelseaUniversity.ver1.repository.interfaces.ScholarshipRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class ScholarshipRepositoryImpl implements ScholarshipRepository {

	// TODO - Define 클래스로 이동 쿼리문
	public final String INSERT_STU_SCH = " INSERT INTO stu_sch_tb VALUES (?, ?, ?, ?) ";
	public final String SELECT_BY_STU_ID_AND_SEMESTER = " SELECT sch.max_amount, sch_type \r\n"
			+ "	FROM scholarship_tb AS sch\r\n" + "	JOIN stu_sch_tb AS ss\r\n" + "	ON sch.type = ss.sch_type\r\n"
			+ "	WHERE ss.student_id = ? \r\n" + "		AND ss.sch_year = ? \r\n" + "		AND ss.semester = ? ";

	@Override
	public Scholarship selectByStudentIdAndSemester(Integer studentId, Integer schYear, Integer semester) {
		Scholarship scholarship = null;
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_STU_ID_AND_SEMESTER);
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, schYear);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			scholarship = new Scholarship();
			if (rs.next()) {
				scholarship.setType(rs.getInt("sch_type"));
				scholarship.setMaxAmount(rs.getInt("max_amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ScholarshipRepositoryImpl-selectByStudentIdAndSemester : " + scholarship);
		return scholarship;
	}

	@Override
	public int insertCurrentSchType(StuSch stuSch) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_STU_SCH)) {
				pstmt.setInt(1, stuSch.getStudentId());
				pstmt.setInt(2, stuSch.getSchYear());
				pstmt.setInt(3, stuSch.getSemester());
				pstmt.setInt(4, stuSch.getSchType());
				pstmt.executeUpdate();
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
}
