package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println(action);
		
		if(action != null || action.trim().isEmpty()) {
			
			switch (action) {
			case "/info":
				request.getRequestDispatcher("/WEB-INF/views/student/myInfo.jsp").forward(request, response);
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}
			
		} else {
			response.sendRedirect(request.getContextPath());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
