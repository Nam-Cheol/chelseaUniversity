package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.dto.SyllabusDto;

public interface SyllaBusRepository {

	int updateById(int subjectId, SyllabusDto syllabusDto);

	void deleteById(int subjectId);

	SyllabusDto getInfoById(int subjectId);

}
