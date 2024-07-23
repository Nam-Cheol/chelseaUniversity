package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.model.dto.UpdateStudentGradeDto;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class StuSubDetailRepositoryImpl implements StuSubDetailRepository {

	private static final String SELECT_STUDENT_LIST_BY_ID = " SELECT s.id, s.name, d.name, sd.* FROM student_tb as s LEFT JOIN department_tb as d ON s.dept_id = d.id LEFT JOIN stu_sub_detail_tb as sd ON s.id = sd.student_id LEFT JOIN subject_tb as su on sd.subject_id = su.id WHERE su.id = ?; ";

	@Override
	public int updateGrade(UpdateStudentGradeDto updateStudentGradeDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Integer id, Integer studentId, Integer subjectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StuSubDetail> selectById(Integer id) {
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

}
