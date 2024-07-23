package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.repository.ClassesRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubDetailRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesRepository classesRepository;
	private StuSubDetailRepository stuSubDetailRepository;

	public ProfessorController() {
		classesRepository = new ClassesRepositoryImpl();
		stuSubDetailRepository = new StuSubDetailRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		try {
			ProfessorInfoDto principal = (ProfessorInfoDto) session.getAttribute("principal");
			if (principal == null) {
				response.sendRedirect("index.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		if (action != null || action.trim().isEmpty()) {

			switch (action) {
			case "/info":
				request.getRequestDispatcher("/WEB-INF/views/professor/myInfo.jsp").forward(request, response);
				break;

			case "/subject":
				showPossessive(request, response);
				break;

			case "/studentList":
				showStudentList(request, response);
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}

		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

	private void showStudentList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int subjectId = Integer.parseInt(request.getParameter("id"));
		List<StuSubDetail> studentList = stuSubDetailRepository.selectById(subjectId);
		ClassesDto subject = classesRepository.getInfoById(subjectId);

		request.setAttribute("studentList", studentList);
		request.setAttribute("subject", subject);

		request.getRequestDispatcher("/WEB-INF/views/professor/studentList.jsp").forward(request, response);
	}

	private void showPossessive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int professorId = user.getId();

		List<ClassesDto> classesList = classesRepository.getClassesById(professorId);

		request.setAttribute("classesList", classesList);

		request.getRequestDispatcher("/WEB-INF/views/professor/possessive.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		try {
			ProfessorInfoDto principal = (ProfessorInfoDto) session.getAttribute("principal");
			if (principal == null) {
				response.sendRedirect("index.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		switch (action) {
		case "/manageStudent":
			System.out.println("1");
			break;

		default:
			break;
		}
		
	}

}
