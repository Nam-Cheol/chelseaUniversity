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
		// TODO Auto-generated method stub
		return 0;
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
	public List<BreakApp> selectByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BreakApp selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Integer id, String status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
