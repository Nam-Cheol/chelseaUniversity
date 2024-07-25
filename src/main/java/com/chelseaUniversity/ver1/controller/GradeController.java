package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/grade/*")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GradeController() {
    }

    @Override
    public void init() throws ServletException {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/thisSemester":
			request.getRequestDispatcher("/WEB-INF/views/student/thisSemester.jsp").forward(request, response);
			break;
			
		case "/semester":
			request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);
			break;
			
		case "/total":
			request.getRequestDispatcher("/WEB-INF/views/student/total.jsp").forward(request, response);
			break;
			
		case "/evaluation":
			request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp").forward(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		
		case "/evaluation":
			request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp").forward(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

}
