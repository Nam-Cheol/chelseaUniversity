package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.repository.interfaces.RegistrationRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class RegistrationRepositoryImpl implements RegistrationRepository {
	
	private static final String insertRegistration = " INSERT INTO sub_registration VALUES (?, ?) ";
	private static final String deleteRegistration = " DELETE FROM sub_registration WHERE stu_id = ? AND sub_id = ? ";
	private static final String selectRegistration = " SELECT * from sub_registration WHERE stu_id = ? ";

	@Override
	public void insertSubjectRegistration(int stuId, int subId) {
		
		try (Connection conn = DBUtil.getConnection()){
			
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(insertRegistration)){
				
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
					
					try (PreparedStatement pstmt = conn.prepareStatement(deleteRegistration)){
						
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
				PreparedStatement pstmt = conn.prepareStatement(selectRegistration)){
			
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

}
