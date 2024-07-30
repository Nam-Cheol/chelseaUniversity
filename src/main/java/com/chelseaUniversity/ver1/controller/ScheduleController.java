package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.repository.ScheuleRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;

@WebServlet("/schedule/*")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ScheuleRepository scheuleRepository;
       
	@Override
	public void init() throws ServletException {
		scheuleRepository = new ScheuleRepositoryImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		switch (action) {
		case "/list":
			showSchedulePage(request,response,session);
			break;
		default:
			break;
		}
		
	}

	/*
	 * 학사일정 페이지 처리
	 */
	private void showSchedulePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int limit = 20;
		int offset = 0;
		List<Schedule>scheduleList = scheuleRepository.selectSchodule(limit, offset);
		request.setAttribute("scheduleList", scheduleList);
		request.getRequestDispatcher("/WEB-INF/views/student/schedule.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
