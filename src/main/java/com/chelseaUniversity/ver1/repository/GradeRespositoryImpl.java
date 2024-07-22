package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.GradeDto;
import com.chelseaUniversity.ver1.model.dto.response.GradeForScholarshipDto;
import com.chelseaUniversity.ver1.model.dto.response.MyGradeDto;
import com.chelseaUniversity.ver1.repository.interfaces.GradeRespository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class GradeRespositoryImpl implements GradeRespository {

	// TODO - Define 클래스 이동 쿼리문
	public final String FIND_AVG_GRADE_BY_STUDENT_ID_AND_SEMESTER = " SELECT ss.student_id, sub_year, semester, AVG(grade_value) AS avg_grade \r\n "
			+ "    FROM stu_sub_tb AS ss\r\n " + "	JOIN grade_tb AS g\r\n " + "	ON ss.grade = g.grade\r\n "
			+ "	JOIN subject_tb AS s\r\n " + "	ON ss.subject_id = s.id\r\n "
			+ "	WHERE sub_year = ? AND semester = ? AND ss.student_id = ? \r\n " + "	GROUP BY student_id ";

	@Override
	public List<GradeDto> selectSubYearByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectSemesterByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoBySemester(Integer studentId, Integer semester, Integer subYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoBytype(Integer studentId, Integer subYear, Integer semester, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoByStudentIdAndSubYear(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyGradeDto selectMyGradeDtoBySemester(Integer studentId, Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeForScholarshipDto findAvgGradeByStudentIdAndSemester(Integer studentId, Integer subYear,
			Integer semester) {
		GradeForScholarshipDto gradeForScholarshipDto = null;
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(FIND_AVG_GRADE_BY_STUDENT_ID_AND_SEMESTER);
			pstmt.setInt(1, subYear);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, studentId);
			ResultSet rs = pstmt.executeQuery();
			gradeForScholarshipDto = new GradeForScholarshipDto();
			if (rs.next()) {
				gradeForScholarshipDto.setStudentId(rs.getInt("student_id"));
				gradeForScholarshipDto.setSubYear(rs.getInt("sub_year"));
				gradeForScholarshipDto.setSemester(rs.getInt("semester"));
				gradeForScholarshipDto.setAvgGrade(rs.getDouble("avg_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("GradeRepository-gradeForScholarshipDto : " + gradeForScholarshipDto);
		return gradeForScholarshipDto;
	}

	@Override
	public List<MyGradeDto> selectMyGradeDtoByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyGradeDto> gradeinquiryBysubYear(Integer studentId, Integer subYear) {
		// TODO Auto-generated method stub
		return null;
	}

}
