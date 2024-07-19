package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.dto.StudentListForm;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.response.PrincipalDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.UserRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.UserRepository;

@WebServlet("/user/*")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentRepository studentRepository;
	private StudentListForm studentListForm;
	private UserRepository userRepository;
	
	@Override
	public void init() throws ServletException {
	studentRepository = new StudentRepositoryImpl();
	studentListForm = new StudentListForm();
		userRepository = new UserRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		System.out.println("액션 : " + action);
		switch (action) {
		case "/signin":
			showSignIn(request, response, session);
			break;

		case "/studentList":
			showStudentListPage(request, response, session);
			break;

		case "/professorList":
			showProfessorListPage(request, response, session);
			break;

		case "/student":
			showStudentCreatePage(request, response, session);
			break;

		case "/professor":
			showProfessorCreatePage(request, response, session);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	/**
	 * 교직원 -> 학생 명단 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showStudentListPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {

			// TODO - 교직원이 맞는지 인증검사

//			int limit = Integer.parseInt(request.getParameter("limit"));
			int limit = 20;
			int page = 1;

			try {
				String pageStr = request.getParameter("stu_list_page");
				if (pageStr != null) {
					page = Integer.parseInt(pageStr);
				}
			} catch (Exception e) {
				// 유효하지 않은 번호를 마음대로 보낸 경우
				page = 1;
			}

			int offset = (page - 1) * limit;
			
			// 전체 학생 수
			int totalStudents = studentRepository.selectStudentAmount();

			// 총 페이지 수 계산
			int totalPages = (int) Math.ceil((double) totalStudents / limit);

			List<Student> allStudentList = studentRepository.selectStudentList(studentListForm, limit , offset);

			request.setAttribute("allStudentList", allStudentList);
			request.setAttribute("totalStudents", totalStudents);
			request.setAttribute("totalPages", totalPages);

			request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 교직원 -> 교수 명단 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showProfessorListPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		try {
			request.getRequestDispatcher("/WEB-INF/views/user/professorList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 교직원 -> 학생 등록하기
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showStudentCreatePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/user/createStudent.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 교직원 -> 교수 등록하기
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showProfessorCreatePage(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/user/createProfessor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 로그인 화면 처리
	 */
	private void showSignIn(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/sign/signin.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		System.out.println("액션 : " + action);
		switch (action) {
		case "/signin":
			signInHandler(request, response, session);
			break;

		default:
			break;
		}
	}

	/*
	 * 로그인 기능 처리
	 */
	private void signInHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		User user = userRepository.selectById_Password(id, password);
		if(user != null) {
			if(user.getUserRole().equals("student")) {
				StudentInfoDto student = userRepository.studentById(id);
				session.setAttribute("principal", student);
				response.sendRedirect(request.getContextPath());
				System.out.println("학생으로 로그인");
			} else if(user.getUserRole().equals("professor")) {
				ProfessorInfoDto professor = userRepository.professorById(id);
				session.setAttribute("principal", professor);
				response.sendRedirect(request.getContextPath());
				System.out.println("교수로 로그인");
			} else {
				Staff staff = userRepository.staffById(id);
				session.setAttribute("principal", staff);
				response.sendRedirect(request.getContextPath());
				System.out.println("교직원으로 로그인");
			}
		} else {
				response.sendRedirect(request.getContextPath()+"/user/signin?pass=false");
		}
	}

}
