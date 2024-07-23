package com.chelseaUniversity.ver1.controller;

import java.io.IOException;

import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println(action);
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		if(principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		if(action != null || action.trim().isEmpty()) {
			
			switch (action) {
			case "/info":
				request.getRequestDispatcher("/WEB-INF/views/professor/myInfo.jsp").forward(request, response);
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
