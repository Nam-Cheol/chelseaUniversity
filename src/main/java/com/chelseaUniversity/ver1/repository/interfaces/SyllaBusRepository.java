package com.chelseaUniversity.ver1.repository.interfaces;

import com.chelseaUniversity.ver1.model.SyllaBus;

public interface SyllaBusRepository {

	int updateById(int subjectId, SyllaBus syllaBus);

	void deleteById(int subjectId);

}
