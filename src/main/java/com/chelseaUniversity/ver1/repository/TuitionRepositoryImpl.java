package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.CollTuit;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;

public class TuitionRepositoryImpl implements TuitionRepository{

	@Override
	public List<Tuition> selectByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuition> selectByStudentIdAndStatus(Integer studentId, Boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollTuit selectTuiAmountByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Tuition tuition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tuition selectByStudentIdAndSemester(Integer studentId, Integer tuiYear, Integer semester) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStatus(Integer studentId, Integer tuiYear, Integer semester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
