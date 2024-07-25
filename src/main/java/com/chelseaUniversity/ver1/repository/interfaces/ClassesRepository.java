package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;

public interface ClassesRepository {

	List<ClassesDto> getAllClasses(int limit, int offset);

	List<ClassesDto> getClassesById(int professorId);

	List<ClassesDto> getClassesBySearchIdName(int year, int semester, int deptId, String name);

	List<ClassesDto> getClassesBySearchName(int year, int semester, String name);

	List<ClassesDto> getClassesBySearchId(int year, int semester, int deptId);

	List<ClassesDto> getClassesBySearch(int year, int semester);

	int getBoardCount();

	ClassesDto getInfoById(int subjectId);

}
