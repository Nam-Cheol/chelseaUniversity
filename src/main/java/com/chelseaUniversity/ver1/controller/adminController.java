package com.chelseaUniversity.ver1.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/*")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();

		switch (action) {
		case "/college":
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationCollege.jsp").forward(request, response);
			break;
		case "/department":
			// TODO 경로만 생성해놓음 파일생성 예정
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationDepartment.jsp").forward(request, response);
			break;
		case "/room":
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationRoom.jsp").forward(request, response);
			break;
		case "/subject":
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationSubject.jsp").forward(request, response);
			break;
		case "/tuition":
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationTuition.jsp").forward(request, response);
			break;
		default:
			break;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
