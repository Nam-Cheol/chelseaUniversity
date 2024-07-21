package com.chelseaUniversity.ver1.service;

import java.util.List;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.repository.BreakAppRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.BreakAppRepository;

public class BreakAppService {

	BreakAppRepository breakAppRepository = new BreakAppRepositoryImpl();

	/**
	 * @param studentId 해당 학생의 휴학 신청 내역 조회
	 */
	public List<BreakApp> readByStudentId(Integer studentId) {

		List<BreakApp> breakAppEntityList = breakAppRepository.selectByStudentId(studentId);

		return breakAppEntityList;
	}

}
