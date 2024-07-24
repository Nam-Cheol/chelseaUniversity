package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.CollTuit;
import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class TuitionRepositoryImpl implements TuitionRepository {

	// TODO - Define 클래스로 이동해야 할 쿼리문
	public final String SELECT_TUI_AMOUNT_BY_STU_ID = " SELECT amount FROM coll_tuit_tb WHERE college_id = (SELECT d.college_id FROM student_tb AS s JOIN department_tb AS d ON s.dept_id = d.id WHERE s.id = ?) ";
	public final String INSERT_TUITION = " INSERT INTO tuition_tb (student_id, tui_year, semester, tui_amount, sch_type, sch_amount) VALUES (?, ?, ?, ?, ?, ?) ";
	private static final String SELECT_TUITION_BY_STUDENT_ID = " SELECT * FROM tuition_tb WHERE student_id = ? ";
	private static final String PAYMENT_TUITION = " UPDATE tuition_tb SET status = 1 WHERE student_id = ? AND tui_year = ? AND semester = ? ";
	private static final String SELECT_AMOUNT = " SELECT ct.id, ct.name , ctt.amount FROM college_tb AS ct JOIN coll_tuit_tb AS ctt ON ct.id = ctt.college_id ORDER BY CT.id asc ";
	private static final String UPDATE_AMOUNT_BY_ID = " UPDATE coll_tuit_tb SET amount = ? WHERE college_id = ? ";
	private static final String INSERT_TUITION_AMOUNT_BY_ID = " INSERT INTO coll_tuit_tb(college_id, amount) VALUES(?, ?) ";
	
	@Override
	public List<Tuition> selectByStudentId(Integer studentId) {

		List<Tuition> tuitionList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_TUITION_BY_STUDENT_ID)){
				
				pstmt.setInt(1, studentId);
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					while(rs.next()) {
						Tuition tuition = Tuition.builder()
									.studentId(studentId)
									.tuiYear(rs.getInt("tui_year"))
									.semester(rs.getInt("semester"))
									.tuiAmount(rs.getInt("tui_amount"))
									.schAmount(rs.getInt("sch_amount"))
									.schType(rs.getInt("sch_type"))
									.status(rs.getInt("status") == 1 ? true : false)
									.build();
						tuitionList.add(tuition);
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
	
	return tuitionList;
	}

	@Override
	public List<Tuition> selectByStudentIdAndStatus(Integer studentId, Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	// 학생 등록금액 확인
	@Override
	public CollTuit selectTuiAmountByStudentId(Integer studentId) {
		CollTuit collTuit = null;
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_TUI_AMOUNT_BY_STU_ID);
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				collTuit = new CollTuit();
				collTuit.setAmount(rs.getInt("amount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return collTuit;
	}

	@Override
	public int insert(Tuition tuition) {
		int rsCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_TUITION)) {
				pstmt.setInt(1, tuition.getStudentId());
				pstmt.setInt(2, tuition.getTuiYear());
				pstmt.setInt(3, tuition.getSemester());
				pstmt.setInt(4, tuition.getTuiAmount());
				pstmt.setInt(5, tuition.getSchType());
				pstmt.setInt(6, tuition.getSchAmount());
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
	public Tuition selectByStudentIdAndSemester(Integer studentId, Integer tuiYear, Integer semester) {
		Tuition tuition = null;
		
		return tuition;
	}
	
	public Tuition selectByStudentIdToStudent(Integer studentId) {
		Tuition tuition = null;
		
		try (Connection conn = DBUtil.getConnection()){
			
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_TUITION_BY_STUDENT_ID)){
				
				pstmt.setInt(1, studentId);
				
				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						tuition = Tuition.builder()
									.studentId(studentId)
									.tuiYear(rs.getInt("tui_year"))
									.semester(rs.getInt("semester"))
									.tuiAmount(rs.getInt("tui_amount"))
									.schAmount(rs.getInt("sch_amount"))
									.schType(rs.getInt("sch_type"))
									.status(rs.getInt("status") == 1 ? true : false)
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
	
	return tuition;
	}

	@Override
	public int updateStatus(Integer studentId, Integer tuiYear, Integer semester) {
		try (Connection conn = DBUtil.getConnection()){
			
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(PAYMENT_TUITION)){

				pstmt.setInt(1, studentId);
				pstmt.setInt(2, tuiYear);
				pstmt.setInt(3, semester);
				pstmt.executeUpdate();
				
				conn.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public List<Tuition> selectAmount() {
		List<Tuition> tuitionList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_AMOUNT)){
				ResultSet set = pstmt.executeQuery();
				conn.commit();
				while (set.next()) {
					Tuition tuition = Tuition.builder()
							  			.id(set.getInt("id"))
							  			.name(set.getString("name"))
							  			.amount(set.getInt("amount"))
							  			.build();
					tuitionList.add(tuition);
					}
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return tuitionList;
	}

	@Override
	public int updateByIdAndAmount(int id, int amount) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_AMOUNT_BY_ID)){
				pstmt.setInt(1, amount);
				pstmt.setInt(2, id);
				rowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return rowCount;
	}

	@Override
	public int insertAmount(int id, int amount) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_TUITION_AMOUNT_BY_ID)){
				pstmt.setInt(1, id);
				pstmt.setInt(2, amount);
				rowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return rowCount;
	}
	
	
}
