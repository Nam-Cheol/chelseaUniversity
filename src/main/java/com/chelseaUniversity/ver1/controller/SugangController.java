package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.PreStuSub;
import com.chelseaUniversity.ver1.model.StuSub;
import com.chelseaUniversity.ver1.repository.PreStuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubDetailRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuSubRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SubjectRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.PreStuSubRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubDetailRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuSubRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SubjectRepository subjectRepository;
	PreStuSubRepository preStuSubRepository;
	StuSubRepository stuSubRepository;
	StuSubDetailRepository stuSubDetailRepository;

	public SugangController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		subjectRepository = new SubjectRepositoryImpl();
		preStuSubRepository = new PreStuSubRepositoryImpl();
		stuSubRepository = new StuSubRepositoryImpl();
		stuSubDetailRepository = new StuSubDetailRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);

		switch (action) {
		case "/list":
			request.getRequestDispatcher("/WEB-INF/views/student/sugang.jsp").forward(request, response);
			break;
		case "/period":
			final int SUGANG_PERIOD = 0;
			request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
			request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		switch (action) {
		case "/updatePeriod1":
			updatePeriod1(request, response);
			break;
		case "/updatePeriod2":
			updatePeriod2(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	/**
	 * 교직원 -> 수강신청기간 시작
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updatePeriod1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 강의 정원 >= 예비 수강신청 인원 (정원 초과X)
		List<Integer> lessIdList = subjectRepository.selectIdByLessNumOfStudent();
		for (Integer subjectId : lessIdList) {
			List<PreStuSub> preAppList = preStuSubRepository.selectBySubjectId(subjectId);
			for (PreStuSub preSutSub : preAppList) {
				if (stuSubRepository.selectByStudentIdAndSubjectId(preSutSub.getStudentId(),
						preSutSub.getSubjectId()) == null) {
					stuSubRepository.insert(preSutSub.getStudentId(), preSutSub.getSubjectId());

					StuSub stuSub = stuSubRepository.selectByStudentIdAndSubjectId(preSutSub.getStudentId(),
							preSutSub.getSubjectId());
					stuSubDetailRepository.insert(stuSub.getId(), preSutSub.getStudentId(), preSutSub.getSubjectId());
				}
			}
		}

		// 강의 정원 < 예비 수강신청 인원 (정원 초과O)
		List<Integer> moreIdList = subjectRepository.selectIdByMoreNumOfStudent();
		for (Integer subjectId : moreIdList) {
			subjectRepository.updateNumOfStudent(subjectId, "초기화");
		}

		final int SUGANG_PERIOD = 1;
		request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
		request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/sugang/period");
	}

	/**
	 * 교직원 -> 수강신청 기간 종료
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updatePeriod2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int SUGANG_PERIOD = 2;
		request.setAttribute("SUGANG_PERIOD", SUGANG_PERIOD);
		request.getRequestDispatcher("/WEB-INF/views/staff/sugangPeriod.jsp").forward(request, response);

	}

}
