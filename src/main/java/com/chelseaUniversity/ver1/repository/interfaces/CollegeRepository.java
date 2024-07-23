package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.dto.CollegeFormDto;

/*
 *  박성희
 *  단과대 repository
 */

public interface CollegeRepository {
	public int insert(String CollegeFormDto);
	public List<College> selectCollegeDto();
	public int selectCollegeDtoByName(String name);
	public College selectCollegeDtoById(Integer id);
	public int deleteById(Integer id);
	public int updateByNameAndId(String name, int id);
}
