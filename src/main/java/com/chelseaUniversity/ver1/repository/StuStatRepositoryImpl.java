package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoStatListDto;
import com.chelseaUniversity.ver1.repository.interfaces.StuStatRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class StuStatRepositoryImpl implements StuStatRepository {

	// TODO - Define 클래스로 이동해야 하는 쿼리문
	public final String SELECT_STUDENT_STAT_BY_ID  = " SELECT * FROM stu_stat_tb WHERE student_id = ? ORDER BY id DESC ";
	public final String SELECT_STUDENT_STATUS_BY_ID = " SELECT * FROM stu_stat_tb WHERE student_id = ?";
	
	public final String UPDATE_OLD_STATUS = " UPDATE stu_stat_tb SET to_date = now() WHERE id = ? ";
	public final String INSERT_STU_STATUS = " INSERT stu_stat_tb(student_id, status, from_date, to_date, break_app_id) \r\n "
			+ " VALUES (?, ?, ?, ?, ?) ";

	@Override
	public List<StuStat> selectByStudentIdOrderbyIdDesc(Integer studentId) {
		List<StuStat> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_STAT_BY_ID);
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StuStat stuStat = new StuStat();
				stuStat.setId(rs.getInt("id"));
				stuStat.setStudentId(rs.getInt("student_id"));
				stuStat.setStatus(rs.getString("status"));
				stuStat.setFromDate(rs.getDate("from_date"));
				stuStat.setToDate(rs.getDate("to_date"));
				list.add(stuStat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int insert(Integer studentId, String status, String toDate, Integer breakAppId) {
		int rsCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_STU_STATUS )){
				pstmt.setInt(1, rsCount);
				pstmt.setInt(2, rsCount);
//				pstmt.setDate(3, Timestamp);
				pstmt.setInt(4, rsCount);
				pstmt.setInt(4, rsCount);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rsCount;
	}

	@Override
	public int updateOldStatus(Integer id) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_OLD_STATUS)) {
				pstmt.setInt(1, id);
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
	public List<StudentInfoStatListDto> selectStuStatListBystudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StuStat selectStatusByStudentId(int id) {
		StuStat student = null;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_STATUS_BY_ID)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				student = StuStat.builder().id(rs.getInt("id")).studentId(rs.getInt("student_id"))
						.status(rs.getString("status")).fromDate(rs.getDate("from_date"))
						.toDate(rs.getDate("to_date")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

}
