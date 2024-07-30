package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.Evaluation;
import com.chelseaUniversity.ver1.model.dto.response.GradeDto;
import com.chelseaUniversity.ver1.model.dto.response.MyGradeDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.EvaluationRepositoryImpl;
import com.chelseaUniversity.ver1.repository.GradeRespositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.EvaluationRepository;
import com.chelseaUniversity.ver1.repository.interfaces.GradeRespository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/grade/*")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GradeRespository gradeRespository;
	private EvaluationRepository evaluationRepository;

	@Override
	public void init() throws ServletException {
		gradeRespository = new GradeRespositoryImpl();
		evaluationRepository = new EvaluationRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {
		case "/thisSemester":
			showThisSemester(request, response, session);
			break;
		case "/semester":
			showSelectSemester(request, response, session);
			break;
		case "/total":
			showTotalGrade(request, response, session);
			break;
		case "/evaluation":
			showEvaluationPage(request, response, session);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		switch (action) {
		case "/evaluation":
			sendEvaluation(request, response, session);
			break;
		case "/semester":
			searchSemesterHandler(request, response, session);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	/**
	 * 강의평가 페이지 처리
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showEvaluationPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		int subId = Integer.parseInt(request.getParameter("subjectId"));
		request.setAttribute("subId", subId);
		request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp").forward(request, response);
	}

	/**
	 * 누계 성적 페이지 처리
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showTotalGrade(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto) session.getAttribute("principal");
		int id = student.getId();
		List<MyGradeDto> myGradeList = gradeRespository.selectMyGradeDtoByStudentId(id);
		request.setAttribute("mygradeList", myGradeList);
		request.getRequestDispatcher("/WEB-INF/views/student/total.jsp").forward(request, response);
	}

	/**
	 * 학기별 성적 페이지 처리
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showSelectSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto) session.getAttribute("principal");
		int id = student.getId();
		int semester = 1;
		int year = 2023;
		List<GradeDto> grade = gradeRespository.selectGradeDtoBySemester(id, semester, year);
		List<Evaluation>evaluationList = evaluationRepository.selectEvaluationByStudentId(id);
		request.setAttribute("evaluation", evaluationList);
		request.setAttribute("gradeList", grade);
		request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);
	}

	/**
	 * 금학기 성적 페이지 처리
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showThisSemester(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		StudentInfoDto student = (StudentInfoDto) session.getAttribute("principal");
		int id = student.getId();
		List<GradeDto> gradeList = gradeRespository.selectGradeDtoByStudentIdAndSubYear(id, 2023, 1);
		MyGradeDto grade = gradeRespository.selectMyGradeDtoBySemester(id, 2023, 1);
		List<Evaluation>evaluationList = evaluationRepository.selectEvaluationByStudentId(id);
		request.setAttribute("evaluation", evaluationList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("myGrade", grade);
		request.getRequestDispatcher("/WEB-INF/views/student/thisSemester.jsp").forward(request, response);
	}

	/**
	 * 강의평가 전송하는 메소드
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void sendEvaluation(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		StudentInfoDto user = (StudentInfoDto) session.getAttribute("principal");
		int subId = Integer.parseInt(request.getParameter("subjectId"));
		int userId = user.getId();
		int answer1 = Integer.parseInt(request.getParameter("answer1"));
		int answer2 = Integer.parseInt(request.getParameter("answer2"));
		int answer3 = Integer.parseInt(request.getParameter("answer3"));
		int answer4 = Integer.parseInt(request.getParameter("answer4"));
		int answer5 = Integer.parseInt(request.getParameter("answer5"));
		int answer6 = Integer.parseInt(request.getParameter("answer6"));
		int answer7 = Integer.parseInt(request.getParameter("answer7"));
		String suggestions = request.getParameter("improvements");

		Evaluation evaluation = Evaluation.builder().answer1(answer1).answer2(answer2).answer3(answer3).answer4(answer4)
				.answer5(answer5).answer6(answer6).answer7(answer7).studentId(userId).subjectId(subId)
				.suggestions(suggestions).build();

		evaluationRepository.insert(evaluation);

		request.getRequestDispatcher("/WEB-INF/views/student/evaluation.jsp?send=true").forward(request, response);
	}

	/**
	 * 학기별로 검색하는 메소드
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchSemesterHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		StudentInfoDto student = (StudentInfoDto) session.getAttribute("principal");
		int id = student.getId();
		String Semester = request.getParameter("semester");
		String Year = request.getParameter("year");

		if (Semester == null || Year == null) {

			int semester = 1;
			int year = 2023;
			List<GradeDto> grade = gradeRespository.selectGradeDtoBySemester(id, semester, year);
			request.setAttribute("gradeList", grade);
			request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);

		} else {

			int semester = Integer.parseInt(Semester);
			int year = Integer.parseInt(Year);
			List<GradeDto> grade = gradeRespository.selectGradeDtoBySemester(id, semester, year);
			request.setAttribute("gradeList", grade);
			request.getRequestDispatcher("/WEB-INF/views/student/semester.jsp").forward(request, response);

		}

	}

}
