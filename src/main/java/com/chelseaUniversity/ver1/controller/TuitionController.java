package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.service.StuStatService;
import com.chelseaUniversity.ver1.service.TuitionService;

@WebServlet("/tuition/*")
public class TuitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인증처리
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("") == null) {
		 * response.sendRedirect(request.getContextPath() + "/user/signin"); return; }
		 */

		String action = request.getPathInfo();
		switch (action) {

		// 교직원 -> 학사관리 -> 등록금 고지서 페이지
		case "/bill":
			request.getRequestDispatcher("/WEB-INF/views/tuition/createPayment.jsp").forward(request, response);
			break;

		case "/list":
			request.getRequestDispatcher("/WEB-INF/views/student/tuitionHistory.jsp").forward(request, response);
			break;

		case "/payment":
			request.getRequestDispatcher("/WEB-INF/views/student/tuitionBill.jsp").forward(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인증처리
		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("") == null) {
//			response.sendRedirect(request.getContextPath() + "/user/signin");
//			return;
//		}

		String action = request.getPathInfo();
		switch (action) {

		// 교직원 -> 학사관리 -> 등록금 납부 고지서 생성하기
		case "/create":
			handleCreateBill(request, response, session);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

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
		StuStatService stuStatService = new StuStatService();
		TuitionService tuitionService = new TuitionService();
		List<Integer> studentIdList = stuStatService.readIdList();

		int insertCount = 0;

		for (Integer studentId : studentIdList) {
			insertCount += tuitionService.createTuition(studentId);
		}

		request.setAttribute("insertCount", insertCount);
		request.getRequestDispatcher("/WEB-INF/views/tuition/createPayment.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/tuition/bill");
	}

}
