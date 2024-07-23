package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.dto.CollegeFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class CollegeRepositoryImpl implements CollegeRepository{
	
	private static final String SELECT_COLLEGE_ALL_ORDER_BY = " SELECT * FROM college_tb ORDER BY id ASC ";
	private static final String INSERT_COLLEGE_ORDER_BY_NAME = " INSERT INTO college_tb(name) VALUES (?) ";
	private static final String UPDATE_COLLEGE_NAME_BY_ID = " UPDATE college_tb SET name = ? WHERE id = ? ";
	// College -> dto
	// CollegeRepository -> dao
	// CollegeRepositoryImpl -> daoImpl
	// 쿼리문 처리

	@Override
	public int insert(String CollegeFormDto) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_COLLEGE_ORDER_BY_NAME)){
				pstmt.setString(1, CollegeFormDto);
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
	public List<College> selectCollegeDto() {
		List<College> collegeList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_COLLEGE_ALL_ORDER_BY)){
				ResultSet set = pstmt.executeQuery();
				conn.commit();
				while (set.next()) {
					College college = College.builder()
							  			.id(set.getInt("id"))
							  			.name(set.getString("name"))
							  			.build();
					collegeList.add(college);				
					}
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return collegeList;
	}
	
	@Override
	public int selectCollegeDtoByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public College selectCollegeDtoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByNameAndId(String name, int id) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_COLLEGE_NAME_BY_ID)){
				pstmt.setString(1, name);
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

	

}
