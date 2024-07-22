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
	public final String SELECT_BY_SUB_ID = " SELECT ss.id, ss.student_id, s.name AS student_name, d.name AS dept_name, ssd.homework, ssd.absent, ssd.lateness, ssd.mid_exam, ssd.final_exam, ssd.converted_mark\r\n"
			+ "		FROM stu_sub_tb AS ss\r\n" + "		LEFT JOIN student_tb AS s\r\n"
			+ "		ON ss.student_id = s.id\r\n" + "		LEFT JOIN department_tb AS d\r\n"
			+ "		ON s.dept_id = d.id\r\n" + "		LEFT JOIN stu_sub_detail_tb AS ssd\r\n"
			+ "		ON ss.id = ssd.id\r\n" + "		WHERE ss.subject_id = ?  ";

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
		// TODO Auto-generated method stub
		return 0;
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
				list.add(PreStuSub.builder().studentId(rs.getInt("student_id")).subjectId(rs.getInt("subject_id"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
