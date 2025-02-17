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
	// TODO - Controller 통합 필요
	private BreakAppRepository breakAppRepository;

	@Override
	public void init() throws ServletException {
		breakAppRepository = new BreakAppRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		if (principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		if (action != null || action.trim().isEmpty()) {

			switch (action) {
			case "/info":
				showBreakHistory(request, response, principal);
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}

		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void showBreakHistory(HttpServletRequest request, HttpServletResponse response, StudentInfoDto principal)
			throws ServletException, IOException {
		BreakApp app = breakAppRepository.selectByStudentIdOne(principal.getId());
		if (app != null) {
			request.setAttribute("app", app);
		}
		request.getRequestDispatcher("/WEB-INF/views/user/myInfo.jsp").forward(request, response);
	}

}
