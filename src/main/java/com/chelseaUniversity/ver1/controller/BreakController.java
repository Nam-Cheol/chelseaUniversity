package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.chelseaUniversity.ver1.model.BreakApp;
import com.chelseaUniversity.ver1.model.dto.BreakAppFormDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.BreakAppRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.BreakAppRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/break/*")
public class BreakController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BreakAppRepository breakAppRepository;
       
    public BreakController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	breakAppRepository = new BreakAppRepositoryImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		System.out.println(action);
		
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		if(principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		BreakApp app = breakAppRepository.selectByStudentIdOne(principal.getId());
		request.setAttribute("app", app);
		
		boolean application = breakAppRepository.selectByStudentIdOne(principal.getId()) != null ? true : false;
		request.setAttribute("application", application);
		
		
		if(action != null || action.trim().isEmpty()) {
			
			switch (action) {
			case "/application":
				request.getRequestDispatcher("/WEB-INF/views/student/breakApplication.jsp").forward(request, response);
				break;
				
			case "/list":
				request.getRequestDispatcher("/WEB-INF/views/student/breakHistory.jsp").forward(request, response);
				break;
				
			case "/detail":
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					app = breakAppRepository.selectById(id);
					request.setAttribute("app", app);
					request.setAttribute("principal", principal);
					request.getRequestDispatcher("/WEB-INF/views/student/breakHistoryDetail.jsp").forward(request, response);
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					response.sendRedirect("/WEB-INF/views/student/breakHistory.jsp");
				}
				
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}
			
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println(action);
		HttpSession session = request.getSession();
		StudentInfoDto principal = (StudentInfoDto) session.getAttribute("principal");
		if(principal == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		if(action != null || action.trim().isEmpty()) {
			
			switch (action) {
			case "/application":
				insertBreakApplication(request, response, principal);
				response.sendRedirect(request.getContextPath() + "/break/list");
				break;
				
			case "/list":
				
				break;
			
			case "/delete":
				
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					breakAppRepository.deleteById(id);
					request.getRequestDispatcher("/WEB-INF/views/student/breakHistory.jsp").forward(request, response);
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					response.sendRedirect("/WEB-INF/views/student/breakHistory.jsp");
				}
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}
			
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	private void insertBreakApplication(HttpServletRequest request, HttpServletResponse response,
			StudentInfoDto principal) {
		BreakAppFormDto dto = BreakAppFormDto.builder()
								.studentId(principal.getId())
								.studentGrade(principal.getGrade())
								// TODO - 년도, 학기 하드코딩 중 수정 필
								.fromYear(2024)
								.fromSemester(1)
								.toYear(Integer.parseInt(request.getParameter("toYear")))
								.toSemester(Integer.parseInt(request.getParameter("toSemester")))
								.type(request.getParameter("type"))
								.build();
		
		if(dto != null) {
			breakAppRepository.insert(dto);
		}
	}

}
