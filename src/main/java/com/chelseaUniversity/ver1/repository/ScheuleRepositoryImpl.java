package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.dto.ScheduleDto;
import com.chelseaUniversity.ver1.model.dto.ScheduleFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class ScheuleRepositoryImpl implements ScheuleRepository{

	private static final String SELECT_SCHEDULE = " SELECT * FROM schedule_tb limit 6";
	
	@Override
	public int insertSchoeduleFormDto(Schedule schedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSchoeduleFormDtoBycontent(ScheduleFormDto scheduleFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchoeduleFormDtoByStaffIdAndId(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Schedule> selectSchodule() {
		List<Schedule>scheduleList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_SCHEDULE)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Schedule schedule = Schedule.builder().startDay(rs.getDate("start_day"))
						.endDay(rs.getDate("end_day")).information(rs.getString("information"))
						.id(rs.getInt("id")).build();
				scheduleList.add(schedule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scheduleList;
	}

	@Override
	public List<ScheduleDto> selectSchoduleMouth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleDto selectScheduleById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> selectListByMonth(Integer month) {
		// TODO Auto-generated method stub
		return null;
	}

}
