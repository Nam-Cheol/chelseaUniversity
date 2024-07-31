package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	public final String FIND_SUBJECT_GRADE_BY_STUDENT_ID = " select subj.sub_year as year , subj.semester as semester , subj.id as id ,\r\n"
			+ "subj.name as name , subj.type as type , subj.grades as completegrade , sub.grade as grade\r\n"
			+ "from student_tb as stu\r\n"
			+ "join stu_sub_tb as sub\r\n"
			+ "on sub.student_id = stu.id\r\n"
			+ "join subject_tb as subj\r\n"
			+ "on sub.subject_id = subj.id\r\n"
			+ "WHERE stu.id = ? AND subj.sub_year = ?  AND subj.semester = ? GROUP BY sub.subject_id ";
	public final String FIND_AVG_GRADE_BY_SEMESTER = " SELECT  st.student_id as id, su.sub_year as year, su.semester as semester, SUM(su.grades) AS sum_grades, mg.my_grades as grade, SUM(gr.grade_value)/COUNT(su.name) AS average\r\n"
			+ "FROM stu_sub_tb AS st\r\n"
			+ "INNER JOIN subject_tb AS su\r\n"
			+ "ON st.subject_id = su.id\r\n"
			+ "INNER JOIN grade_tb AS gr\r\n"
			+ "ON st.grade = gr.grade\r\n"
			+ "INNER JOIN (\r\n"
			+ "SELECT stu.student_id, SUM(sub.grades) AS my_grades\r\n"
			+ "FROM stu_sub_tb AS stu\r\n"
			+ "INNER JOIN subject_tb AS sub\r\n"
			+ "ON stu.subject_id = sub.id\r\n"
			+ "INNER JOIN grade_tb AS gra\r\n"
			+ "ON stu.grade = gra.grade\r\n"
			+ "WHERE stu.student_id = ? AND sub.sub_year = ? AND sub.semester = ? AND gra.grade != 'F'\r\n"
			+ ") AS mg\r\n"
			+ "ON st.student_id = mg.student_id \r\n"
			+ "WHERE st.student_id = ? AND su.sub_year = ? AND su.semester = ? ";
	public final String FIND_GRADE_BY_SEMESTER = " select s.id as id, s.name as name,  sub.name as subject, stu.grade as grade, \r\n"
			+ "sub.grades as completeGrade, sub.type as type , sub.sub_year as year , sub.semester as semester , sub.id as subId\r\n"
			+ "from stu_sub_tb as stu\r\n"
			+ "join subject_tb as sub\r\n"
			+ "on stu.subject_id = sub.id\r\n"
			+ "join student_tb as s\r\n"
			+ "on s.id = stu.student_id\r\n"
			+ "where sub.sub_year = ? and sub.semester = ? and s.id = ? ";
	public final String FIND_ALL_GRADE_BY_ID = " select sum(stu.complete_grade) as my , sum(sub.grades) as sum , sub.sub_year as year , sub.semester as semester ,avg(stu.complete_grade) as avg\r\n"
			+ ",SUM(gr.grade_value)/COUNT(sub.name) AS average\r\n"
			+ "from student_tb as s\r\n"
			+ "join stu_sub_tb as stu\r\n"
			+ "on s.id = stu.student_id\r\n"
			+ "join subject_tb as sub\r\n"
			+ "on stu.subject_id = sub.id\r\n"
			+ "join grade_tb as gr\r\n"
			+ "on stu.grade = gr.grade\r\n"
			+ "where s.id = ? ";
	
	@Override
	public List<GradeDto> selectSubYearByStudentId(Integer studentId) {
		
		return null;
	}

	@Override
	public List<GradeDto> selectSemesterByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoBySemester(Integer studentId, Integer semester, Integer subYear) {
		List<GradeDto>gradeList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_GRADE_BY_SEMESTER)){
			pstmt.setInt(1, subYear);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, studentId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				GradeDto grade = GradeDto.builder().subYear(rs.getInt("year")).subjectId(rs.getInt("subId"))
						.semester(rs.getInt("semester")).name(rs.getString("subject"))
						.type(rs.getString("type")).grade(rs.getString("completeGrade")).gradeValue(rs.getString("grade"))
						.build();
				gradeList.add(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gradeList;
	}

	@Override
	public List<GradeDto> selectGradeDtoByStudentId(Integer studentId) {
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoBytype(Integer studentId, Integer subYear, Integer semester, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDto> selectGradeDtoByStudentIdAndSubYear(Integer studentId, Integer subYear, Integer semester) {
		List<GradeDto>GradeDtoList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_SUBJECT_GRADE_BY_STUDENT_ID)){
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subYear);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				GradeDto grade = GradeDto.builder().subYear(rs.getInt("year")).semester(rs.getInt("semester"))
						.subjectId(rs.getInt("id")).name(rs.getString("name")).type(rs.getString("type"))
						.grade(rs.getString("completegrade")).gradeValue(rs.getString("grade")).build();
				System.out.println(grade.getGradeValue());
				GradeDtoList.add(grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GradeDtoList;
	}

	@Override
	public MyGradeDto selectMyGradeDtoBySemester(Integer studentId, Integer subYear, Integer semester) {
		MyGradeDto myGradeDto = null;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_AVG_GRADE_BY_SEMESTER)){
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subYear);
			pstmt.setInt(3, semester);
			pstmt.setInt(4, studentId);
			pstmt.setInt(5, subYear);
			pstmt.setInt(6, semester);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				myGradeDto = MyGradeDto.builder().subYear(rs.getInt("year")).semester(rs.getInt("semester")).sumGrades(rs.getInt("sum_grades"))
						.myGrades(rs.getInt("grade")).average(rs.getFloat("average")).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myGradeDto;
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
;
	@Override
	public List<MyGradeDto> selectMyGradeDtoByStudentId(Integer studentId) {
		List<MyGradeDto>myGradeList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_ALL_GRADE_BY_ID)){
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MyGradeDto myGrade = MyGradeDto.builder().average(rs.getFloat("average")).subYear(rs.getInt("year"))
						.semester(rs.getInt("semester")).sumGrades(rs.getInt("sum")).myGrades(rs.getInt("my")).build();
				myGradeList.add(myGrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myGradeList;
	}

	@Override
	public List<MyGradeDto> gradeinquiryBysubYear(Integer studentId, Integer subYear) {
		// TODO Auto-generated method stub
		return null;
	}

}
