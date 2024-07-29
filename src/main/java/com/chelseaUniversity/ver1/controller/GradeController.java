package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.dto.response.GradeDto;
import com.chelseaUniversity.ver1.model.dto.response.MyGradeDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.GradeRespositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.GradeRespository;

@WebServlet("/grade/*")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GradeRespository gradeRespository;
	
	@Override
	public void init() throws ServletException {
		gradeRespository = new GradeRespositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {
		case "/thisSemester":
			showThisSemester(request, response,session);
			break;
		case "/semester":
			showSelectSemester(request,response,session);
			break;
		case "/total":
			showTotalGrade(request,response,session);
			break;
		case "/evaluation":
			request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	/*
	 * 누계 성적 페이지 처리
	 */
	private void showTotalGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto)session.getAttribute("principal");
		int id = student.getId();
		List<MyGradeDto>myGradeList =  gradeRespository.selectMyGradeDtoByStudentId(id);
		request.setAttribute("mygradeList", myGradeList);
		request.getRequestDispatcher("/WEB-INF/views/student/total.jsp").forward(request, response);
	}

	/*
	 * 학기별 성적 페이지 처리
	 */
	private void showSelectSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto)session.getAttribute("principal");
		int id = student.getId();
		int semester = 1;
		int year = 2023;
		List<GradeDto>grade = gradeRespository.selectGradeDtoBySemester(id,semester,year);
		request.setAttribute("gradeList", grade);
		request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);
	}

	/*
	 * 금학기 성적 페이지 처리
	 */
	private void showThisSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto)session.getAttribute("principal");
		int id = student.getId();
		List<GradeDto>gradeList = gradeRespository.selectGradeDtoByStudentIdAndSubYear(id, 2023, 1);
		MyGradeDto grade = gradeRespository.selectMyGradeDtoBySemester(id, 2023, 1);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("myGrade", grade);
		request.getRequestDispatcher("/WEB-INF/views/student/thisSemester.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {
		case "/evaluation":
			request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp").forward(request, response);
			break;
		case "/semester":
			searchSemesterHandler(request,response,session);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	/*
	 * 학기별로 검색
	 */
	private void searchSemesterHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto)session.getAttribute("principal");
		int id = student.getId();
		String Semester = request.getParameter("semester");
		String Year = request.getParameter("year");
		if(Semester == null || Year == null) {
			int semester = 1;
			int year = 2023;
			List<GradeDto>grade = gradeRespository.selectGradeDtoBySemester(id,semester,year);
			request.setAttribute("gradeList", grade);
			request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);
		} else {
			int semester = Integer.parseInt(Semester);
			int year = Integer.parseInt(Year);
			List<GradeDto>grade = gradeRespository.selectGradeDtoBySemester(id,semester,year);
			request.setAttribute("gradeList", grade);
			request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);
		}
		
	}

}
