package com.chelseaUniversity.ver1.controller;

import java.io.IOException;

import com.chelseaUniversity.ver1.model.dto.SyllabusDto;
import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.repository.ClassesRepositoryImpl;
import com.chelseaUniversity.ver1.repository.ProfessorRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SyllabusRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;
import com.chelseaUniversity.ver1.repository.interfaces.ProfessorRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SyllaBusRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/syllabus/*")
public class SyllabusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SyllaBusRepository syllaBusRepository;
	private ClassesRepository classesRepository;
	private ProfessorRepository professorRepository;

	public SyllabusController() {
		syllaBusRepository = new SyllabusRepositoryImpl();
		classesRepository = new ClassesRepositoryImpl();
		professorRepository = new ProfessorRepositoryImpl();
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
		int subjectId = Integer.parseInt(request.getParameter("id"));
		ClassesDto info = classesRepository.getInfoById(subjectId);
		ProfessorInfoDto professorInfo = professorRepository.selectProfessorById(info.getProfessorId());
		SyllabusDto syllabusInfo = syllaBusRepository.getInfoById(subjectId);
		request.setAttribute("info", info);
		request.setAttribute("professorInfo", professorInfo);
		request.setAttribute("syllabusInfo", syllabusInfo);
		request.getRequestDispatcher("/WEB-INF/views/syllabus/info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession(false);
		switch (action) {
		case "/update":
			showUpdatePage(request, response, session);
			break;

		case "/submit":
			submitUpdate(request, response, session);
			break;

		default:
			break;
		}
	}

	private void submitUpdate(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException, ServletException {
		SyllabusDto syllaBus = new SyllabusDto();
		int subjectId = Integer.parseInt(request.getParameter("id"));
		syllaBus = SyllabusDto.builder().overview(request.getParameter("overview"))
				.objective(request.getParameter("objective")).textbook(request.getParameter("textbook"))
				.program(request.getParameter("program")).build();
		syllaBusRepository.updateById(subjectId, syllaBus);
		showInfo(request, response, session);
	}

	private void showUpdatePage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		int subjectId = Integer.parseInt(request.getParameter("id"));
		SyllabusDto syllabusInfo = syllaBusRepository.getInfoById(subjectId);
		request.setAttribute("syllabusInfo", syllabusInfo);
		request.getRequestDispatcher("/WEB-INF/views/syllabus/update.jsp").forward(request, response);
	}
}
