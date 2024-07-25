package com.chelseaUniversity.ver1.controller;

import java.io.IOException;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.BreakAppRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.BreakAppRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BreakAppRepository breakAppRepository;   
	
    public StudentController() {
        super();
        breakAppRepository = new BreakAppRepositoryImpl();
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
				BreakApp app = breakAppRepository.selectByStudentIdOne(principal.getId());
				if(app != null) {
					request.setAttribute("app", app);
				}
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
