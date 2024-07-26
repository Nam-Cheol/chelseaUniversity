package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.chelseaUniversity.ver1.model.College;
import com.chelseaUniversity.ver1.model.Department;
import com.chelseaUniversity.ver1.model.Room;
import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.Subject;
import com.chelseaUniversity.ver1.model.Tuition;
import com.chelseaUniversity.ver1.model.dto.ScheduleFormDto;
import com.chelseaUniversity.ver1.repository.CollegeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.DepartmentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.RoomRepositoryImpl;
import com.chelseaUniversity.ver1.repository.ScheuleRepositoryImpl;
import com.chelseaUniversity.ver1.repository.SubjectRepositoryImpl;
import com.chelseaUniversity.ver1.repository.TuitionRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.CollegeRepository;
import com.chelseaUniversity.ver1.repository.interfaces.DepartmentRepository;
import com.chelseaUniversity.ver1.repository.interfaces.RoomRepository;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;
import com.chelseaUniversity.ver1.repository.interfaces.SubjectRepository;
import com.chelseaUniversity.ver1.repository.interfaces.TuitionRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CollegeRepository collegeRepository;
	TuitionRepository tuitionRepository;
	SubjectRepository subjectRepository;
	RoomRepository roomRepository;
	DepartmentRepository departmentRepository;
    SubjectRepository subRepository;
    ScheuleRepository scheuleRepository; 
    
    
    public AdminController() {
    }
	@Override
	public void init() throws ServletException {
		collegeRepository = new CollegeRepositoryImpl();
		tuitionRepository = new TuitionRepositoryImpl();
		subjectRepository = new SubjectRepositoryImpl();
		roomRepository = new RoomRepositoryImpl();
		departmentRepository = new DepartmentRepositoryImpl();
		subjectRepository = new SubjectRepositoryImpl();
		scheuleRepository = new ScheuleRepositoryImpl();
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		HttpSession session = request.getSession();
		

		switch (action) {
		case "/college":
			showCollegePage(request, response, session);
			break;
		case "/department":
			showDepartment(request, response, session);
			break;
		case "/room":
			showRoom(request, response, session);
			break;
		case "/subject":
			showSubjectPage(request, response, session);
			break;
		case "/tuition":
			showTuitionPage(request, response, session);
			break;
		case "/schedule":
			showSchedulePage(request, response, session);
			break;
			
		default:
			break;
		}
		
		
	}

	private void showSchedulePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Schedule> scheduleList = scheuleRepository.selectAll();
		session.setAttribute("scheduleList", scheduleList);
		handleListSchedule(request, response);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationSchedule.jsp").forward(request, response);
	}
	private void showDepartment(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Department> departmentList = departmentRepository.selectAll();
		session.setAttribute("departmentList", departmentList);
		handleListDepartment(request, response);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationDepartment.jsp").forward(request, response);
	}
	
	private void showRoom(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Room> roomList = roomRepository.selectRoom();
		session.setAttribute("roomList", roomList);
		handleListRoom(request, response);
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationRoom.jsp").forward(request, response);
	}
	
	private void showSubjectPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Subject> subjectList = subjectRepository.selectSubject();
		session.setAttribute("subjectList", subjectList);
		handleListSubject(request, response);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationSubject.jsp").forward(request, response);
	}
	
	private void showTuitionPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		List<Tuition> tuitionList = tuitionRepository.selectAmount();
		session.setAttribute("tuitionList", tuitionList);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationTuition.jsp").forward(request, response);
	}
	
	private void showCollegePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		List<College> collegeList = collegeRepository.selectCollegeDto();
		session.setAttribute("collegeList", collegeList);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationCollege.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/create-college":	
			createCollege(request, response);
			break;
		case "/edit-college":	
			editCollege(request, response);
			break;
		case "/tuition/edit-tuition":	
			editTuition(request, response);
			break;
		case "/tuition/create-tuition-name":
			createTuitionName(request, response);
			break;
		case "/tuition/create-tuition-amount":
			createTuitionAmount(request, response);
			break;
		case "/subject/create-subject":
			createSubject(request, response);
			break;
		case "/room/create-room":
			createRoom(request, response);
			break;
		case "/room/edit-room":
			editRoom(request, response);
			break;
		case "/department/create-department":
			createDepartment(request, response);
			break;
		case "/department/edit-department":
			editDepartment(request, response);
			break;
		case "/schedule/create-schedule":
			try {
				createSchedule(request, response);
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "/schedule/edit-schedule":
			editSchedule(request, response);
			break;
		default:
			break;
		}
	}
	
	private void editSchedule(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String scheduleIdStr = request.getParameter("schedule-id");
		String staffIdStr = request.getParameter("staff-id");
		String startDate = request.getParameter("start-date");
		String endDate = request.getParameter("end-date");
		String information = request.getParameter("schedule-information");
		
		try {
			int scheduleId = Integer.parseInt(scheduleIdStr);
			int staffId = Integer.parseInt(staffIdStr);
			
			ScheduleFormDto dto = ScheduleFormDto.builder()
								.id(scheduleId)
								.staffId(staffId)
								.startDay(startDate)
								.endDay(endDate)
								.information(information)
								.build();
			
			scheuleRepository.updateSchoeduleFormDtoBycontent(dto);
			response.sendRedirect(request.getContextPath() + "/admin/schedule");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	private void editRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roomId = request.getParameter("room-id");
		int collegeId = Integer.parseInt(request.getParameter("college-id"));
		roomRepository.updateRoom(roomId, collegeId);
		
		response.sendRedirect(request.getContextPath() + "/admin/room");
	}
	
	private void editDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int departmentId = Integer.parseInt(request.getParameter("department-id"));
		String departmentaName = request.getParameter("department-name");
		int collegeId = Integer.parseInt(request.getParameter("college-id"));
		departmentRepository.updateDepartment(departmentId, departmentaName, collegeId);
		
		response.sendRedirect(request.getContextPath() + "/admin/department");
	}
	
	
	private void editTuition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int collegeId = Integer.parseInt(request.getParameter("tuition-id"));
		int collegeAmount = Integer.parseInt(request.getParameter("college-tuition-amount"));
		tuitionRepository.updateByIdAndAmount(collegeId, collegeAmount);
		
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
	}
	
	private void createSchedule(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
		int staffId = Integer.parseInt(request.getParameter("staff-id"));
		String startDate = request.getParameter("start-date");
		String endDate = request.getParameter("end-date");
		String information = request.getParameter("schedule-information");
		scheuleRepository.insert(staffId, startDate, endDate, information);
		
		response.sendRedirect(request.getContextPath() + "/admin/schedule");
	}
	
	private void createDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String departmentName = request.getParameter("college-name");
		int collegeId = Integer.parseInt(request.getParameter("college-id"));
		departmentRepository.insert(departmentName, collegeId);
		
		
		response.sendRedirect(request.getContextPath() + "/admin/department");
	}
	
	private void createRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roomId = request.getParameter("room-id");
		int collegeId = Integer.parseInt(request.getParameter("college-id"));
		roomRepository.insertRoom(roomId, collegeId);
		response.sendRedirect(request.getContextPath() + "/admin/room");
	}
	private void createSubject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String subjectName = request.getParameter("subject-name");
		int professorId = Integer.parseInt(request.getParameter("professor-id")); 
		String roomId = request.getParameter("romm-id");
		int deptId = Integer.parseInt(request.getParameter("dept-id")); 
		String type = request.getParameter("type");
		int subYear = Integer.parseInt(request.getParameter("subject-year")); 
		int semester = Integer.parseInt(request.getParameter("semester")); 
		String subDay = request.getParameter("subject-day");
		int startTime = Integer.parseInt(request.getParameter("start-time")); 
		int endTime = Integer.parseInt(request.getParameter("end-time")); 
		int grades = Integer.parseInt(request.getParameter("grades")); 
		int capacity = Integer.parseInt(request.getParameter("capacity")); 
		int numOfStudent = Integer.parseInt(request.getParameter("number-of-student"));
		
		subjectRepository.insert(subjectName, professorId, roomId, deptId, type, subYear, semester, subDay, startTime, endTime, grades, capacity, numOfStudent);
		System.out.println("sdss");
		response.sendRedirect(request.getContextPath() + "/admin/subject");
	}
	
	private void createTuitionAmount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int collegeId = Integer.parseInt(request.getParameter("college-id")); 
		int collegeAmount = Integer.parseInt(request.getParameter("college-tuition-amount")); 
		tuitionRepository.insertAmount(collegeId, collegeAmount);
		
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
		
	}
	private void createTuitionName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String collegeName = request.getParameter("college-name");
		collegeRepository.insert(collegeName);
		
		response.sendRedirect(request.getContextPath() + "/admin/tuition");
	}
	
	

	private void editCollege(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String collegeName = request.getParameter("college-name");
		int collegeId = Integer.parseInt(request.getParameter("college-id")); 
		collegeRepository.updateByNameAndId(collegeName, collegeId);
		
		response.sendRedirect(request.getContextPath() + "/admin/college");
	}
	
	private void createCollege(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String collegeName = request.getParameter("college-name");
		collegeRepository.insert(collegeName);
		
		response.sendRedirect(request.getContextPath() + "/admin/college");
	}
	
	private void handleListDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1; // 기본 페이지 번호 
		int pageSize = 10; // 한 페이지당 보여질 게시글에 수  
		
		try {
			 String pageStr = request.getParameter("page");
			 if(pageStr != null ) {
				 page = Integer.parseInt(pageStr);
			 }
		} catch (Exception e) {
			page = 1; 
		}
		
		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
 		List<Department> departmentList =  departmentRepository.getAllDepartment(pageSize, offset);
		
		// 전체 게시글 수 조회 
		int totalBoards = departmentRepository.getTotalDepartmentCount();
		// 총 페이지 수 계산 -->  [1][2][3][...]
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		// 중복이라 주석처리 
		// request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationDepartment.jsp").forward(request, response);
	}
	
	private void handleListRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1; // 기본 페이지 번호 
		int pageSize = 10; // 한 페이지당 보여질 게시글에 수  
		
		try {
			 String pageStr = request.getParameter("page");
			 if(pageStr != null ) {
				 page = Integer.parseInt(pageStr);
			 }
		} catch (Exception e) {
			page = 1; 
		}
		
		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
 		List<Room> roomList =  roomRepository.getAllRoom(pageSize, offset);
		
		// 전체 게시글 수 조회 
		int totalBoards = roomRepository.getTotalRoomCount();
		// 총 페이지 수 계산 -->  [1][2][3][...]
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		request.setAttribute("roomList", roomList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		// 중복이라 주석처리 
		// request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationDepartment.jsp").forward(request, response);
	}
	
	private void handleListSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1; // 기본 페이지 번호 
		int pageSize = 10; // 한 페이지당 보여질 게시글에 수  
		
		try {
			 String pageStr = request.getParameter("page");
			 if(pageStr != null ) {
				 page = Integer.parseInt(pageStr);
			 }
		} catch (Exception e) {
			page = 1; 
		}
		
		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
 		List<Subject> subjectList =  subjectRepository.getAllSubject(pageSize, offset);
		
		// 전체 게시글 수 조회 
		int totalBoards = subjectRepository.getTotalSubjectCount();
		// 총 페이지 수 계산 -->  [1][2][3][...]
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		// 중복이라 주석처리 
		// request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationDepartment.jsp").forward(request, response);
	}
	
	private void handleListSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1; // 기본 페이지 번호 
		int pageSize = 10; // 한 페이지당 보여질 게시글에 수  
		
		try {
			 String pageStr = request.getParameter("page");
			 if(pageStr != null ) {
				 page = Integer.parseInt(pageStr);
			 }
		} catch (Exception e) {
			page = 1; 
		}
		
		int offset = (page - 1) * pageSize; // 시작 위치 계산( offset 값 계산)
 		List<Schedule> scheduleList =  scheuleRepository.getAllSchedule(pageSize, offset);
		
		// 전체 게시글 수 조회 
		int totalBoards = scheuleRepository.getTotalScheduleCount();
		// 총 페이지 수 계산 -->  [1][2][3][...]
		int totalPages = (int) Math.ceil((double)totalBoards / pageSize);
		
		request.setAttribute("scheduleList", scheduleList);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		
		// 중복 임시
		//request.getRequestDispatcher("/WEB-INF/views/admin/adminRegistrationSchedule.jsp").forward(request, response);
	}

	


}
