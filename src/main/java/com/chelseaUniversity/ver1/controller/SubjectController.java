package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.repository.ClassesRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/subject/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesRepository classesRepository;

	public SubjectController() {
		classesRepository = new ClassesRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		HttpSession session = request.getSession();

		switch (action) {
		case "/list":
			showLists(request, response, session);
			break;

		case "/search":
			showSearch(request, response, session);
			break;

		default:

			break;
		}
	}

	private void showSearch(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		List<ClassesDto> classesList = new ArrayList<>();
		int year = Integer.parseInt(request.getParameter("subYear"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String name = request.getParameter("name");
		if (!name.isEmpty() && deptId != -1) {
			System.out.println("search - id and name");
			classesList = classesRepository.getClassesBySearchIdName(year, semester, deptId, name);
		} else if (!name.isEmpty() && deptId == -1) {
			System.out.println("search - name");
			classesList = classesRepository.getClassesBySearchName(year, semester, name);
		} else if (name.isEmpty() && deptId != -1) {
			System.out.println("search - id");
			classesList = classesRepository.getClassesBySearchId(year, semester, deptId);
		} else if (name.isEmpty() && deptId == -1) {
			System.out.println("search - null");
			classesList = classesRepository.getClassesBySearch(year, semester);
		} else {

		}
		int rowCount = classesList.size();
		request.setAttribute("classesList", classesList);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("isSearch", "true");

		request.getRequestDispatcher("/WEB-INF/views/student/subject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void showLists(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		int page = 1;
		int pageSize = 20;

		try {
			String pageStr = request.getParameter("page");
			if (pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}

		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
		List<ClassesDto> classesList = classesRepository.getAllClasses(pageSize, offset);

		// 전체 게시글 수 조회
		int totalBoards = classesRepository.getBoardCount();
		// 총 페이지 수 계산
		int totalPages = (int) Math.ceil((double) totalBoards / pageSize);

		request.setAttribute("classesList", classesList);
		request.setAttribute("rowCount", totalBoards);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);

		request.getRequestDispatcher("/WEB-INF/views/student/subject.jsp").forward(request, response);
	}

}
