package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.Room;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.model.dto.RoomFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.RoomRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class RoomRepositoryImpl implements RoomRepository {

	public static final String SELECT_ROOM_ALL = " select * from room_tb ";
	public static final String INSERT_ROOM = " INSERT INTO room_tb( id, college_id ) VALUES( ?, ? ) ";
	public static final String UPDATE_ROOM = " UPDATE room_tb SET college_id = ? WHERE id = ? ";
	public final String SELECT_ALL_ROOM = " SELECT * FROM room_tb ORDER BY id ASC LIMIT ? OFFSET ? ";
	public final String COUNT_ALL_ROOM = " SELECT count(*) AS count FROM room_tb ";

	@Override
	public List<Room> selectRoom() {
		List<Room> roomList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Room room = Room.builder().id(rs.getString("id")).collegeId(rs.getInt("college_id")).build();
				roomList.add(room);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomList;

	}

	@Override
	public int insertRoom(String roomId, int collegeId) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ROOM)) {
				pstmt.setString(1, roomId);
				pstmt.setInt(2, collegeId);
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
	public int updateRoom(String roomId, int collegeId) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_ROOM)) {
				pstmt.setInt(1, collegeId);
				pstmt.setString(2, roomId);
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
	public List<Room> getAllRoom(int limit, int offset) {
		List<Room> roomList = new ArrayList<>();

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ROOM)) {
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				roomList.add(Room.builder().id(rs.getString("id")).collegeId(rs.getInt("college_id")).build());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return roomList;
	}

	@Override
	public int getTotalRoomCount() {
		int count = 0;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL_ROOM)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" 로깅 totalCount : " + count);

		return count;
	}

}
