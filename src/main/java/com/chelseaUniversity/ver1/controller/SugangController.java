package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.util.Introspection;

import com.chelseaUniversity.ver1.model.CheckSubjectTime;
import com.chelseaUniversity.ver1.model.PreStuSub;
import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.model.SubjectHistory;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.PreStuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.RegistrationRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubDetailRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SubjectRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SugangStatusImpl;
import com.chelseaUniversity.ver1.repository.interfaces.PreStuSubRepository;
import com.chelseaUniversity.ver1.repository.interfaces.RegistrationRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SugangStatus;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int FIRST_DEPT_ID = 101;
	private static final int LAST_DEPT_ID = 120;
	private static final int VIEW_SUBJECT = 20;

	SubjectRepository subjectRepository;
	PreStuSubRepository preStuSubRepository;
	StuSubRepository stuSubRepository;
	StuSubDetailRepository stuSubDetailRepository;
	RegistrationRepository registrationRepository;
	
	SugangStatus sugangStatus;


	public SugangController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		subjectRepository = new SubjectRepositoryImpl();
		preStuSubRepository = new PreStuSubRepositoryImpl();
		stuSubRepository = new StuSubRepositoryImpl();
		stuSubDetailRepository = new StuSubDetailRepositoryImpl();
		registrationRepository = new RegistrationRepositoryImpl();
		sugangStatus = new SugangStatusImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		
		if(principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		List<Integer> subjectIdList = registrationRepository.selectSubjectRegistration(principal.getId());
		request.setAttribute("subjectIdList", subjectIdList);
		int totalGrade;
		List<SubjectHistory> historyList;

		switch (action) {
		case "/subjectList":
			showSubjectList(request, response, "/subjectList");
			break;

		case "/pre":
			showSubjectList(request, response, "/pre");
			break;

		case "/preAppList":
			totalGrade = registrationRepository.totalGrades(principal.getId());
			historyList = registrationRepository.resistrationHistory(principal.getId());
			
			request.setAttribute("totalGrade", totalGrade);
			request.setAttribute("historyList", historyList);
			request.getRequestDispatcher("/WEB-INF/views/student/sugangList.jsp").forward(request, response);
			break;

		case "/list":
			totalGrade = registrationRepository.totalGrades(principal.getId());
			historyList = registrationRepository.resistrationHistory(principal.getId());
			
			request.setAttribute("totalGrade", totalGrade);
			request.setAttribute("historyList", historyList);
			request.getRequestDispatcher("/WEB-INF/views/student/sugangHistory.jsp").forward(request, response);
			break;
		case "/period":
			sugangStatus.updatePrePeriod("진행");
			final int SUGANG_PERIOD = 2;
			request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
			request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
			break;
		
		case "/regist":
			registrationSubject(request, response, principal);
			break;
			
		case "/delete":
			deleteSubject(request, response, principal);
			break;
			
		case "/application":
			showSubjectList(request, response, "/application");
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		switch (action) {
		case "/updatePeriod0":
			updatePeriod0(request, response);
			break;
		case "/updatePeriod1":
			updatePeriod1(request, response);
			break;
		case "/updatePeriod2":
			updatePeriod2(request, response);
			break;
		case "/subjectList":
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	/**
	 * 교직원 -> 예비 수강신청 기간 시작
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updatePeriod0(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 예비 수강신청 기간 시작
		sugangStatus.updatePrePeriod("진행");
		final int SUGANG_PERIOD = 0;
		request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
		request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
	}

	/**
	 * 교직원 -> 수강신청기간 시작
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updatePeriod1(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 강의 정원 >= 예비 수강신청 인원 (정원 초과X)
		List<Integer> lessIdList = subjectRepository.selectIdByLessNumOfStudent();
		for (Integer subjectId : lessIdList) {
			List<PreStuSub> preAppList = preStuSubRepository.selectBySubjectId(subjectId);
			for (PreStuSub preSutSub : preAppList) {
				if (stuSubRepository.selectByStudentIdAndSubjectId(preSutSub.getStudentId(),
						preSutSub.getSubjectId()) == null) {
					stuSubRepository.insert(preSutSub.getStudentId(), preSutSub.getSubjectId());

					StuSub stuSub = stuSubRepository.selectByStudentIdAndSubjectId(preSutSub.getStudentId(),
							preSutSub.getSubjectId());
					stuSubDetailRepository.insert(stuSub.getId(), preSutSub.getStudentId(), preSutSub.getSubjectId());
				}
			}
		}

		// 강의 정원 < 예비 수강신청 인원 (정원 초과O)
		List<Integer> moreIdList = subjectRepository.selectIdByMoreNumOfStudent();
		for (Integer subjectId : moreIdList) {
			subjectRepository.updateNumOfStudent(subjectId, "초기화");
		}

		// 수강 신청기간 상태값 변경 (예비수강, 본수강 순서)
		sugangStatus.updateAllSugangPeriod("종료", "진행");
		final int SUGANG_PERIOD = 1;
		request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
		request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/sugang/period");
	}

	/**
	 * 교직원 -> 수강신청 기간 종료
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void updatePeriod2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 본수강신청 기간 종료
		sugangStatus.updateSugangPeriod("종료");
		final int SUGANG_PERIOD = 2;
		request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
		request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
	}

	/**
	 * 강의 시간표 조회 리스트
	 * 
	 * @author 남철
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void viewSubjectList(HttpServletRequest request, HttpServletResponse response, int page, String action) throws ServletException, IOException {
		
		int totalCount = subjectRepository.getTotalBoardCount();
		int totalPage = totalCount / VIEW_SUBJECT;
		int offset = (int) Math.ceil((double) (VIEW_SUBJECT * (page - 1)));
		List<SubjectFormDto> subjectList = subjectRepository.selectDtoAll(VIEW_SUBJECT, offset);

		request.setAttribute("subjectList", subjectList);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		
		if("/subjectList".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/student/subjectList.jsp").forward(request, response);
		} else if ("/pre".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/student/preSugang.jsp").forward(request, response);
		}
		
	}
	
	private void searchSubjectList(HttpServletRequest request, HttpServletResponse response, int page, int checkNum, String typeValue, String deptId, String name, String action) throws ServletException, IOException {
		
		int offset = (int) Math.ceil((double) (VIEW_SUBJECT * (page - 1)));
		List<SubjectFormDto> subjectList = null;

		String query;
		String select = SubjectRepositoryImpl.SELECT_SUBJECT_ALL;
		String where = SubjectRepositoryImpl.ADD_WHERE;
		String and = SubjectRepositoryImpl.ADD_AND;
		String type = SubjectRepositoryImpl.ADD_TYPE;
		String dept = SubjectRepositoryImpl.ADD_DEPT;
		String subjectName = SubjectRepositoryImpl.ADD_SUBJECT_NAME;
		String limitAndOffset = SubjectRepositoryImpl.ADD_LIMIT_AND_OFFSET;

		if (checkNum == 1) {
			query = select + where + type;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, null, null, checkNum);
		} else if (checkNum == 2) {
			query = select + where + dept + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, null, deptId, null, checkNum);
		} else if (checkNum == 3) {
			query = select + where + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, null, null, name, checkNum);
		} else if (checkNum == 4) {
			query = select + where + type + and + dept + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, deptId, null, checkNum);
		} else if (checkNum == 5) {
			query = select + where + dept + and + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, null, deptId, name, checkNum);
		} else if (checkNum == 6) {
			query = select + where + type + and + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, null, name,
					checkNum);
		} else if (checkNum == 7) {
			query = select + where + type + and + dept + and + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, deptId, name,	checkNum);
		} else {
			subjectList = subjectRepository.selectDtoAll(VIEW_SUBJECT, offset);
		}

		int totalCount = subjectList.size();
		int totalPage = totalCount / VIEW_SUBJECT;
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("checkNum", checkNum);
		
		if("/subjectList".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/student/subjectList.jsp").forward(request, response);
		} else if ("/pre".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/student/preSugang.jsp").forward(request, response);
		} else if ("/application".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/student/sugang.jsp").forward(request, response);
		}
	}
	
	private void showSubjectList(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
		int page = 1;
		try {
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
		} catch (NumberFormatException e) {
			page = 1;
		}
		
		String type = null;
		String deptId = null;
		String name = null;
		
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		
		if(request.getParameter("deptId") != null) {
			deptId = request.getParameter("deptId");
		}
		
		if(request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		
		// TODO - 학과 코드 변동 코드 작성 - 수정예정
		if(type == null && deptId == null && name == null) {
			
			viewSubjectList(request, response, page, action);
			
		} else if("전체".equals(type) && "-1".equals(deptId) && name.trim().isEmpty()) {
			
			viewSubjectList(request, response, page, action);
			
		} else if(!"전체".equals(type) && "-1".equals(deptId) && name.trim().isEmpty()) {
			
			if("전공".equals(type) || "교양".equals(type)) {
				searchSubjectList(request, response, page, 1, type, null, null, action);
			}
			
		} else if("전체".equals(type) && !"-1".equals(deptId) && name.trim().isEmpty()) {
			
			try {
				if(Integer.parseInt(deptId) >= FIRST_DEPT_ID && Integer.parseInt(deptId) <= LAST_DEPT_ID) {
					
					searchSubjectList(request, response, page, 2, null, deptId, null, action);
					
				} else {
					viewSubjectList(request, response, page, action);
				}
			} catch (Exception e) {
				e.printStackTrace();
				viewSubjectList(request, response, page, action);
			}
			
		} else if("전체".equals(type) && "-1".equals(deptId) && !name.trim().isEmpty()) {
			
			searchSubjectList(request, response, page, 3, null, null, name, action);
			
		} else if(!"전체".equals(type) && !"-1".equals(deptId) && name.trim().isEmpty()) {
			
			try {
				if((Integer.parseInt(deptId) >= FIRST_DEPT_ID && Integer.parseInt(deptId) <= LAST_DEPT_ID) && ("전공".equals(type) || "교양".equals(type))) {
					
					searchSubjectList(request, response, page, 4, type, deptId, null, action);
					
				} else {
					viewSubjectList(request, response, page, action);
				}
			} catch (Exception e) {
				e.printStackTrace();
				viewSubjectList(request, response, page, action);
			}
			
		} else if("전체".equals(type) && !"-1".equals(deptId) && !name.trim().isEmpty()) {
			
			try {
				if(Integer.parseInt(deptId) >= FIRST_DEPT_ID && Integer.parseInt(deptId) <= LAST_DEPT_ID) {
					
					searchSubjectList(request, response, page, 5, null, deptId, name, action);
					
				} else {
					viewSubjectList(request, response, page, action);
				}
			} catch (Exception e) {
				e.printStackTrace();
				viewSubjectList(request, response, page, action);
			}
			
		} else if(!"전체".equals(type) && "-1".equals(deptId) && !name.trim().isEmpty()) {
			
			if("전공".equals(type) || "교양".equals(type)) {
				searchSubjectList(request, response, page, 6, type, null, name, action);
			}
			
		} else if(!"전체".equals(type) && !"-1".equals(deptId) && !name.trim().isEmpty()) {
			
			try {
				if((Integer.parseInt(deptId) >= FIRST_DEPT_ID && Integer.parseInt(deptId) <= LAST_DEPT_ID) && ("전공".equals(type) || "교양".equals(type))) {
					
					searchSubjectList(request, response, page, 7, type, deptId, name, action);
					
				} else {
					viewSubjectList(request, response, page, action);
				}
			} catch (Exception e) {
				e.printStackTrace();
				viewSubjectList(request, response, page, action);
			}
			
		} else {
			
			viewSubjectList(request, response, page, action);
			
		}
		
	}
	
	private void registrationSubject(HttpServletRequest request, HttpServletResponse response,
			StudentInfoDto principal) throws ServletException, IOException {

		List<CheckSubjectTime> checkTimeList = registrationRepository.registSubjectTime(principal.getId());
		
		if(!checkTimeList.isEmpty()) {
			String subDay = request.getParameter("subDay");
			String startTimeStr = request.getParameter("startTime");
			String endTimeStr = request.getParameter("endTime");
			
			for (CheckSubjectTime checkSubjectTime : checkTimeList) {
				
				if(checkSubjectTime.getSubDay().equals(subDay)) {
					
					int startTime = Integer.parseInt(startTimeStr);
					int endTime = Integer.parseInt(endTimeStr);
					int checkStartTime = Integer.parseInt(checkSubjectTime.getStartTime());
					int checkEndTime = Integer.parseInt(checkSubjectTime.getEndTime());
					
					if((checkStartTime <= startTime && startTime <= checkEndTime) || (checkStartTime <= endTime && endTime <= checkEndTime)) {
						
						String message = "중복된 수업시간이 있습니다.";

				        // 메시지를 요청 속성으로 설정
				        request.setAttribute("message", message);
				        showSubjectList(request, response, "/pre");
				        return;
						
					}
					
				}
				
			}
		}
		
		String registSubIdStr = request.getParameter("id");
		
		try {
			int subId = Integer.parseInt(registSubIdStr);
			
			if(!principal.getDeptId().equals(registrationRepository.checkDepartment(subId, principal.getId())) && "전공".equals(request.getParameter("subType"))) {
				
				String message = "학과 내 전공만 신청이 가능합니다.";

		        // 메시지를 요청 속성으로 설정
		        request.setAttribute("message", message);
		        showSubjectList(request, response, "/pre");
		        return;
			}
			
			List<Integer> checkList = registrationRepository.selectSubjectRegistration(principal.getId());
			System.out.println(checkList);
			if(!checkList.contains(subId)) {
				registrationRepository.insertSubjectRegistration(principal.getId(), subId);
				registrationRepository.addNumOfStudent(subId);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		showSubjectList(request, response, "/pre");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response, StudentInfoDto principal) throws ServletException, IOException {
		String deleteSubIdStr = request.getParameter("id");
		
		try {
			int subId = Integer.parseInt(deleteSubIdStr);
			List<Integer> checkList = registrationRepository.selectSubjectRegistration(principal.getId());
			System.out.println(checkList);
			if(checkList.contains(subId)) {
				registrationRepository.deleteSubjectRegistration(principal.getId(), subId);
				registrationRepository.deleteNumOfStudent(subId);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		showSubjectList(request, response, "/pre");
	}
	
}
