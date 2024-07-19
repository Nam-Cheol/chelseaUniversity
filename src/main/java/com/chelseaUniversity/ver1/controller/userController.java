package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.response.PrincipalDto;
import com.chelseaUniversity.ver1.repository.UserRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.UserRepository;

@WebServlet("/user/*")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository;
	
	@Override
	public void init() throws ServletException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		System.out.println("액션 : " + action);
		switch (action) {
		case "/signin":
			signInHandler(request,response,session);
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
				String name = userRepository.studentById(id);
				PrincipalDto principal = PrincipalDto.builder().id(user.getId())
						.password(user.getPassword()).userRole(user.getUserRole())
						.name(name).build();
				session.setAttribute("principal", principal);
				response.sendRedirect(request.getContextPath());
			} else if(user.getUserRole().equals("professor")) {
				String name = userRepository.professorById(id);
				PrincipalDto principal = PrincipalDto.builder().id(user.getId())
						.password(user.getPassword()).userRole(user.getUserRole())
						.name(name).build();
				session.setAttribute("principal", principal);
				response.sendRedirect(request.getContextPath());
			} else {
				String name = userRepository.staffById(id);
				PrincipalDto principal = PrincipalDto.builder().id(user.getId())
						.password(user.getPassword()).userRole(user.getUserRole())
						.name(name).build();
				session.setAttribute("principal", principal);
				response.sendRedirect(request.getContextPath());
			}
		} else {
				response.sendRedirect(request.getContextPath()+"/user/signin?pass=false");
		}
	}

}
