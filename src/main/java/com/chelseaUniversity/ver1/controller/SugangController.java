package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.PreStuSub;
import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.PreStuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.RegistrationRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubDetailRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SubjectRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.PreStuSubRepository;
import com.chelseaUniversity.ver1.repository.interfaces.RegistrationRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SubjectRepository subjectRepository;
	PreStuSubRepository preStuSubRepository;
	StuSubRepository stuSubRepository;
	StuSubDetailRepository stuSubDetailRepository;
	RegistrationRepository registrationRepository;
	
	private static final int VIEW_SUBJECT = 20;

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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		if(principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		switch (action) {
		case "/subjectList":
			showSubjectList(request, response, "/subjectList");
			break;
			
		case "/pre":
			showSubjectList(request, response, "/pre");
			break;
			
		case "/preAppList":
			request.getRequestDispatcher("/WEB-INF/views/student/sugangList.jsp").forward(request, response);
			break;
			
		case "/list":
			request.getRequestDispatcher("/WEB-INF/views/student/sugangHistory.jsp").forward(request, response);
			break;
		case "/period":
			final int SUGANG_PERIOD = 0;
			request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
			request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
			break;
		
		case "/regist":
			List<Integer> subjectList = registrationRepository.selectSubjectRegistration(principal.getId());
			request.setAttribute("subjectList", subjectList);
			request.getRequestDispatcher("/WEB-INF/views/student/preSugang.jsp").forward(request, response);
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
	 * 교직원 -> 수강신청기간 시작
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updatePeriod1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
	private void updatePeriod2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int SUGANG_PERIOD = 2;
		request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
		request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);

	}
	

	/**
	 * 강의 시간표 조회 리스트
	 * @author 남철
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void viewSubjectList(HttpServletRequest request, HttpServletResponse response, int page, String action) throws ServletException, IOException {
		
		int totalCount = subjectRepository.getTotalBoardCount();
		int totalPage = totalCount / VIEW_SUBJECT;
		int offset = (int) Math.ceil((double)(VIEW_SUBJECT * (page - 1)));
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
		
		int offset = (int) Math.ceil((double)(VIEW_SUBJECT * (page - 1)));
		List<SubjectFormDto> subjectList = null;
		
		String query;
		String select = SubjectRepositoryImpl.SELECT_SUBJECT_ALL;
		String where = SubjectRepositoryImpl.ADD_WHERE;
		String and = SubjectRepositoryImpl.ADD_AND;
		String type = SubjectRepositoryImpl.ADD_TYPE;
		String dept = SubjectRepositoryImpl.ADD_DEPT;
		String subjectName = SubjectRepositoryImpl.ADD_SUBJECT_NAME;
		String limitAndOffset = SubjectRepositoryImpl.ADD_LIMIT_AND_OFFSET;
		
		if(checkNum == 1) {
//			query = select + where + type + limitAndOffset;
			query = select + where + type;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, null, null, checkNum);
		} else if(checkNum == 2) {
			query = select + where + dept + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, null, deptId, null, checkNum);
		} else if(checkNum == 3) {
			query = select + where + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, null, null, name, checkNum);
		} else if(checkNum == 4) {
			query = select + where + type + and + dept + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, deptId, null, checkNum);
		} else if(checkNum == 5) {
			query = select + where + dept + and + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, null, deptId, name, checkNum);
		} else if(checkNum == 6) {
			query = select + where + type + and + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, null, name, checkNum);
		} else if(checkNum == 7) {
			query = select + where + type + and + dept + and + subjectName + limitAndOffset;
			subjectList = subjectRepository.selectDtoSearch(VIEW_SUBJECT, offset, query, typeValue, deptId, name, checkNum);
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
		}
	}
	
	private void showSubjectList(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
		
		String type = request.getParameter("type");
		String deptId = request.getParameter("deptId");
		String name = request.getParameter("name");
		
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
				if(Integer.parseInt(deptId) >= 101 && Integer.parseInt(deptId) < 121) {
					
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
				if((Integer.parseInt(deptId) >= 101 && Integer.parseInt(deptId) < 121) && ("전공".equals(type) || "교양".equals(type))) {
					
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
				if(Integer.parseInt(deptId) >= 101 && Integer.parseInt(deptId) < 121) {
					
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
				if((Integer.parseInt(deptId) >= 101 && Integer.parseInt(deptId) < 121) && ("전공".equals(type) || "교양".equals(type))) {
					
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
	
}
