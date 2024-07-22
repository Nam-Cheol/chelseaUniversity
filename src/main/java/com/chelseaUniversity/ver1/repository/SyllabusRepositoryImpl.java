package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chelseaUniversity.ver1.model.SyllaBus;
import com.chelseaUniversity.ver1.repository.interfaces.SyllaBusRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class SyllabusRepositoryImpl implements SyllaBusRepository {

	private static final String UPDATE_BY_ID = " UPDATE syllabus_tb SET overview = ?, objective = ?, textbook = ?, program = ? WHERE subject_id = ? ";
	private static final String DELETE_BY_ID = " DELETE FROM syllabus_tb WHERE subject_id = ? ";

	@Override
	public int updateById(int id, SyllaBus syllaBus) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_ID)) {
				pstmt.setString(1, syllaBus.getOverview());
				pstmt.setString(2, syllaBus.getObjective());
				pstmt.setString(3, syllaBus.getTextbook());
				pstmt.setString(4, syllaBus.getProgram());
				pstmt.setInt(5, id);
				rowCount = pstmt.executeUpdate();
				conn.commit();

			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {

		}
		return rowCount;
	}

	@Override
	public void deleteById(int id) {
		try {

		} catch (Exception e) {

		}
	}

}
