package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.Subject;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.repository.CollegeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SubjectRepositoryImpl;
import com.chelseaUniversity.ver1.repository.TuitionRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;

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
	TuitionRepository tuitionRepository;
	SubjectRepository subjectRepository;
       
    public AdminController() {
    }
	@Override
	public void init() throws ServletException {
		collegeRepository = new CollegeRepositoryImpl();
		tuitionRepository = new TuitionRepositoryImpl();
		subjectRepository = new SubjectRepositoryImpl();
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		

		switch (action) {
		case "/college":
			showCollegePage(request, response, session);
			break;
		case "/department":
			// TODO 파일만 생성 해놓음 기능 구현 예정
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationDepartment.jsp").forward(request, response);
			break;
		case "/room":
			request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationRoom.jsp").forward(request, response);
			break;
		case "/subject":
			showSubjectPage(request, response, session);
			break;
		case "/tuition":
			showTuitionPage(request, response, session);
			break;
		default:
			break;
		}
		
		
	}

	private void showSubjectPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Subject> subjectList = subjectRepository.selectSubject();
		session.setAttribute("subjectList", subjectList);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationSubject.jsp").forward(request, response);
	}
	private void showTuitionPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Tuition> tuitionList = tuitionRepository.selectAmount();
		session.setAttribute("tuitionList", tuitionList);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationTuition.jsp").forward(request, response);
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
		case "/edit-college":	
			editCollege(request, response);
			break;
		case "/tuition/edit-tuition":	
			editTuition(request, response);
			break;
		case "/tuition/create-tuition-name":
			createTuitionName(request, response);
			break;
		case "/tuition/create-tuition-amount":
			createTuitionAmount(request, response);
			break;
		case "/subject/create-subject":
			createSubject(request, response);
			break;
		default:
			break;
		}
	}
	
	private void createSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String subjectName = request.getParameter("subject-name");
		int professorId = Integer.parseInt(request.getParameter("professor-id")); 
		String roomId = request.getParameter("romm-id");
		int deptId = Integer.parseInt(request.getParameter("dept-id")); 
		String type = request.getParameter("type");
		int subYear = Integer.parseInt(request.getParameter("subject-year")); 
		int semester = Integer.parseInt(request.getParameter("semester")); 
		String subDay = request.getParameter("subject-day");
		int startTime = Integer.parseInt(request.getParameter("start-time")); 
		int endTime = Integer.parseInt(request.getParameter("end-time")); 
		int grades = Integer.parseInt(request.getParameter("grades")); 
		int capacity = Integer.parseInt(request.getParameter("capacity")); 
		int numOfStudent = Integer.parseInt(request.getParameter("number-of-student"));
		
		subjectRepository.insert(subjectName, professorId, roomId, deptId, type, subYear, semester, subDay, startTime, endTime, grades, capacity, numOfStudent);
		
		response.sendRedirect(request.getContextPath() + "/admin/subject");
	}
	
	private void createTuitionAmount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int collegeId = Integer.parseInt(request.getParameter("college-id")); 
		int collegeAmount = Integer.parseInt(request.getParameter("college-tuition-amount")); 
		tuitionRepository.insertAmount(collegeId, collegeAmount);
		
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
		
	}
	private void createTuitionName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String collegeName = request.getParameter("college-name");
		collegeRepository.insert(collegeName);
		
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
	}
	
	private void editTuition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("editTuition 성공");
		int collegeId = Integer.parseInt(request.getParameter("tuition-id"));
		int collegeAmount = Integer.parseInt(request.getParameter("college-tuition-amount"));
		tuitionRepository.updateByIdAndAmount(collegeId, collegeAmount);
		
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
	}

	private void editCollege(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String collegeName = request.getParameter("college-name");
		int collegeId = Integer.parseInt(request.getParameter("college-id")); 
		collegeRepository.updateByNameAndId(collegeName, collegeId);
		
		response.sendRedirect(request.getContextPath() + "/admin/college");
	}
	
	private void createCollege(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String collegeName = request.getParameter("college-name");
		collegeRepository.insert(collegeName);
		
		response.sendRedirect(request.getContextPath() + "/admin/college");
	}

}
