package com.chelseaUniversity.ver1.service;

import java.util.List;

import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;

public class StuStatService {

	/**
	 * 모든 학생 id 리스트
	 */
	public List<Integer> readIdList() {

		StudentRepository studentRepository = new StudentRepositoryImpl();
		
		List<Integer> idList = studentRepository.selectIdList();

		return idList;
	}
	
}
