package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.chelseaUniversity.ver1.model.Professor;
import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.CreateProfessorDto;
import com.chelseaUniversity.ver1.model.dto.CreateStudentDto;
import com.chelseaUniversity.ver1.model.dto.ProfessorListForm;
import com.chelseaUniversity.ver1.model.dto.StudentListForm;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.ProfessorRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.UserRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.ProfessorRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;
import com.chelseaUniversity.ver1.repository.interfaces.UserRepository;
import com.chelseaUniversity.ver1.service.ProfessorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentRepository studentRepository;
	private ProfessorRepository professorRepository;
	private StudentListForm studentListForm;
	private ProfessorListForm professorListForm;
	private UserRepository userRepository;

	@Override
	public void init() throws ServletException {
		studentRepository = new StudentRepositoryImpl();
		professorRepository = new ProfessorRepositoryImpl();
		studentListForm = new StudentListForm();
		professorListForm = new ProfessorListForm();
		userRepository = new UserRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		System.out.println("액션 : " + action);
		switch (action) {
		case "/signin":
			showSignIn(request, response, session);
			break;

		case "/studentList":
			showStudentListPage(request, response, session);
			break;

		case "/professorList":
			showProfessorListPage(request, response, session);
			break;
		case "/professorList/pro_list_page{i}":
			showProfessorListByPage(request, response, session);
			break;

		case "/student":
			showStudentCreatePage(request, response, session);
			break;

		case "/professor":
			showProfessorCreatePage(request, response, session);
			break;
		case "/findid":
			showFindIdPage(request, response, session);
			break;
		case "/findpassword":
			showFindPasswordPage(request, response, session);
			break;

		case "/searchStudent":
			searchStudentList(request, response, session);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void showProfessorListByPage(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		
		try {
			ProfessorService professorService = new ProfessorService();
			if (request.getAttribute("pro_deptId") != null) {
				professorListForm.setDeptId(Integer.parseInt((String) request.getAttribute("pro_deptId")));
			}
			professorListForm.setPage((Integer.parseInt((String) request.getAttribute("page")) - 1) * 20);
			Integer amount = professorService.readProfessorAmount(professorListForm);
			List<Professor> list = professorService.readProfessorList(professorListForm);
			
			request.setAttribute("listCount", Math.ceil(amount / 20.0));
			request.setAttribute("professorList", list);
			request.setAttribute("page", professorListForm.getPage());
			
			response.sendRedirect(request.getContextPath()+"/user/professorList");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 비밀번호 찾기 페이지 처리
	 */
	private void showFindPasswordPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		System.out.println("비밀번호 찾기");
		request.getRequestDispatcher("/WEB-INF/views/find/findPassword.jsp").forward(request, response);
	}

	/*
	 * 아이디 찾기 페이지 처리
	 */
	private void showFindIdPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/find/findId.jsp").forward(request, response);
	}

	/**
	 * 학생 정보 검색 - 학과id, 학번, 몇 개씩 볼 지
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 */
	private void searchStudentList(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws NumberFormatException, IOException, ServletException {
		studentListForm = new StudentListForm();

		String deptId = request.getParameter("dept_id").trim();
		String stuId = request.getParameter("stu_id").trim();
		String limit = request.getParameter("limit");
		
		if(deptId != null) {
			studentListForm.setDeptId(Integer.parseInt(deptId));
		}else if(stuId != null) {
			studentListForm.setStudentId(Integer.parseInt(stuId));
		}else if(limit != null) {
			studentListForm.setPage(Integer.parseInt(limit));
		}

		try {

			if (request.getParameter("dept_id") != null) {

				studentListForm.setDeptId(Integer.parseInt(deptId));
				studentListForm.setPage(Integer.parseInt(limit));

				System.out.println("1 : " + deptId);
				System.out.println("3" + limit);

				List<Student> student = studentRepository.selectByDepartmentId(studentListForm);
				request.setAttribute("allStudentList", student);
				System.out.println("11111111" + student);
				request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);

			}
			
			if (request.getParameter("stu_id") != null) {
				
				studentListForm.setDeptId(Integer.parseInt(stuId));
				studentListForm.setPage(Integer.parseInt(limit));
				
				System.out.println("1 : " + stuId);
				System.out.println("3" + limit);
				
				Student student = studentRepository.selectByStudentId(Integer.parseInt(stuId));
				request.setAttribute("oneStudent", student);
				System.out.println("222222222" + student);
				request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 교직원 -> 학생 명단 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showStudentListPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {

			// TODO - 교직원이 맞는지 인증검사

			int limit = 20;
			int page = 1;

			try {
				String pageStr = request.getParameter("stu_list_page");
				if (pageStr != null) {
					page = Integer.parseInt(pageStr);
				}
			} catch (Exception e) {
				// 유효하지 않은 번호를 마음대로 보낸 경우
				page = 1;
			}

			int offset = (page - 1) * limit;

			// 전체 학생 수
			int totalStudents = studentRepository.selectStudentAmount();

			// 총 페이지 수 계산
			int totalPages = (int) Math.ceil((double) totalStudents / limit);

			List<Student> allStudentList = studentRepository.selectStudentList(studentListForm, limit, offset);

			request.setAttribute("allStudentList", allStudentList);
			request.setAttribute("totalStudents", totalStudents);
			request.setAttribute("totalPages", totalPages);

			request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 교직원 -> 교수 명단 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showProfessorListPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ProfessorService professorService;
		professorService = new ProfessorService();
		String deptId = null;
		try {
			professorListForm.setPage(0);

			deptId = request.getParameter("dept_id");
			String proId = request.getParameter("pro_id");
			System.out.println("getparameter deptId : " + request.getParameter("dept_id"));
			
			
			if (request.getParameter("dept_id") != null) {
				professorListForm.setDeptId(Integer.parseInt(deptId));
			} 
			else if (proId != null) {
				professorListForm.setProfessorId(Integer.parseInt(proId));
			}

			Integer amount = professorService.readProfessorAmount(professorListForm);
			if (proId != null) {
				amount = 1;
			}

			System.out.println("userController에서 amount" + amount);

			List<Professor> list = professorService.readProfessorList(professorListForm);

			System.out.println("userController에서 교수list : " + list);

			request.setAttribute("professorList", list);
			request.setAttribute("listCount", Math.ceil(amount / 20.0));
			request.setAttribute("pro_deptId", deptId);
			request.setAttribute("page", 1);
			request.getRequestDispatcher("/WEB-INF/views/user/professorList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 교직원 -> 학생 등록하기
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showStudentCreatePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/user/createStudent.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 교직원 -> 교수 등록하기
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showProfessorCreatePage(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/user/createProfessor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 로그인 화면 처리
	 */
	private void showSignIn(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			if (request.getParameter("logout") != null) {
				session.setAttribute("principal", null);
				session.setAttribute("user", null);
			}
			request.getRequestDispatcher("/WEB-INF/views/sign/signin.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		System.out.println("액션 : " + action);
		switch (action) {
		case "/signin":
			signInHandler(request, response, session);
			break;
		case "/student":
			CreateStudentHandler(request, response, session);
			break;
		case "/professor":
			CreateProfessorHandler(request, response, session);
			break;

		default:
			break;
		}
	}

	/**
	 * 교직원 -> 학생 추가
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void CreateStudentHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		try {
			String name = request.getParameter("name");
			String birth = request.getParameter("birth");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String deptId = request.getParameter("deptId");
			String entranceDate = request.getParameter("entranceDate");

			CreateStudentDto createStudentDto = new CreateStudentDto();

			createStudentDto.setName(name);
			createStudentDto.setBirthDate(Date.valueOf(birth));
			createStudentDto.setGender(gender);
			createStudentDto.setAddress(address);
			createStudentDto.setTel(tel);
			createStudentDto.setEmail(email);
			createStudentDto.setDeptId(Integer.parseInt(deptId));
			createStudentDto.setEntranceDate(Date.valueOf(entranceDate));

			int rowCount = studentRepository.insertToStudent(createStudentDto);

			if (rowCount == 1) {
				request.setAttribute("createStudentDto", createStudentDto);
				request.getRequestDispatcher("/WEB-INF/views/user/createStudent.jsp").forward(request, response);
//				response.sendRedirect(request.getContextPath() + "/user/student");
			} else {
				response.sendRedirect(request.getContextPath() + "/user/student");
//				request.getRequestDispatcher("/WEB-INF/views/user/createStudent.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 교직원 -> 교수 추가
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	private void CreateProfessorHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			String name = request.getParameter("name");
			String birth = request.getParameter("birth");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String email = request.getParameter("email");
			String deptId = request.getParameter("deptId");

			CreateProfessorDto createProfessorDto = new CreateProfessorDto();
			createProfessorDto.setName(name);
			createProfessorDto.setBirthDate(Date.valueOf(birth));
			createProfessorDto.setGender(gender);
			createProfessorDto.setAddress(address);
			createProfessorDto.setTel(tel);
			createProfessorDto.setEmail(email);
			createProfessorDto.setDeptId(Integer.parseInt(deptId));

			int rowCount = professorRepository.insertToProfessor(createProfessorDto);

			if (rowCount == 1) {
				request.setAttribute("createProfessorDto", createProfessorDto);
				request.getRequestDispatcher("/WEB-INF/views/user/createProfessor.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/user/professor");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 로그인 기능 처리
	 */
	private void signInHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		String save = request.getParameter("save-login");
		Cookie cookie = null;
		User user = userRepository.selectById_Password(id, password);
		if (user != null) {
			if (save != null) {
				cookie = new Cookie("id", String.valueOf(id));
				cookie.setMaxAge(60 * 60 * 24);
				response.addCookie(cookie);
			} else {
				cookie = new Cookie("id", String.valueOf(id));
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			if (user.getUserRole().equals("student")) {
				StudentInfoDto student = userRepository.studentById(id);
				session.setAttribute("principal", student);
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath());
				System.out.println("학생으로 로그인");
			} else if (user.getUserRole().equals("professor")) {
				ProfessorInfoDto professor = userRepository.professorById(id);
				session.setAttribute("principal", professor);
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath());
				System.out.println("교수로 로그인");
			} else {
				Staff staff = userRepository.staffById(id);
				session.setAttribute("principal", staff);
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath());
				System.out.println("교직원으로 로그인");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/user/signin?pass=false");
		}
	}

}
