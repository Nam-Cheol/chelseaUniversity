package com.chelseaUniversity.ver1.service;

import java.util.List;

import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.repository.StuStatRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.StuStatRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;

public class StuStatService {

	StudentRepository studentRepository = new StudentRepositoryImpl();
	StuStatRepository stuStatRepository = new StuStatRepositoryImpl();

	/**
	 * 모든 학생 id 리스트
	 */
	public List<Integer> readIdList() {
		List<Integer> idList = studentRepository.selectIdList();
		return idList;
	}

	/**
	 * @param studentId
	 * @return 해당 학생의 현재 학적 상태 (.getStatus())
	 */
	public StuStat readCurrentStatus(Integer studentId) {
		StuStat stuStatEntity = stuStatRepository.selectByStudentIdOrderbyIdDesc(studentId).get(0);
		return stuStatEntity;
	}

}
