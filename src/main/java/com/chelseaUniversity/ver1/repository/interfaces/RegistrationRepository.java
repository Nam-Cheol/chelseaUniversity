package com.chelseaUniversity.ver1.repository.interfaces;

import java.util.List;

import com.chelseaUniversity.ver1.model.CheckSubjectTime;
import com.chelseaUniversity.ver1.model.SubjectHistory;

public interface RegistrationRepository {

	// 예비 수강신청 적용
	void insertPreSubjectRegistration(int stuId, int subId);
	
	// 예비 수강신청 취소
	void deletePreSubjectRegistration(int stuId, int subId);
	
	// 수강신청 적용
	void insertSubjectRegistration(int stuId, int subId);
	
	// 수강신청 취소
	void deleteSubjectRegistration(int stuId, int subId);
	
	// 예비 수강신청 했는 지 확인 여부
	List<Integer> selectPreSubjectRegistration(int stuId);
	
	// 수강신청 했는 지 확인 여부
	List<Integer> selectSubjectRegistration(int stuId);
	
	// 수강 정원 추가 기능
	void addNumOfStudent(int id);
	
	// 수강 정원 삭제 기능
	void deleteNumOfStudent(int id);
	
	// 학과 내 전공인지 확인
	int checkDepartment(int subjectId, int studentId);
	
	// 수강신청 내역 중 같은 시간이 있는 지 확인
	List<CheckSubjectTime> registSubjectTime(int studentId, String query);
	
	// 신청 학점 총합 반환
	int preTotalGrades(int studentId);
	
	// 신청한 수강과목 내역에 올리기 위한 리스트
	List<SubjectHistory> resistrationHistory(int studentId);
	
	// 본 수강신청 내역에 올리기 위한 리스트
	SubjectHistory resistrationHistory(int studentId, int subjectId, String query);
	
	// 수강신청 상태 확인
	String isSugangSeason();
	
	// 예비 수강신청 상태 확인
	String isPreSugangSeason();
	
	// 예비 수강신청에 실패한 학수번호 리스트
	List<Integer> failResistration(int studentId);
	
	// 예비 수강신청에 성공한 학수번호 리스트
	List<Integer> successResistration(int studentId);
	
	// 본 수강 신청에서 신청 완료된 총 학점 반환
	int totalGrades(int studentId);
	
	// 본 수강 신청에서 정원 초과 시 리턴
	boolean checkCapacity(int subjectId);
}
