package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.CollegeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.TuitionRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;
import com.chelseaUniversity.ver1.service.TuitionService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tuition/*")
public class TuitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TuitionRepository tuitionRepository;
	private StudentRepository studentRepository;

	@Override
	public void init() throws ServletException {
		tuitionRepository = new TuitionRepositoryImpl();
		studentRepository = new StudentRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		StudentInfoDto principalStu = null;
		List<Tuition> tuitionList = null;
		User userRole = (User) session.getAttribute("user");
		if ("student".equalsIgnoreCase(userRole.getUserRole())) {
			principalStu = (StudentInfoDto) session.getAttribute("principal");
			tuitionList = checkTuitionList(principalStu.getId());
		}

		switch (action) {

		// 교직원 -> 학사관리 -> 등록금 고지서 페이지
		case "/bill":
			request.getRequestDispatcher("/WEB-INF/views/tuition/createPayment.jsp").forward(request, response);
			break;

		case "/list":
			if (tuitionList != null) {
				boolean checkList = !tuitionList.isEmpty();
				request.setAttribute("tuitionList", tuitionList);
				request.setAttribute("checkList", checkList);
				request.getRequestDispatcher("/WEB-INF/views/student/tuitionHistory.jsp").forward(request, response);
			}
			break;

		case "/payment":
			if (principalStu != null) {
				tuitionList = tuitionRepository.selectByStudentId(principalStu.getId());
				boolean checkTuition = false;
				if (tuitionList.isEmpty() == false) {
					Tuition tuition = tuitionList.get(0);
					checkTuition = tuition != null ? true : false;
					request.setAttribute("tuition", tuition);
				}
				request.setAttribute("checkTuition", checkTuition);
				request.getRequestDispatcher("/WEB-INF/views/student/tuitionBill.jsp").forward(request, response);
			}
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String action = request.getPathInfo();
		switch (action) {

		// 교직원 -> 학사관리 -> 등록금 납부 고지서 생성하기
		case "/create":
			handleCreateBill(request, response, session);
			break;

		case "/payment":
			paymentTuition(request, response, session);
			break;

		case "/edit-tuition":
			editTuition(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	/**
	 * 등록금 수정 메소드
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void editTuition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int collegeId = Integer.parseInt(request.getParameter("tuition-id"));
		int collegeAmount = Integer.parseInt(request.getParameter("college-tuition-amount"));
		tuitionRepository.updateByIdAndAmount(collegeId, collegeAmount);
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
	}

	/**
	 * 교직원 -> 등록금 납부서 발송버튼 눌렀을때
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 * @throws ServletException
	 */
	private void handleCreateBill(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException, ServletException {
		TuitionService tuitionService = new TuitionService();

		List<Integer> studentIdList = studentRepository.selectIdList();

		int insertCount = 0;

		for (Integer studentId : studentIdList) {
			insertCount += tuitionService.createTuition(studentId);
		}

		request.setAttribute("insertCount", insertCount);
		request.getRequestDispatcher("/WEB-INF/views/tuition/createPayment.jsp").forward(request, response);
	}

	/**
	 * 등록금 납부 여부 확인 메소드
	 * 
	 * @param studentId
	 * @return
	 */
	private List<Tuition> checkTuitionList(int studentId) {
		List<Tuition> temp = tuitionRepository.selectByStudentId(studentId);
		List<Tuition> tuitionList = new ArrayList<>();
		for (Tuition tuition : temp) {
			if (tuition.getStatus() == true) {
				tuitionList.add(tuition);
			}
		}
		return tuitionList;
	}

	/**
	 * 등록급 납부 메소드
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	private void paymentTuition(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {

		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");

		if (principal != null) {
			try {
				tuitionRepository.updateStatus(principal.getId(), Integer.parseInt(request.getParameter("tuiYear")),
						Integer.parseInt(request.getParameter("semester")));
				response.sendRedirect(request.getContextPath() + "/tuition/payment");
			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}

	}

}
