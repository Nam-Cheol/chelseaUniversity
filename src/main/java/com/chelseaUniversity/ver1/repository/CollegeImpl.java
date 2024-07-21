package com.chelseaUniversity.ver1.repository;

import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.dto.CollegeFormDto;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;

public class CollegeImpl implements CollegeRepository{
	
	// College -> dto
	// CollegeRepository -> dao
	// CollegeImpl -> daoImpl

	@Override
	public int insert(CollegeFormDto CollegeFormDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<College> selectCollegeDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCollegeDtoByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public College selectCollegeDtoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
