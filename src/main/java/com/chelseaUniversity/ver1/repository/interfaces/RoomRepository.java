package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Room;
import com.chelseaUniversity.ver1.model.dto.RoomFormDto;

/*
 *  박성희
 *  강의실 repository
 */

public interface RoomRepository {
	
	public List<Room> selectRoom();
	public int insertRoom(String roomId, int collegeId);
	public int updateRoom(String roomId, int collegeId);
	
	// 페이징 전체 리스트
	public List<Room> getAllRoom(int limit, int offset);
	public int getTotalRoomCount();
	
}
