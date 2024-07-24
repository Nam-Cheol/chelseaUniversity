package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.repository.interfaces.RegistrationRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class RegistrationRepositoryImpl implements RegistrationRepository {
	
	private static final String INSERT_Registration = " INSERT INTO sub_registration VALUES (?, ?) ";
	private static final String DELETE_Registration = " DELETE FROM sub_registration WHERE stu_id = ? AND sub_id = ? ";
	private static final String SELECT_Registration = " SELECT * from sub_registration WHERE stu_id = ? ";
	private static final String UPDATE_NUM_OF_STUDENT = " UPDATE subject_tb SET num_of_student = (num_of_student) + 1 WHERE id = ? ";
	private static final String DELETE_NUM_OF_STUDENT = " UPDATE subject_tb SET num_of_student = (num_of_student) - 1 WHERE id = ? ";
	
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

}
