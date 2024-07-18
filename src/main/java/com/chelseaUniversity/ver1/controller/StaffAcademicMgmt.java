package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/*")
public class StaffAcademicMgmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StaffAcademicMgmt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인증처리
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("principal") == null) {
			response.sendRedirect(request.getContextPath() + "/user/signin");
			return;
		}
		
		String action = request.getPathInfo();
		switch (action) {
		case "/studentList":
			handleStudentList(request,response,session);
			break;
		case "/professorList":
			
			break;
		case "/student":
			
			break;
		case "/professor":
			
			break;
		case "/staff":
			
			break;

		default:
			break;
		}
	
	}

	/**
	 * 학생 명단 조회
	 * @param request
	 * @param response
	 */
	private void handleStudentList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
