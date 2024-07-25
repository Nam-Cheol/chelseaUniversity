package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubAppDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubDayTimeDto;
import com.chelseaUniversity.ver1.model.dto.response.StuSubSumGradesDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoForProfessorDto;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class StuSubRepositoryImpl implements StuSubRepository {

	// TODO - Define 이동할 쿼리문
	public final String SELECT_BY_STUID_AND_SUBID = " SELECT ss.* \r\n" + "		FROM stu_sub_tb AS ss\r\n"
			+ "		LEFT JOIN subject_tb AS su\r\n" + "		ON ss.subject_id = su.id\r\n"
			+ "		WHERE student_id = ? AND subject_id = ? ";
	public final String INSERT = " INSERT INTO stu_sub_tb (student_id, subject_id)\r\n"
			+ "		VALUES (?, ?) ";
	private final String UPDATE_BY_ID = " UPDATE stu_sub_tb SET GRADE = ? WHERE student_id = ? AND subject_id = ? ";

	@Override
	public List<StudentInfoForProfessorDto> selectBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StuSub selectByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
		StuSub stuSub = null;
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_STUID_AND_SUBID);
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subjectId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				stuSub = StuSub.builder().id(rs.getInt("id")).studentId(rs.getInt("student_id"))
						.subjectId(rs.getInt("subject_id")).grade(rs.getString("grade"))
						.completeGrade(rs.getInt("complete_grade")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stuSub;
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
	public List<StuSubDayTimeDto> selectDayTime(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Integer studentId, Integer subjectId) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
				pstmt.setInt(1, studentId);
				pstmt.setInt(2, subjectId);
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
	public int delete(Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StuSubAppDto> selectJoinListByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCompleteGradeByStudentIdAndSubjectId(Integer studentId, Integer subjectId, Integer completeGrade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateGradeByStudentIdAndSubjectId(StuSubDetail stuSubDetail) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_ID)) {
				pstmt.setString(1, stuSubDetail.getGrade());
				pstmt.setInt(2, stuSubDetail.getId());
				pstmt.setInt(3, stuSubDetail.getSubjectId());
				System.out.println(stuSubDetail.getGrade());
				System.out.println(stuSubDetail.getId());
				System.out.println(stuSubDetail.getSubjectId());
				int result = pstmt.executeUpdate();
				if(result == 1) {
					conn.commit();
				}
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
