package com.chelseaUniversity.ver1.service;

import com.chelseaUniversity.ver1.model.Scholarship;
import com.chelseaUniversity.ver1.model.StuSch;
import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.model.dto.response.GradeForScholarshipDto;
import com.chelseaUniversity.ver1.repository.TuitionRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;
import com.chelseaUniversity.ver1.utill.Define;

public class TuitionService {

	StuStatService stuStatService = new StuStatService();
	TuitionRepository tuitionRepository = new TuitionRepositoryImpl();
	UserService userService = new UserService();
	GradeService gradeService = new GradeService();

	/**
	 * 장학금 유형 결정
	 */
	public Integer createCurrentSchType(Integer studentId) {

		StuSch stuSch = new StuSch();
		stuSch.setStudentId(studentId);
		stuSch.setSchYear(Define.CURRENT_YEAR);
		stuSch.setSemester(Define.CURRENT_SEMESTER);

		Student studentEntity = userService.readStudent(studentId);

		// 1학년 2학기 이상의 학생이라면
		if (studentEntity.getGrade() > 1 || studentEntity.getSemester() == 2) {
			// 직전 학기 성적 평균
			// 상수로 선언해둬서 노란줄 뜨는 거니까 무시하기
			GradeForScholarshipDto gradeDto = null;
			if (Define.CURRENT_SEMESTER == 1) {
				gradeDto = gradeService.readAvgGrade(studentId, Define.CURRENT_YEAR - 1, 2);
			} else {
				gradeDto = gradeService.readAvgGrade(studentId, Define.CURRENT_YEAR, 1);
			}

			if (gradeDto == null) {
				scholarshipRepository.insertCurrentSchType(stuSch);
				return null;
			} else {
				Double avgGrade = gradeDto.getAvgGrade();
				// 평점에 따라 장학금 유형 결정
				if (avgGrade >= 4.2) {
					stuSch.setSchType(1);
				} else if (avgGrade >= 3.7) {
					stuSch.setSchType(2);
				}
			}

			// 1학년 1학기 학생이라면
		} else {
			stuSch.setSchType(2);
		}

		scholarshipRepository.insertCurrentSchType(stuSch);
		return stuSch.getSchType();
	}

	/**
	 * 등록금 고지서 생성 교직원 탭에서 사용하도록 할 것
	 * 
	 * @param studentId (principal의 id와 동일)
	 */
	public int createTuition(Integer studentId) {

		// 해당 학생의 학적 상태가 '졸업' 또는 '자퇴'라면 생성하지 않음
		StuStat stuStatEntity = stuStatService.readCurrentStatus(studentId);
		if (stuStatEntity.getStatus().equals("졸업") || stuStatEntity.getStatus().equals("자퇴")) {
			return 0;
		}

//		// 해당 학생이 현재 학기 휴학을 승인받은 상태라면 생성하지 않음
//		List<BreakApp> breakAppList = breakAppService.readByStudentId(studentId); // 최근 순으로 정렬되어 있음
//		for (BreakApp b : breakAppList) {
//			// 휴학 신청이 승인된 상태일 때
//			if (b.getStatus().equals("승인")) {
//				// 휴학 종료 연도가 현재 연도보다 이후라면 생성하지 않음
//				if (b.getToYear() > Define.CURRENT_YEAR) {
//					return 0;
//					// 휴학 종료 연도가 현재 연도와 같을 경우
//				} else if (b.getToYear() == Define.CURRENT_YEAR) {
//					// 현재 학기 == 1 && 종료 학기 == 1이면 생성하지 않음
//					// 현재 학기 == 1 && 종료 학기 == 2이면 생성하지 않음
//					// 현재 학기 == 2 && 종료 학기 == 1이면 생성함
//					// 현재 학기 == 2 && 종료 학기 == 2이면 생성하지 않음
//					if (b.getToSemester() >= Define.CURRENT_SEMESTER) {
//						return 0;
//					}
//				}
//			}
//		}

//		// 이미 해당 학기의 등록금 고지서가 존재한다면 생성하지 않음
//		if (readByStudentIdAndSemester(studentId, Define.CURRENT_YEAR, Define.CURRENT_SEMESTER) != null) {
//			return 0;
//		}

		// 등록금액
		Integer tuiAmount = tuitionRepository.selectTuiAmountByStudentId(studentId).getAmount();
		System.out.println("tuiAmount : " + tuiAmount);
		// 장학금 유형 결정 + 유형 반환 (null이면 장학금 지원 대상이 아님)
		Integer schType = createCurrentSchType(studentId);

		// 장학금 유형과 최대 장학금액
		Scholarship schEntity = null;

		// 장학금액 (장학금 지원 대상이 아니면 0)
		Integer schAmount = 0;

//		if (schType != null) {
//			schEntity = scholarshipRepository.selectByStudentIdAndSemester(studentId, Define.CURRENT_YEAR,
//					Define.CURRENT_SEMESTER);
//			// 등록금액보다 최대 장학금액이 더 크다면
//			if (tuiAmount < schAmount) {
//				schAmount = tuiAmount;
//			} else {
//				schAmount = schEntity.getMaxAmount();
//			}
//		}

		// 등록금 고지서 생성
//		Tuition tuition = new Tuition(studentId, Define.CURRENT_YEAR, Define.CURRENT_SEMESTER, tuiAmount, schType, schAmount);
		Tuition tuition = new Tuition(studentId, Define.CURRENT_YEAR, Define.CURRENT_SEMESTER, tuiAmount, null,
				schAmount);

		int resultRowCount = tuitionRepository.insert(tuition);

		// 등록금 고지서가 생성된 횟수를 출력하기 위해 반환
		return resultRowCount;
	}

}
