package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.model.CollTuit;
import com.chelseaUniversity.ver1.model.dto.BreakAppFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.BreakAppRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class BreakAppRepositoryImpl implements BreakAppRepository {

	public final String SELECT_BY_STU_ID = " SELECT * FROM break_app_tb WHERE student_id = ? ORDER BY id DESC ";

	@Override
	public int insert(BreakAppFormDto breakAppFormDto) {
		int rowCount = 0;

		try (Connection conn = DBUtil.getConnection()) {

			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(BREAK_INSERT)) {

				pstmt.setInt(1, breakAppFormDto.getStudentId());
				pstmt.setInt(2, breakAppFormDto.getStudentGrade());
				pstmt.setInt(3, breakAppFormDto.getFromYear());
				pstmt.setInt(4, breakAppFormDto.getFromSemester());
				pstmt.setInt(5, breakAppFormDto.getToYear());
				pstmt.setInt(6, breakAppFormDto.getToSemester());
				pstmt.setString(7, breakAppFormDto.getType());
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
	public List<BreakApp> selectByStudentId(Integer studentId) {
		List<BreakApp> collTuit = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_STU_ID);
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				collTuit.add(BreakApp.builder().id(rs.getInt("id")).studentId(rs.getInt("student_id"))
						.studentGrade(rs.getInt("student_grade")).fromYear(rs.getInt("from_year"))
						.fromSemester(rs.getInt("from_semester")).toYear(rs.getInt("to_year"))
						.toSemester(rs.getInt("to_semester")).type(rs.getString("type")).appDate(rs.getDate("app_date"))
						.status(rs.getString("status")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collTuit;
	}

	@Override
	public BreakApp selectByStudentIdOne(Integer studentId) {
		BreakApp app = null;

		try (Connection conn = DBUtil.getConnection()) {

			try (PreparedStatement pstmt = conn.prepareStatement(BREAK_SELECT_BY_STUDENT_ID)) {

				pstmt.setInt(1, studentId);

				try (ResultSet rs = pstmt.executeQuery()) {

					if (rs.next()) {
						app = BreakApp.builder().id(rs.getInt("id")).studentId(rs.getInt("student_id"))
								.studentGrade(rs.getInt("student_grade")).fromYear(rs.getInt("from_year"))
								.fromSemester(rs.getInt("from_semester")).toYear(rs.getInt("to_year"))
								.toSemester(rs.getInt("to_semester")).type(rs.getString("type"))
								.appDate(rs.getDate("app_date")).status(rs.getString("status")).build();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return app;
	}

	@Override
	public List<BreakApp> selectByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreakApp selectById(Integer id) {
		BreakApp app = null;

		try (Connection conn = DBUtil.getConnection()) {

			try (PreparedStatement pstmt = conn.prepareStatement(BREAK_SELECT_BY_ID)) {

				pstmt.setInt(1, id);

				try (ResultSet rs = pstmt.executeQuery()) {

					if (rs.next()) {
						app = BreakApp.builder().id(rs.getInt("id")).studentId(rs.getInt("student_id"))
								.studentGrade(rs.getInt("student_grade")).fromYear(rs.getInt("from_year"))
								.fromSemester(rs.getInt("from_semester")).toYear(rs.getInt("to_year"))
								.toSemester(rs.getInt("to_semester")).type(rs.getString("type"))
								.appDate(rs.getDate("app_date")).status(rs.getString("status")).build();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return app;
	}

	@Override
	public int deleteById(Integer id) {

		try (Connection conn = DBUtil.getConnection()) {

			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(BREAK_CANCLE)) {

				pstmt.setInt(1, id);
				pstmt.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateById(Integer id, String status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
