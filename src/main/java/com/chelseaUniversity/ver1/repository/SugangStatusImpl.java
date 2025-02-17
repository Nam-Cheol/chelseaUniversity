package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chelseaUniversity.ver1.repository.interfaces.SugangStatus;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class SugangStatusImpl implements SugangStatus{

	public final String SELECT_SUGANG_STATUS = " SELECT status FROM sugang WHERE name = 'sugang'";
	public final String SELECT_PRE_SUGANG_STATUS = " SELECT status FROM sugang WHERE name = 'pre_sugang'";
	public final String UPDATE_SUGANG_STATUS = " UPDATE sugang SET status = ? WHERE name = 'sugang' ";
	public final String UPDATE_PRE_SUGANG_STATUS = " UPDATE sugang SET status = ? WHERE name = 'pre_sugang' ";

	/**
	 * 예비수강기간, 본수강기간 모두 변경
	 */
	@Override
	public int updateAllSugangPeriod(String preSugangStatus, String sugangStatus) {
		int rsRowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			// 예비수강신청 기간 상태값 변경
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_PRE_SUGANG_STATUS)) {
				pstmt.setString(1, preSugangStatus);
				rsRowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			// 본 수강신청 기간 상태값 변경
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SUGANG_STATUS)) {
				pstmt.setString(1, sugangStatus);
				rsRowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsRowCount;
	}

	/**
	 * 예비수강신청 기간 상태값 변경
	 */
	@Override
	public int updatePrePeriod(String preSugangStatus) {
		int rsRowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_PRE_SUGANG_STATUS)) {
				pstmt.setString(1, preSugangStatus);
				rsRowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsRowCount;
	}

	/**
	 * 수강신청 기간 상태값 변경
	 */
	@Override
	public int updateSugangPeriod(String sugangStatus) {
		int rsRowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SUGANG_STATUS)) {
				pstmt.setString(1, sugangStatus);
				rsRowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsRowCount;
	}

	@Override
	public String selectSugangStatus() {
		String status = null;
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_SUGANG_STATUS)){
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				status = rs.getString("status");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String selectPreSugangStatus() {
		String status = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_PRE_SUGANG_STATUS)){
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					status = rs.getString("status");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return status;
	}

}
