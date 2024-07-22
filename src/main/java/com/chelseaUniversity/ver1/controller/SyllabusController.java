package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.repository.ClassesRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SyllabusRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SyllaBusRepository;

@WebServlet("/syllabus/*")
public class SyllabusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SyllaBusRepository syllaBusRepository;
	private ClassesRepository classesRepository;

	public SyllabusController() {
		syllaBusRepository = new SyllabusRepositoryImpl();
		classesRepository = new ClassesRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("principal") == null) {
//			response.sendRedirect(request.getContextPath() + "/user/signin");
//			return;
//		}
		switch (action) {
		case "/info":
			showInfo(request, response, session);
			break;

		default:
			break;
		}
	}

	private void showInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ClassesDto info = classesRepository.getInfoById(id);
		request.setAttribute("info", info);
		request.getRequestDispatcher("/WEB-INF/views/syllabus/info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/update":
			break;

		case "/delete":
			break;

		default:
			break;
		}
	}

}
