package com.chelseaUniversity.ver1.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.dto.ScheduleDto;
import com.chelseaUniversity.ver1.model.dto.ScheduleFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;
import com.chelseaUniversity.ver1.utill.DBUtil;

public class ScheuleRepositoryImpl implements ScheuleRepository{

	private static final String SELECT_SCHEDULE = " SELECT * FROM schedule_tb limit 6";
	
	public final String SELECT_ALL_SCHEDUE = " SELECT * FROM schedule_tb ORDER BY id ASC LIMIT ? OFFSET ? ";
	public final String COUNT_ALL_SCHEDULE = " SELECT count(*) AS count FROM schedule_tb ";
	public final String SELECT_SCHEDULE_ALL_LIST = " SELECT * FROM schedule_tb ";
	public final String INSERT_SCHEDULE = " INSERT INTO schedule_tb( staff_id, start_day, end_day, information ) VALUES ( ? , ? , ? , ? ) ";
	private static final String UPDATE_SCHEDULE = " UPDATE schedule_tb SET staff_id = ?, start_day = ?, end_day = ?, information = ? WHERE id = ? ";
	
	
	@Override
	public int insertSchoeduleFormDto(Schedule schedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSchoeduleFormDtoBycontent(ScheduleFormDto scheduleFormDto) {

		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection()){
		
			conn.setAutoCommit(false);
			
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SCHEDULE)){
				
				pstmt.setInt(1, scheduleFormDto.getStaffId());
				pstmt.setString(2, scheduleFormDto.getStartDay());
				pstmt.setString(3, scheduleFormDto.getEndDay());
				pstmt.setString(4, scheduleFormDto.getInformation());
				pstmt.setInt(5, scheduleFormDto.getId());
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
	
	

	@Override
	public int updateSchedule(int id, int staffId, String startDate, String endDate, String information) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(int staffId, Date startDate, Date endDate, String information) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SCHEDULE)){
				pstmt.setInt(1, staffId);
				pstmt.setDate(2, startDate);
				pstmt.setDate(3, endDate);
				pstmt.setString(4, information);
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
	public int insert(int staffId, String startDate, String endDate, String information) {
		int rowCount = 0;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SCHEDULE)){
				pstmt.setInt(1, staffId);
				pstmt.setString(2, startDate);
				pstmt.setString(3, endDate);
				pstmt.setString(4, information);
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
	public List<Schedule> getAllSchedule(int limit, int offset) {
List<Schedule> scheduleList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SCHEDUE)) {
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				scheduleList.add(
						Schedule
						.builder()
						.id(rs.getInt("id"))
						.staffId(rs.getInt("staff_id"))
						.startDay(rs.getDate("start_day"))
						.endDay(rs.getDate("end_day"))
						.information(rs.getString("information"))
						.build());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return scheduleList;
	}

	@Override
	public int getTotalScheduleCount() {
		int count = 0; 
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(COUNT_ALL_SCHEDULE)){
 			ResultSet rs = pstmt.executeQuery();
 			if(rs.next()) {
 				count = rs.getInt("count");
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" 로깅 totalCount : " + count);
		
		return count;
	}

	@Override
	public List<Schedule> selectAll() {
		List<Schedule> scheduleList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SCHEDULE_ALL_LIST)){
				ResultSet set = pstmt.executeQuery();
				conn.commit();
				while (set.next()) {
					Schedule schedule = Schedule.builder()
							  			.id(set.getInt("id"))
										.staffId(set.getInt("staff_id"))
										.startDay(set.getDate("start_day"))
										.endDay(set.getDate("end_day"))
										.information(set.getString("information"))
							  			.build();
					scheduleList.add(schedule);				
					}
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return scheduleList;
	}


}
