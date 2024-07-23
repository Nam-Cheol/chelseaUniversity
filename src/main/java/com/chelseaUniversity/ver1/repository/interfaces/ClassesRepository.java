package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;

public interface ClassesRepository {

	List<ClassesDto> getAllClasses(int limit, int offset);

	List<ClassesDto> getClassesById(int professorId);

	List<ClassesDto> getClassesBySearch(int year, int semester, int deptId, String name);

	int getBoardCount();

	ClassesDto getInfoById(int subjectId);

}
