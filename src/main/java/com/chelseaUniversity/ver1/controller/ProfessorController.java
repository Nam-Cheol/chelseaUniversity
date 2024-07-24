package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.model.StuSubDetail;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.response.ClassesDto;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.repository.ClassesRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubDetailRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ClassesRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubRepository;

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
	private StuSubRepository stuSubRepository;

	public ProfessorController() {
		classesRepository = new ClassesRepositoryImpl();
		stuSubDetailRepository = new StuSubDetailRepositoryImpl();
		stuSubRepository = new StuSubRepositoryImpl();
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

			case "/manageStudent":
				showUpdateJsp(request, response);
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}

		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

	private void showUpdateJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		StuSubDetail student = stuSubDetailRepository.selectById(studentId);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/views/professor/manageStudent.jsp").forward(request, response);
	}

	private void showStudentList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int subjectId = Integer.parseInt(request.getParameter("id"));
		List<StuSubDetail> studentList = stuSubDetailRepository.selectListById(subjectId);
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
			updateSubjectDetail(request, response);
			break;

		default:
			break;
		}

	}

	private void updateSubjectDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int absent = 0, lateness = 0, homework = 0, midExam = 0, finalExam = 0, convertedMark = 0;
		StuSubDetail stuSubDetail = new StuSubDetail();
		if (request.getParameter("absent") != null) {
			absent = Integer.parseInt(request.getParameter("absent"));
		}
		if (request.getParameter("lateness") != null) {
			lateness = Integer.parseInt(request.getParameter("lateness"));
		}
		if (request.getParameter("homework") != null) {
			homework = Integer.parseInt(request.getParameter("homework"));
		}
		if (request.getParameter("midExam") != null) {
			midExam = Integer.parseInt(request.getParameter("midExam"));
		}
		if (request.getParameter("finalExam") != null) {
			finalExam = Integer.parseInt(request.getParameter("finalExam"));
		}
		if (request.getParameter("convertedMark") != null) {
			convertedMark = Integer.parseInt(request.getParameter("convertedMark"));
		}
		stuSubDetail = StuSubDetail.builder().id(Integer.parseInt(request.getParameter("id")))
				.subjectId(Integer.parseInt(request.getParameter("subjectId"))).absent(absent).lateness(lateness)
				.homework(homework).midExam(midExam).finalExam(finalExam).convertedMark(convertedMark)
				.grade(request.getParameter("grade")).build();
		stuSubDetailRepository.updateGrade(stuSubDetail);
		stuSubRepository.updateGradeByStudentIdAndSubjectId(stuSubDetail);
		showPossessive(request, response);
	}

}
