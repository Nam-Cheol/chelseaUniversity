package com.chelseaUniversity.ver1.model.dto.response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Subject;
import com.chelseaUniversity.ver1.model.dto.AllSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.CurrentSemesterSubjectSearchFormDto;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;
import com.chelseaUniversity.ver1.utill.DBUtilBasic;

public class SubjectRepositoryImpl implements SubjectRepository {

	private static final String SELECT_ALL = " SELECT * FROM subject_tb ";
	private static final String COUNT_ALL = " select count(*) as count from subject_tb ";

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
		List<SubjectFormDto> subjectList = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subjectList.add(SubjectFormDto.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.professorId(rs.getInt("professor_id")).roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id")).type(rs.getString("type")).subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester")).subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time")).endTime(rs.getInt("end_time")).grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity")).numOfStudent(rs.getInt("num_of_student")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReadSyllabusDto selectSyllabusBySubjectId(Integer subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdByLessNumOfStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> selectIdByMoreNumOfStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getTotalBoardCount() {
		int count = 0; 
		try (Connection conn = DBUtilBasic.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL)){
 			ResultSet rs = pstmt.executeQuery();
 			if(rs.next()) {
 				count = rs.getInt("count");
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" 로깅 totalCount : " + count);
		
		return count;
	}

}
