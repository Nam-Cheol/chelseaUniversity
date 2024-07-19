package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.SubjectFormDto;
import com.chelseaUniversity.ver1.model.dto.response.SubjectRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/subject/*")
public class subjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectRepository subjectRepository;

	@Override
	public void init() throws ServletException {
		subjectRepository = new SubjectRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {
		case "/list":
			showSubjectList(request, response, session);
			break;

		default:
			break;
		}
	}

	/*
	 * 로그인 화면 처리
	 */
	private void showSubjectList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int page = 1; // 기본 페이지 번호
		int pageSize = 3; // 한 페이지당 보여질 게시글에 수

		try {
			String pageStr = request.getParameter("page");
			if (pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}

		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
		List<SubjectFormDto> subjectList = subjectRepository.selectDtoAll(pageSize, offset);

		// 전체 게시글 수 조회
		int totalBoards = subjectRepository.getTotalBoardCount();
		// 총 페이지 수 계산 --> [1][2][3][...]
		int totalPages = (int) Math.ceil((double) totalBoards / pageSize);

		request.setAttribute("subjectList", subjectList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		if(session != null) {
			 User user = (User)session.getAttribute("principal");
			 if(user != null) {
				 request.setAttribute("userId", user.getId());
			 }
		}
		request.getRequestDispatcher("/WEB-INF/views/class/subject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
