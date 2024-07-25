package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Room;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.model.dto.RoomFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.RoomRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class RoomRepositoryImpl implements RoomRepository{
	
	public static final String SELECT_ROOM_ALL = " select * from room_tb ";
	public static final String INSERT_ROOM = " INSERT INTO room_tb( id, college_id ) VALUES( ?, ? ) ";
	public static final String UPDATE_ROOM = " UPDATE room_tb SET college_id = ? WHERE id = ? ";

	@Override
	public int insert(RoomFormDto roomFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Room> selectByRoomDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Room> selectRoom() {
		List<Room> roomList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ROOM_ALL)){
				ResultSet set = pstmt.executeQuery();
				conn.commit();
				while (set.next()) {
					Room room = Room.builder()
							  			.id(set.getString("id"))
							  			.collegeId(set.getInt("college_id"))
							  			.build();
					roomList.add(room);
					}
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return roomList;
		
	}

	@Override
	public int insertRoom(String roomId, int collegeId) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_ROOM)){
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
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_ROOM)){
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

}
