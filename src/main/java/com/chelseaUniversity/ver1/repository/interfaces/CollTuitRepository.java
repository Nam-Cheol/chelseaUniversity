package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.dto.CollTuitFormDto;

/*
 *  박성희
 *  단과대별 등록금 repository
 */

public interface CollTuitRepository {
	public int insert(CollTuitFormDto collTuitFormDto);
	public List<CollTuitFormDto> selectByCollTuitDto();
	public int deleteById(Integer collegeId);
	public int updateByCollTuitDto(CollTuitFormDto collTuitFormDto);
}
