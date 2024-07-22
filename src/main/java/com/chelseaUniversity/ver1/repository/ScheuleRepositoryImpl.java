package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.dto.ScheduleDto;
import com.chelseaUniversity.ver1.model.dto.ScheduleFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;

public class ScheuleRepositoryImpl implements ScheuleRepository{

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
		// TODO Auto-generated method stub
		return null;
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
