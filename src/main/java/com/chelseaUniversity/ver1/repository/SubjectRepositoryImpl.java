package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Subject;
import com.chelseaUniversity.ver1.model.dto.AllSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.CurrentSemesterSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.model.dto.response.ReadSyllabusDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectForProfessorDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectPeriodForProfessorDto;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class SubjectRepositoryImpl implements SubjectRepository {

	// TODO - Define 클래스로 이동 쿼리문
	public final String LESS_NUM_OF_STUDENT = " SELECT id FROM subject_tb WHERE capacity >= num_of_student ";
	public final String MORE_NUM_OF_STUDENT = " SELECT id FROM subject_tb WHERE capacity >= num_of_student ";
	public final String RESET_NUM_OF_STUDENT = " UPDATE subject_tb SET num_of_student = 0\r\n" + " WHERE id = ? ";

	@Override
	public Integer insert(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBySubjectDto(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Subject> selectByRoomIdAndSubDayAndSubYearAndSemester(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectIdOrderById(SubjectFormDto subjectFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemester(Integer subYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemesterLimit(Integer subYear, Integer semester, Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectFormDto> selectDtoAll(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoAllLimit(Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectPeriodForProfessorDto> selectSemester(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectForProfessorDto> selectSubjectBySemester(
			SubjectPeriodForProfessorDto subjectPeriodForProfessorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemesterAndDeptAndName(AllSubjectSearchFormDto allSubjectSearchFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectDto> selectDtoBySemesterAndAndTypeAndDeptAndName(
			CurrentSemesterSubjectSearchFormDto currentSemesterSubjectSearchFormDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject selectSubjectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNumOfStudent(Integer id, String type) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try(PreparedStatement pstmt = conn.prepareStatement(RESET_NUM_OF_STUDENT)) {
				pstmt.setInt(1, id);
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

	@Override
	public ReadSyllabusDto selectSyllabusBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdByLessNumOfStudent() {
		List<Integer> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(LESS_NUM_OF_STUDENT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Integer> selectIdByMoreNumOfStudent() {
		List<Integer> list = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(MORE_NUM_OF_STUDENT);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
