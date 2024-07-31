package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chelseaUniversity.ver1.model.dto.SyllabusDto;
import com.chelseaUniversity.ver1.repository.interfaces.SyllaBusRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class SyllabusRepositoryImpl implements SyllaBusRepository {

	private static final String UPDATE_BY_ID = " UPDATE syllabus_tb SET overview = ?, objective = ?, textbook = ?, program = ? WHERE subject_id = ? ";
	private static final String GET_INFO_BY_ID = " SELECT * FROM syllabus_tb where subject_id = ? ";

	@Override
	public int updateById(int id, SyllabusDto syllabusDto) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_ID)) {
				pstmt.setString(1, syllabusDto.getOverview());
				pstmt.setString(2, syllabusDto.getObjective());
				pstmt.setString(3, syllabusDto.getTextbook());
				pstmt.setString(4, syllabusDto.getProgram());
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
	public SyllabusDto getInfoById(int subjectId) {
		SyllabusDto syllabusDto = new SyllabusDto();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(GET_INFO_BY_ID)) {
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				syllabusDto = SyllabusDto.builder().subjectId(rs.getInt("subject_id"))
						.overview(rs.getString("overview")).objective(rs.getString("objective"))
						.textbook(rs.getString("textbook")).program(rs.getString("program")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return syllabusDto;
	}

}
