package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.Notice;
import com.chelseaUniversity.ver1.repository.NoticeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.NoticeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeRepository noticeRepository;

	public NoticeController() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		noticeRepository = new NoticeRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		
		switch (action) {
		case "/list":
			showListPage(request,response);
			break;
		case "/detail":
			showDetailPage(request,response);
		default:
			break;
		}
		
	}

	/*
	 * 공지사항 디테일 페이지 처리
	 */
	private void showDetailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("page"));
		System.out.println(id);
		Notice notice = noticeRepository.selectById(id);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/board/noticeDetail.jsp").forward(request, response);
	}

	/*
	 * 공지사항 리스트 페이지 처리
	 */
	private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
