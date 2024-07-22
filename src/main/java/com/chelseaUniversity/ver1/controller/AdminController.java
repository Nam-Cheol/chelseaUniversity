package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.repository.CollegeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CollegeRepository collegeRepository;
       
	@Override
	public void init() throws ServletException {
		collegeRepository = new CollegeRepositoryImpl();
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		

		switch (action) {
		case "/college":
			showCollegePage(request, response, session);
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

	private void showCollegePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		List<College> collegeList = collegeRepository.selectCollegeDto();
		session.setAttribute("collegeList", collegeList);
		
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationCollege.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/create-college":	
			createCollege(request, response);
			break;
			
		default:
			break;
		}
	}

	private void createCollege(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String collegeName = request.getParameter("college-name");
		collegeRepository.insert(collegeName);
	}

}
