package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

public interface RegistrationRepository {

	// 예비 수강신청 적용
	void insertSubjectRegistration(int stuId, int subId);
	
	// 예비 수강신청 취소
	void deleteSubjectRegistration(int stuId, int subId);
	
	// 수강신청 했는 지 확인 여부
	List<Integer> selectSubjectRegistration(int stuId);
	
	// 수강 정원 추가 기능
	void addNumOfStudent(int id);
	
	// 수강 정원 삭제 기능
	void deleteNumOfStudent(int id);
	
}
