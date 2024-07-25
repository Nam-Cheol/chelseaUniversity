package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.PreStuSub;
import com.chelseaUniversity.ver1.model.dto.response.StuSubAppDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubDayTimeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubSumGradesDto;
import com.chelseaUniversity.ver1.repository.interfaces.PreStuSubRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class PreStuSubRepositoryImpl implements PreStuSubRepository {

	// TODO - Define 클래스로 이동 쿼리문
	public final String SELECT_BY_SUB_ID = " SELECT * FROM sub_registration WHERE sub_id = ? ";

	@Override
	public PreStuSub selectByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StuSubAppDto> selectListByStudentIdAndSemester(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StuSubSumGradesDto selectSumGrades(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StuSubDayTimeDto> selectDayTime(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Integer studentId, Integer subjectId) {
		int rsCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(null)
					){
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return rsCount;
	}

	@Override
	public int delete(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PreStuSub> selectBySubjectId(Integer subjectId) {
		List<PreStuSub> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_SUB_ID);
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(PreStuSub.builder().studentId(rs.getInt("stu_id")).subjectId(rs.getInt("sub_id"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
