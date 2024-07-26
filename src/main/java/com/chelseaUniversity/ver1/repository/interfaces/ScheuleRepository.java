package com.chelseaUniversity.ver1.repository.interfaces;

import java.sql.Date;
import java.util.List;

import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.dto.ScheduleDto;
import com.chelseaUniversity.ver1.model.dto.ScheduleFormDto;

public interface ScheuleRepository { // todo ScheduleRepository로 변경

// 기본 기능
public int insertSchoeduleFormDto(Schedule schedule);
public int updateSchoeduleFormDtoBycontent(ScheduleFormDto scheduleFormDto);
public int deleteSchoeduleFormDtoByStaffIdAndId(Integer id);
public List<Schedule> selectSchodule();
public List<ScheduleDto> selectSchoduleMouth();


// 학사일정 조회 (디테일)
public ScheduleDto selectScheduleById(Integer id);

// 월별 학사일정 조회
public List<Schedule> selectListByMonth(Integer month);


public List<Schedule> selectAll();
public int updateSchedule(int id, int staffId, String startDate, String endDate, String information);
public int insert(int staffId, Date startDate, Date endDate, String information);
public int insert(int staffId, String startDate, String endDate, String information);
// 페이징처리 전체리스트
public List<Schedule> getAllSchedule(int limit, int offset);
public int getTotalScheduleCount();

}
