package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.repository.ClassesRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/subjects/*")
public class ClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesRepository classesRepository;

	public ClassesController() {
		classesRepository = new ClassesRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession(false);
		switch (action) {
		case "/list":
			showLists(request, response, session);
			break;
			
		default:
			break;
		}
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
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);

		// 현재 로그인한 사용자 ID 설정
		if (session != null) {
			User user = (User) session.getAttribute("principal");
			if (user != null) {
				request.setAttribute("userId", user.getId());
			}
		}
		request.getRequestDispatcher("/WEB-INF/views/class/subject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
