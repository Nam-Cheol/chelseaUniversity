package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class StuSubDetailRepositoryImpl implements StuSubDetailRepository{

	// TODO - define 클래스 이동 쿼리문 
	public final String INSERT_PRE_INFO = "INSERT stu_sub_detail_tb(id, student_id, subject_id) VALUE (?, ?, ?)";
	
	@Override
	public int updateGrade(UpdateStudentGradeDto updateStudentGradeDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Integer id, Integer studentId, Integer subjectId) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_PRE_INFO)){
				pstmt.setInt(1, id);
				pstmt.setInt(2, studentId);
				pstmt.setInt(3, subjectId);
				rsCount=pstmt.executeUpdate();
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
