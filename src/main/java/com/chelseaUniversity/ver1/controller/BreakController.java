package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.BreakAppFormDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.BreakAppRepositoryImpl;
import com.chelseaUniversity.ver1.repository.CollegeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.DepartmentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuStatRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.BreakAppRepository;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;
import com.chelseaUniversity.ver1.repository.interfaces.DepartmentRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuStatRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;
import com.chelseaUniversity.ver1.service.BreakAppService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/break/*")
public class BreakController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BreakAppRepository breakAppRepository;
	BreakAppService breakAppService;
	StudentRepository studentRepository;
	DepartmentRepository departmentRepository;
	CollegeRepository collegeRepository;
	StuStatRepository stuStatRepository;

	public BreakController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		breakAppRepository = new BreakAppRepositoryImpl();
		breakAppService = new BreakAppService();
		studentRepository = new StudentRepositoryImpl();
		departmentRepository = new DepartmentRepositoryImpl();
		collegeRepository = new CollegeRepositoryImpl();
		stuStatRepository = new StuStatRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println(action);

		HttpSession session = request.getSession();
		StudentInfoDto principalStu = null;
		Staff principalSta = null;
		User userRole = (User) session.getAttribute("user");
		if("student".equalsIgnoreCase(userRole.getUserRole())) {
			principalStu = (StudentInfoDto) session.getAttribute("principal");
		} else if("staff".equalsIgnoreCase(userRole.getUserRole())) {
			principalSta = (Staff) session.getAttribute("principal");
		}
		
		BreakApp app = null;
		if(principalStu != null) {
			app = breakAppRepository.selectByStudentIdOne(principalStu.getId());
			request.setAttribute("app", app);
			
			boolean application = breakAppRepository.selectByStudentIdOne(principalStu.getId()) != null ? true : false;
			request.setAttribute("application", application);
		}


		if (action != null || action.trim().isEmpty()) {

			switch (action) {
			case "/application":
				request.getRequestDispatcher("/WEB-INF/views/student/breakApplication.jsp").forward(request, response);
				break;

			case "/list":
				request.getRequestDispatcher("/WEB-INF/views/student/breakHistory.jsp").forward(request, response);
				break;

			case "/list/staff":
				readBreakList(request, response, session);
				break;

			case "/breakDetail":
				readBreakDetail(request, response, session);
				request.getRequestDispatcher("/WEB-INF/views/staff/breakDetail.jsp").forward(request, response);
				break;

			case "/detail":
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					app = breakAppRepository.selectById(id);
					request.setAttribute("app", app);
					request.setAttribute("principal", principalStu);
					request.getRequestDispatcher("/WEB-INF/views/student/breakHistoryDetail.jsp").forward(request,
							response);

				} catch (NumberFormatException e) {
					e.printStackTrace();
					response.sendRedirect("/WEB-INF/views/student/breakHistory.jsp");
				}

				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}

		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * 교직원 -> 휴학 요청 들어왔는지 확인
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void readBreakList(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		try {
			List<BreakApp> breakAppList = breakAppRepository.selectByStatus("처리중");
			request.setAttribute("breakAppList", breakAppList);
			request.getRequestDispatcher("/WEB-INF/views/staff/breakListStaff.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 교직원 -> 휴학 신청 상세보기
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void readBreakDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("id"));
		// 휴학신청 상태 받아오기
		BreakApp breakApp = breakAppRepository.selectById(id);
		// 학생 정보
		Student studentInfo = studentRepository.selectByStudentId(breakApp.getStudentId());
		// 소속 학과 이름
		Department deptInfo = departmentRepository.selectById(studentInfo.getDeptId());
		// 소속 단과대 이름
		College college = collegeRepository.selectCollegeDtoById(deptInfo.getCollegeId());

		request.setAttribute("breakApp", breakApp);
		request.setAttribute("studentInfo", studentInfo);
		request.setAttribute("deptInfo", deptInfo);
		request.setAttribute("college", college);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println(action);
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		if (principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		if (action != null || action.trim().isEmpty()) {

			switch (action) {
			case "/application":
				insertBreakApplication(request, response, principal);
				response.sendRedirect(request.getContextPath() + "/break/list");
				break;

			case "/list":

				break;
			case "/update":
				updateBreak(request, response, session);
				break;
			case "/delete":

				try {
					int id = Integer.parseInt(request.getParameter("id"));
					breakAppRepository.deleteById(id);
					request.getRequestDispatcher("/WEB-INF/views/student/breakHistory.jsp").forward(request, response);

				} catch (NumberFormatException e) {
					e.printStackTrace();
					response.sendRedirect("/WEB-INF/views/student/breakHistory.jsp");
				}
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}

		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * 교직원 -> 휴학 처리 (승인 혹은 반려)
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 */
	private void updateBreak(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

		String breakStatus = request.getParameter("status");
		int breakId = Integer.parseInt(request.getParameter("id"));
		BreakApp breakApp = breakAppRepository.selectById(breakId);
		breakAppRepository.updateById(breakApp.getId(), breakStatus);

		if (breakStatus.equals("승인")) {
			BreakApp breakAppEntity = breakAppRepository.selectById(breakApp.getId());
			String newToDate = null;
			if (breakAppEntity.getToSemester() == 1) {
				newToDate = breakAppEntity.getToYear() + "-08-31";
			} else {
				newToDate = (breakAppEntity.getToYear() + 1) + "-02-28";
			}
			// 가장 최근 기존 학적 상태
			List<StuStat> stuStatInfo = stuStatRepository.selectByStudentIdOrderbyIdDesc(breakApp.getStudentId());
			// 기존 학적 상태에서 to_date를 now()로 변경 + 휴학상태로 변경
			int updateToNowDate = stuStatRepository.updateOldStatus(stuStatInfo.get(0).getId());
			int updateBreakSta = stuStatRepository.updateStatusToBreak("휴학", stuStatInfo.get(0).getId());
			// 새로운 학적 상태 추가
			int insertRowCount = stuStatRepository.insert(breakAppEntity.getStudentId(), "휴학", newToDate,
					breakApp.getId());

			if (updateToNowDate + updateBreakSta + insertRowCount == 3) {
				request.setAttribute("acceptBreak", breakApp);
			}
		}

		response.sendRedirect(request.getContextPath()+"/break/list/staff");
		
	}

	private void insertBreakApplication(HttpServletRequest request, HttpServletResponse response,
			StudentInfoDto principal) {
		BreakAppFormDto dto = BreakAppFormDto.builder().studentId(principal.getId()).studentGrade(principal.getGrade())
				// TODO - 년도, 학기 하드코딩 중 수정 필
				.fromYear(2024).fromSemester(1).toYear(Integer.parseInt(request.getParameter("toYear")))
				.toSemester(Integer.parseInt(request.getParameter("toSemester"))).type(request.getParameter("type"))
				.build();

		if (dto != null) {
			breakAppRepository.insert(dto);
		}
	}

}
