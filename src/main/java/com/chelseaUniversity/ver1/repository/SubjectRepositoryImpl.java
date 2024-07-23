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
	public static final String SELECT_SUBJECT_ALL_COUNT = " SELECT count(id) as count FROM subject_tb ";
	public static final String SELECT_SUBJECT_ALL_PAGE = " SELECT * FROM subject_tb LIMIT ? OFFSET ? ";
	public static final String SELECT_SUBJECT_BY_ID = " SELECT * FROM subject_tb WHERE id = ? ";
	public static final String SELECT_SUBJECT_ALL = " SELECT * FROM subject_tb ";
	public static final String ADD_TYPE = " type = ? ";
	public static final String ADD_DEPT = " dept_id = ? ";
	public static final String ADD_SUBJECT_NAME = " name = ? ";
	public static final String ADD_LIMIT_AND_OFFSET = " LIMIT ? OFFSET ? ";
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
		
			try (Connection conn = DBUtil.getConnection()){
			
				try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_ALL_PAGE)){
					
					pstmt.setInt(1, limit);
					pstmt.setInt(2, offset);
				
					try (ResultSet rs = pstmt.executeQuery()){

						while(rs.next()) {
							SubjectFormDto subject = SubjectFormDto.builder()
											.id(rs.getInt("id"))
											.name(rs.getString("name"))
											.professorId(rs.getInt("professor_id"))
											.roomId(rs.getString("room_id"))
											.deptId(rs.getInt("dept_id"))
											.type(rs.getString("type"))
											.subYear(rs.getInt("sub_year"))
											.semester(rs.getInt("semester"))
											.subDay(rs.getString("sub_day"))
											.startTime(rs.getInt("start_time"))
											.endTime(rs.getInt("end_time"))
											.grades(rs.getInt("grades"))
											.capacity(rs.getInt("capacity"))
											.numOfStudent(rs.getInt("num_of_student"))
											.build();
							subjectList.add(subject);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return subjectList;
	}

	@Override
	public List<SubjectFormDto> selectDtoSearch(int limit, int offset, String query, String setColumn) {
		List<SubjectFormDto> subjectList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
		
			try (PreparedStatement pstmt = conn.prepareStatement(query)){
				
				pstmt.setString(1, setColumn);
				pstmt.setInt(2, limit);
				pstmt.setInt(3, offset);
			
				try (ResultSet rs = pstmt.executeQuery()){

					while(rs.next()) {
						SubjectFormDto subject = SubjectFormDto.builder()
										.id(rs.getInt("id"))
										.name(rs.getString("name"))
										.professorId(rs.getInt("professor_id"))
										.roomId(rs.getString("room_id"))
										.deptId(rs.getInt("dept_id"))
										.type(rs.getString("type"))
										.subYear(rs.getInt("sub_year"))
										.semester(rs.getInt("semester"))
										.subDay(rs.getString("sub_day"))
										.startTime(rs.getInt("start_time"))
										.endTime(rs.getInt("end_time"))
										.grades(rs.getInt("grades"))
										.capacity(rs.getInt("capacity"))
										.numOfStudent(rs.getInt("num_of_student"))
										.build();
						subjectList.add(subject);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			} catch (Exception e) {
				e.printStackTrace();
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
		Subject subject = null;
		
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_ALL)){
				pstmt.setInt(1, id);
				
				try (ResultSet rs = pstmt.executeQuery()){

					while(rs.next()) {
						subject = Subject.builder()
											.id(rs.getInt("id"))
											.name(rs.getString("name"))
											.professorId(rs.getInt("professor_id"))
											.roomId(rs.getString("room_id"))
											.deptId(rs.getInt("dept_id"))
											.type(rs.getString("type"))
											.subYear(rs.getInt("sub_year"))
											.semester(rs.getInt("semester"))
											.subDay(rs.getString("sub_day"))
											.startTime(rs.getInt("start_time"))
											.endTime(rs.getInt("end_time"))
											.grades(rs.getInt("grades"))
											.capacity(rs.getInt("capacity"))
											.numOfStudent(rs.getInt("num_of_student"))
											.build();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public List<Subject> selectAll() {
		List<Subject> subjectList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_ALL)){
				
				try (ResultSet rs = pstmt.executeQuery()){

					while(rs.next()) {
						Subject subject = Subject.builder()
											.id(rs.getInt("id"))
											.name(rs.getString("name"))
											.professorId(rs.getInt("professor_id"))
											.roomId(rs.getString("room_id"))
											.deptId(rs.getInt("dept_id"))
											.type(rs.getString("type"))
											.subYear(rs.getInt("sub_year"))
											.semester(rs.getInt("semester"))
											.subDay(rs.getString("sub_day"))
											.startTime(rs.getInt("start_time"))
											.endTime(rs.getInt("end_time"))
											.grades(rs.getInt("grades"))
											.capacity(rs.getInt("capacity"))
											.numOfStudent(rs.getInt("num_of_student"))
											.build();
						subjectList.add(subject);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return subjectList;
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
		int totalCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_ALL_COUNT)){
				
				try (ResultSet rs = pstmt.executeQuery();){
					
					if(rs.next()) {
						totalCount = rs.getInt("count");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}

}
