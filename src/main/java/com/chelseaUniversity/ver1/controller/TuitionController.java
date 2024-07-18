package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/tuition/*")
public class TuitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TuitionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인증처리
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("") == null) {
		 * response.sendRedirect(request.getContextPath() + "/user/signin"); return; }
		 */
		
		String action = request.getPathInfo();
		switch (action) {
		
		// 교직원 -> 학사관리 -> 등록금 고지서 발송
		case "/bill":
			request.getRequestDispatcher("/WEB-INF/views/tuition/createPayment.jsp").forward(request, response);
//			showSendBillPage(request,response,session);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	
	}

	/**
	 * 교직원 -> 학사관리 -> 등록금 고지서 발송 페이지
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showSendBillPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
