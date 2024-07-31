package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ScrollBarUI;

import com.chelseaUniversity.ver1.model.SendSub;
import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class StuSubDetailRepositoryImpl implements StuSubDetailRepository {

	private static final String SELECT_STUDENT_LIST_BY_ID = " SELECT s.id, s.name, d.name, sd.* FROM student_tb as s LEFT JOIN department_tb as d ON s.dept_id = d.id LEFT JOIN stu_sub_detail_tb as sd ON s.id = sd.student_id LEFT JOIN subject_tb as su on sd.subject_id = su.id WHERE su.id = ? ";
	private static final String SELECT_STUDENT_BY_ID = " SELECT s.id, s.name, d.name, sd.* FROM student_tb as s LEFT JOIN department_tb as d ON s.dept_id = d.id LEFT JOIN stu_sub_detail_tb as sd ON s.id = sd.student_id LEFT JOIN subject_tb as su on sd.subject_id = su.id WHERE s.id = ? ";
	private static final String UPDATE_STUDENT_BY_ID = " UPDATE stu_sub_detail_tb SET absent = ?, lateness = ?, homework = ?, mid_exam = ?, final_exam = ?, converted_mark = ? where student_id = ? ";

	private static final String INSERT_SUB_DETAIL_INFO = " INSERT INTO stu_sub_detail_tb(student_id, subject_id) VALUES (?, ?) ";
	private static final String SELECT_SUB_FIX = " select student_id, subject_id from stu_sub_tb ";

	@Override
	public int updateGrade(StuSubDetail stuSubDetail) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_STUDENT_BY_ID)) {
				pstmt.setInt(1, stuSubDetail.getAbsent());
				pstmt.setInt(2, stuSubDetail.getLateness());
				pstmt.setInt(3, stuSubDetail.getHomework());
				pstmt.setInt(4, stuSubDetail.getMidExam());
				pstmt.setInt(5, stuSubDetail.getFinalExam());
				pstmt.setInt(6, stuSubDetail.getConvertedMark());
				pstmt.setInt(7, stuSubDetail.getId());
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insert(String studentId, String subjectId) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SUB_DETAIL_INFO)) {
				pstmt.setString(1, studentId);
				pstmt.setString(2, subjectId);
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
	public List<StuSubDetail> selectListById(Integer id) {
		List<StuSubDetail> detailList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_LIST_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				detailList.add(StuSubDetail.builder().id(rs.getInt("s.id")).name(rs.getString("s.name"))
						.deptName(rs.getString("d.name")).absent(rs.getInt("absent")).lateness(rs.getInt("lateness"))
						.homework(rs.getInt("homework")).midExam(rs.getInt("mid_exam"))
						.finalExam(rs.getInt("final_exam")).convertedMark(rs.getInt("converted_mark")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailList;
	}

	@Override
	public StuSubDetail selectById(Integer id) {
		StuSubDetail detail = new StuSubDetail();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				detail = StuSubDetail.builder().id(rs.getInt("s.id")).name(rs.getString("s.name"))
						.subjectId(rs.getInt("subject_id")).deptName(rs.getString("d.name")).absent(rs.getInt("absent"))
						.lateness(rs.getInt("lateness")).homework(rs.getInt("homework")).midExam(rs.getInt("mid_exam"))
						.finalExam(rs.getInt("final_exam")).convertedMark(rs.getInt("converted_mark")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}

	@Override
	public List<SendSub> selectFixSubject() {
		List<SendSub> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SUB_FIX)){
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					SendSub dto = SendSub.builder()
									.StudentId(rs.getString("student_id"))
									.SubjectId(rs.getString("subject_id"))
									.build();
					list.add(dto);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
