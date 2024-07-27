package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.dto.ScheduleDto;
import com.chelseaUniversity.ver1.model.dto.ScheduleFormDto;

public interface ScheuleRepository { // todo ScheduleRepository로 변경

// 기본 기능
public int insertSchoeduleFormDto(Schedule schedule);
public int updateSchoeduleFormDtoBycontent(ScheduleFormDto scheduleFormDto);
public int deleteSchoeduleFormDtoByStaffIdAndId(Integer id);
public List<Schedule> selectSchodule(int limit,int offset);
public List<ScheduleDto> selectSchoduleMouth();


// 학사일정 조회 (디테일)
public ScheduleDto selectScheduleById(Integer id);

// 월별 학사일정 조회
public List<Schedule> selectListByMonth(Integer month);

}
