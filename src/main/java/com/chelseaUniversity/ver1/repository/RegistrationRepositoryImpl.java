package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.CheckSubjectTime;
import com.chelseaUniversity.ver1.model.SubjectHistory;
import com.chelseaUniversity.ver1.repository.interfaces.RegistrationRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class RegistrationRepositoryImpl implements RegistrationRepository {
	
	private static final String INSERT_Registration = " INSERT INTO sub_registration VALUES (?, ?) ";
	private static final String DELETE_Registration = " DELETE FROM sub_registration WHERE stu_id = ? AND sub_id = ? ";
	private static final String SELECT_Registration = " SELECT * from sub_registration WHERE stu_id = ? ";
	private static final String UPDATE_NUM_OF_STUDENT = " UPDATE subject_tb SET num_of_student = (num_of_student) + 1 WHERE id = ? ";
	private static final String DELETE_NUM_OF_STUDENT = " UPDATE subject_tb SET num_of_student = (num_of_student) - 1 WHERE id = ? ";
	private static final String CHECK_SUBJECT_ID = " SELECT s.dept_id AS dept_id FROM subject_tb AS s JOIN student_tb AS d ON s.dept_id = d.dept_id WHERE s.type = '전공' AND s.id = ? AND d.id = ? ";
	private static final String STUDENT_TOTAL_GRADE = " SELECT SUM(s.grades) AS grade FROM sub_registration AS r JOIN subject_tb AS s ON r.sub_id = s.id WHERE r.stu_id = ? ";
	private static final String CHECK_SUBJECT_TIME = " SELECT sub_day, start_time, end_time FROM sub_registration AS r JOIN subject_tb AS s ON r.sub_id = s.id WHERE stu_id = ? ";
	private static final String SELECT_SUBJECT_HISTORY = " SELECT "
															+ "    s.id AS sub_id, "
															+ "    s.name AS title, "
															+ "    p.name AS p_name, "
															+ "    grades, "
															+ "    sub_day, "
															+ "    start_time, "
															+ "    end_time, "
															+ "    room_id, "
															+ "    capacity, "
															+ "    num_of_student "
															+ "    FROM "
															+ "    sub_registration AS r "
															+ "        JOIN "
															+ "    subject_tb AS s ON r.sub_id = s.id "
															+ "        JOIN "
															+ "    professor_tb AS p ON s.professor_id = p.id "
															+ "    WHERE "
															+ "    stu_id = ? ";
	private static final String IS_PRE_SUGANG_SEASON = " SELECT status FROM sugang WHERE name = 'pre_sugang' ";
	private static final String IS_SUGANG_SEASON = " SELECT status FROM sugang WHERE name = 'sugang' ";
	
	@Override
	public void insertSubjectRegistration(int stuId, int subId) {
		
		try (Connection conn = DBUtil.getConnection()){
			
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_Registration)){
				
				pstmt.setInt(1, stuId);
				pstmt.setInt(2, subId);
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteSubjectRegistration(int stuId, int subId) {
		
		try (Connection conn = DBUtil.getConnection()){
					
					conn.setAutoCommit(false);
					
					try (PreparedStatement pstmt = conn.prepareStatement(DELETE_Registration)){
						
						pstmt.setInt(1, stuId);
						pstmt.setInt(2, subId);
						pstmt.executeUpdate();
						
						conn.commit();
					} catch (Exception e) {
						conn.rollback();
						e.printStackTrace();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public List<Integer> selectSubjectRegistration(int stuId) {
		List<Integer> subjectList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_Registration)){
			
			pstmt.setInt(1, stuId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					subjectList.add(rs.getInt("sub_id"));
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
	public void addNumOfStudent(int id) {
		
		try (Connection conn = DBUtil.getConnection()){
			
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_NUM_OF_STUDENT)){
				
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteNumOfStudent(int id) {
		
		try (Connection conn = DBUtil.getConnection()){
			
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_NUM_OF_STUDENT)){
				
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int checkDepartment(int subjectId, int studentId) {

		int deptId = 0;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(CHECK_SUBJECT_ID)){
			
				pstmt.setInt(1, subjectId);
				pstmt.setInt(2, studentId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					deptId = rs.getInt("dept_id");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deptId;
	}

	@Override
	public List<CheckSubjectTime> registSubjectTime(int studentId) {
		List<CheckSubjectTime> checkList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(CHECK_SUBJECT_TIME)){
			
				pstmt.setInt(1, studentId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					CheckSubjectTime time = CheckSubjectTime.builder()
											.subDay(rs.getString("sub_day"))
											.startTime(rs.getString("start_time"))
											.endTime(rs.getString("end_time"))
											.build();
					checkList.add(time);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return checkList;
	}

	@Override
	public int totalGrades(int studentId) {
		int totalGrade = 0;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(STUDENT_TOTAL_GRADE)){
			
				pstmt.setInt(1, studentId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					totalGrade = rs.getInt("grade");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalGrade;
	}

	@Override
	public List<SubjectHistory> resistrationHistory(int studentId) {
		List<SubjectHistory> historyList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_HISTORY)){
			
				pstmt.setInt(1, studentId);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					SubjectHistory time = SubjectHistory.builder()
											.id(rs.getString("sub_id"))
											.title(rs.getString("title"))
											.professorName(rs.getString("p_name"))
											.grades(rs.getString("grades"))
											.subDay(rs.getString("sub_day"))
											.startTime(rs.getString("start_time"))
											.endTime(rs.getString("end_time"))
											.roomId(rs.getString("room_id"))
											.capacity(rs.getString("capacity"))
											.numOfStudent(rs.getString("num_of_student"))
											.build();
					System.out.println(time);
					historyList.add(time);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return historyList;
	}

	@Override
	public String isSugangSeason() {
		String season = null;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(IS_SUGANG_SEASON)){
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					season = rs.getString("status");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return season;
	}

	@Override
	public String isPreSugangSeason() {
		String preSeason = null;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(IS_PRE_SUGANG_SEASON)){
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					preSeason = rs.getString("status");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return preSeason;
	}

}
