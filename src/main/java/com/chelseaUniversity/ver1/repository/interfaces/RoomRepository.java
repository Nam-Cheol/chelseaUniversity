package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Room;
import com.chelseaUniversity.ver1.model.dto.RoomFormDto;

/*
 *  박성희
 *  강의실 repository
 */

public interface RoomRepository {
	public int insert(RoomFormDto roomFormDto);
	public List<Room> selectByRoomDto();
	public int deleteById(String id);
}
