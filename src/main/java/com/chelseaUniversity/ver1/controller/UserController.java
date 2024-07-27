package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.chelseaUniversity.ver1.model.Notice;
import com.chelseaUniversity.ver1.model.Professor;
import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.StuStat;
import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.ChangePasswordDto;
import com.chelseaUniversity.ver1.model.dto.CreateProfessorDto;
import com.chelseaUniversity.ver1.model.dto.CreateStudentDto;
import com.chelseaUniversity.ver1.model.dto.ProfessorListForm;
import com.chelseaUniversity.ver1.model.dto.StudentListForm;
import com.chelseaUniversity.ver1.model.dto.response.ProfessorInfoDto;
import com.chelseaUniversity.ver1.model.dto.response.StudentInfoDto;
import com.chelseaUniversity.ver1.repository.NoticeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.ProfessorRepositoryImpl;
import com.chelseaUniversity.ver1.repository.ScheuleRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StuStatRepositoryImpl;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.UserRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.NoticeRepository;
import com.chelseaUniversity.ver1.repository.interfaces.ProfessorRepository;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;
import com.chelseaUniversity.ver1.repository.interfaces.StuStatRepository;
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
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentRepository studentRepository;
	private ProfessorRepository professorRepository;
	private StudentListForm studentListForm;
	private ProfessorListForm professorListForm;
	private UserRepository userRepository;
	private NoticeRepository noticeRepository;
	private ScheuleRepository scheuleRepository;
	private StuStatRepository stuStatRepository;

	@Override
	public void init() throws ServletException {
		studentRepository = new StudentRepositoryImpl();
		professorRepository = new ProfessorRepositoryImpl();
		studentListForm = new StudentListForm();
		professorListForm = new ProfessorListForm();
		userRepository = new UserRepositoryImpl();
		noticeRepository = new NoticeRepositoryImpl();
		scheuleRepository = new ScheuleRepositoryImpl();
		stuStatRepository = new StuStatRepositoryImpl();
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
			showStudentListPage(request, response, session, "/studentList");
			break;
		case "/professorList":
			showProfessorListPage(request, response, session);
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
		case "/password":
			password(request, response, session);
			break;
		case "/home":
			showHomePage(request, response, session);
			break;
		case"/check":
			showCheckPage(request,response,session);
			break;
		case"/myinfo":
			showMyinfoPage(request,response,session);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	/*
	 * 인포 페이지 처리
	 */
	private void showMyinfoPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/myInfo.jsp").forward(request, response);
	}

	/*
	 * 유저 체크
	 */
	private void showCheckPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/checkUser.jsp").forward(request, response);
	}

	// 홈페이지 페이지 처리
	private void showHomePage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		if (user != null) {
			if (user.getUserRole().equals("student")) {
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
				List<Schedule> scheduleList = scheuleRepository.selectSchodule();
				StuStat stuStat = stuStatRepository.selectStatusByStudentId(id);
				request.setAttribute("notice", noticeList);
				request.setAttribute("schedule", scheduleList);
				request.setAttribute("status", stuStat);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else if (user.getUserRole().equals("professor")) {
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
				List<Schedule> scheduleList = scheuleRepository.selectSchodule();
				request.setAttribute("notice", noticeList);
				request.setAttribute("schedule", scheduleList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
				List<Schedule> scheduleList = scheuleRepository.selectSchodule();
				request.setAttribute("notice", noticeList);
				request.setAttribute("schedule", scheduleList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/user/signin?pass=false");
		}
	}

	// 비밀번호 변경 페이지 처리
	private void password(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/changePassword.jsp").forward(request, response);
	}

	private void showProfessorListByPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {

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

			response.sendRedirect(request.getContextPath() + "/user/professorList");
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
		System.out.println("get으로 발동");
		request.getRequestDispatcher("/WEB-INF/views/find/findId.jsp").forward(request, response);
	}

	/**
	 * 교직원 -> 학생 명단 조회
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showStudentListPage(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String action) throws ServletException, IOException {
	        // 페이징 처리를 위한 변수 선언
	        int page = 1; // 기본 페이지 번호
	        int pageSize = 20; // 한 페이지당 보여질 게시글 수

	        try {
	            String pageStr = request.getParameter("page");
	            if (pageStr != null) {
	                page = Integer.parseInt(pageStr);
	            }
	        } catch (Exception e) {
	            // 유효하지 않은 번호를 마음대로 보낼 경우
	            page = 1;
	        }
	        int offset = (page - 1) * pageSize; // 시작 위치 계산 (offset 값 계산)

	        String deptId = request.getParameter("deptId");
	        String studentId = request.getParameter("studentId");
	        List<Student> studentList = null;
	        
	        int totalStudents = 0;
	        if (deptId == null && studentId == null) {
//	            studentList = managementRepository.getAllStudents(pageSize, offset);
	        	studentList = studentRepository.selectStudentList(studentListForm, pageSize, offset);
	            // 전체 학생 수 조회
	            totalStudents = studentRepository.selectStudentAmount();
	        } else {
	        	studentList = studentRepository.selectStudentList(studentListForm, pageSize, offset);
//	            studentList = managementRepository.getAllStudents(studentId, deptId, pageSize, offset);
//	            totalStudents = managementRepository.getTotalStudentCount(studentId, deptId);
	        }

	        // 총 페이지 수 계산
	        int totalPages = (int) Math.ceil((double) totalStudents / pageSize);

	        request.setAttribute("totalPages", totalPages);
	        request.setAttribute("studentList", studentList);
	        request.setAttribute("currentPage", page);

	        request.getRequestDispatcher("/WEB-INF/views/management/studentList.jsp").forward(request, response);
	    }

	}

	private void viewStudentList(HttpServletRequest request, HttpServletResponse response, int page, String limit)
			throws ServletException, IOException {
		System.out.println("viewStudentList 메소드 작동");
		
		// 전체 학생 수
		int totalStudents = studentRepository.selectStudentAmount();
		// 총 페이지 수 계산
		int totalPages = (int) Math.ceil((double) totalStudents / Integer.parseInt(limit));
		// 오프셋
		int offset = (int) Math.ceil((double) (page - 1) * Integer.parseInt(limit));
		// 리스트 출력
		List<Student> allStudentList = studentRepository.selectStudentList(studentListForm, Integer.parseInt(limit), offset);
		System.out.println("총 페이지수 : " + totalPages);
		request.setAttribute("allStudentList", allStudentList);
		request.setAttribute("totalStudents", totalStudents);
		request.setAttribute("totalPages", totalPages);
		request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
	}

	/**
	 * 학생 정보 검색 - 학과id, 학번, 몇 개씩 볼 지
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param deptId 
	 * @param limit
	 * @throws ServletException
	 */
	private void searchStudentList(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String deptId,int page, String limit) throws NumberFormatException, IOException, ServletException {
		studentListForm = new StudentListForm();
//
//		try {
//
//			if (request.getParameter("dept_id") != null) {
//
				studentListForm.setDeptId(Integer.parseInt(deptId));
				studentListForm.setPage(Integer.parseInt(limit));
				
				// 리스트 출력
				List<Student> student = studentRepository.selectByDepartmentId(studentListForm);
				// 총 페이지 수 계산
				int totalPages = (int) Math.ceil((double) student.size() / Integer.parseInt(limit));
				// 오프셋
				int offset = (int) Math.ceil((double) (page - 1) * Integer.parseInt(limit));
				
				request.setAttribute("allStudentList", student);
				request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
//
//			}
//
//			if (request.getParameter("stu_id") != null) {
//
//				studentListForm.setDeptId(Integer.parseInt(stuId));
//				studentListForm.setPage(Integer.parseInt(limit));
//
//				System.out.println("1 : " + stuId);
//				System.out.println("3" + limit);
//
//				Student student = studentRepository.selectByStudentId(Integer.parseInt(stuId));
//				request.setAttribute("oneStudent", student);
//				System.out.println("222222222" + student);
//				request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

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
			} else if (proId != null) {
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
				session.invalidate();
				session = request.getSession(true);
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
		case "/findid":
			findIdHandler(request, response);
			break;
		case "/findpassword":
			findPasswordHandler(request, response);
			break;
		case "/changepassword":
			changePasswordHandler(request, response, session);
			break;
		case"/update":
			updateHandler(request,response,session);
			break;
		case"/check":
			checkHandler(request,response,session);
		default:
			break;
		}
	}

	/*
	 * 회원 정보 유효 확인 처리
	 */
	private void checkHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		User user = (User)session.getAttribute("user");
		if(user.getId().equals(id) && user.getPassword().equals(password)) {
			System.out.println("보안검사 성공");
			request.getRequestDispatcher("/WEB-INF/views/user/checkUser.jsp?check=success").forward(request, response);
		} else {
			System.out.println("보안검사 실패");
			request.getRequestDispatcher("/WEB-INF/views/user/checkUser.jsp?check=fail").forward(request, response);
		}
	}

	/*
	 * 회원 정보 수정 처리
	 */
	private void updateHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		User user = (User)session.getAttribute("user");
		System.out.println(tel);
			if(user.getUserRole().equals("student")) {
				StudentInfoDto student = (StudentInfoDto)session.getAttribute("principal");
				student.setAddress(address);
				student.setTel(tel);
				student.setEmail(email);
				userRepository.updateStudent(student);
				session.setAttribute("principal",student);
				response.sendRedirect(request.getContextPath()+"/user/myinfo");
			} else if (user.getUserRole().equals("staff")) {
				Staff staff = (Staff)session.getAttribute("principal");
				staff.setAddress(address);
				staff.setTel(tel);
				staff.setEmail(email);
				userRepository.updateStaff(staff);
				session.setAttribute("principal",staff);
				response.sendRedirect(request.getContextPath()+"/user/myinfo");
			} else {
				ProfessorInfoDto professor = (ProfessorInfoDto)session.getAttribute("principal");
				professor.setAddress(address);
				professor.setTel(tel);
				professor.setEmail(email);
				userRepository.updateProfessor(professor);
				session.setAttribute("principal",professor);
				response.sendRedirect(request.getContextPath()+"/user/myinfo");
			}
	}

	/*
	 * 비밀번호 변경 기능
	 */
	private void changePasswordHandler(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		User user = (User) session.getAttribute("user");
		String original = request.getParameter("original");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/user/signin");
		} else if (user.getPassword().equals(original)) {
			request.getRequestDispatcher("/WEB-INF/views/user/changePassword.jsp?pass=false").forward(request,
					response);
		}
		String newPassword = request.getParameter("password");
		String password = user.getPassword();
		int id = user.getId();
		if (password.equals(newPassword)) {
			response.sendRedirect(request.getContextPath() + "/user/password?change=overlap");
		}
		ChangePasswordDto changePassword = ChangePasswordDto.builder().afterPassword(newPassword)
				.beforePassword(password).id(id).build();
		int rowCount = userRepository.updatePassword(changePassword);
		if (rowCount != 0) {
			System.out.println("비밀번호 변경 성공");
			response.sendRedirect(request.getContextPath() + "/user/password?change=true");
		} else {
			System.out.println("비밀번호 변경 실패");
			response.sendRedirect(request.getContextPath() + "/user/password?change=false");
		}
	}

	/*
	 * 비밀번호 찾기 기능
	 */
	private void findPasswordHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = userRepository.findPassword(id, name);
		if (password != null) {
			System.out.println(password + " 비밀번호 전송");
			request.getRequestDispatcher("/WEB-INF/views/find/result.jsp?result=password&password=" + password)
					.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/user/findid?password=fail");
		}
	}

	/*
	 * id 찾기 기능
	 */
	private void findIdHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int id = userRepository.findId(name, email);
		System.out.println("post로 발동");
		if (id == 0) {
			response.sendRedirect(request.getContextPath() + "/user/findid?id=fail");
		} else {
			System.out.println(id + " id 전송");
			request.getRequestDispatcher("/WEB-INF/views/find/result.jsp?result=id&id=" + id).forward(request,
					response);
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
			throws IOException, ServletException {
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
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
				List<Schedule> scheduleList = scheuleRepository.selectSchodule();
				StuStat stuStat = stuStatRepository.selectStatusByStudentId(id);
				session.setAttribute("principal", student);
				session.setAttribute("user", user);
				request.setAttribute("notice", noticeList);
				request.setAttribute("schedule", scheduleList);
				request.setAttribute("status", stuStat);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else if (user.getUserRole().equals("professor")) {
				ProfessorInfoDto professor = userRepository.professorById(id);
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
				List<Schedule> scheduleList = scheuleRepository.selectSchodule();
				String deptname = professorRepository.selectProfessorDeptById(professor.getDeptId());
				session.setAttribute("principal", professor);
				session.setAttribute("user", user);
				session.setAttribute("deptname", deptname);
				request.setAttribute("notice", noticeList);
				request.setAttribute("schedule", scheduleList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				Staff staff = userRepository.staffById(id);
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy();
				List<Schedule> scheduleList = scheuleRepository.selectSchodule();
				session.setAttribute("principal", staff);
				session.setAttribute("user", user);
				request.setAttribute("notice", noticeList);
				request.setAttribute("schedule", scheduleList);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/user/signin?pass=false");
		}
	}

}
