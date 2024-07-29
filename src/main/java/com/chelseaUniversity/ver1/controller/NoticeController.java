package com.chelseaUniversity.ver1.controller;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.Notice;
import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.model.User;
import com.chelseaUniversity.ver1.model.dto.NoticePageFormDto;
import com.chelseaUniversity.ver1.repository.NoticeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.NoticeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		switch (action) {
		case "/list":
			showListPage(request,response);
			break;
		case "/detail":
			showDetailPage(request,response);
			break;
		case "/searchList":
			showSearchListPage(request,response);
			break;
		case "/createNotice":
			request.getRequestDispatcher("/WEB-INF/views/board/createNotice.jsp").forward(request, response);
			break;
		case "/updateNotice":
			String updateIdStr = request.getParameter("id");
			if(updateIdStr != null || updateIdStr.trim().isEmpty()) {
				try {
					int id = Integer.parseInt(updateIdStr);
					Notice notice = noticeRepository.selectById(id);
					request.setAttribute("notice", notice);
					request.getRequestDispatcher("/WEB-INF/views/board/updateNotice.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					response.sendRedirect(request.getContextPath() + "/notice/list?page=0");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/notice/list?page=0");
			}
			break;
		case "/deleteNotice":
			String deleteId = request.getParameter("id");
			noticeRepository.deleteNotice(deleteId);
			response.sendRedirect(request.getContextPath() + "/notice/list?page=0");
			break;
		default:
			break;
		}
		
	}
	

	/*
	 * 검색창 리스트 페이지 처리
	 */
	private void showSearchListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String order = request.getParameter("order");
		int pageSize = 10;
		int now = Integer.parseInt(request.getParameter("page"));
		int offset = now * pageSize;
			if(type != null && order != null) {
				NoticePageFormDto notice = NoticePageFormDto.builder().keyword(order).build();
				if(type.equals("title")) {
					int count = noticeRepository.selectNoticeCountByTitle(notice);
					int page = count / pageSize;
					List<Notice>noticeList = noticeRepository.selectNoticeByTitle(notice,pageSize,offset);
					request.setAttribute("now", now);
					request.setAttribute("page", page);
					request.setAttribute("noticeList", noticeList);
					request.setAttribute("order", order);
					request.setAttribute("type", type);
					request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp?search=true").forward(request, response);
				} else{
					int count = noticeRepository.selectNoticeCountByKeyword(notice);
					int page = count / pageSize;
					List<Notice>noticeList = noticeRepository.selectNoticeByKeyword(notice,pageSize,offset);
					request.setAttribute("now", now);
					request.setAttribute("page", page);
					request.setAttribute("noticeList", noticeList);
					request.setAttribute("order", order);
					request.setAttribute("type", type);
					request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp?search=true").forward(request, response);
				}
			} else {
				int count = noticeRepository.selectNoticeCount();
				int page = count / pageSize;
				List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy(pageSize,offset);
				request.setAttribute("now", now);
				request.setAttribute("page", page);
				request.setAttribute("noticeList", noticeList);
				request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp").forward(request, response);
			}
	}

	/*
	 * 공지사항 디테일 페이지 처리
	 */
	private void showDetailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("page"));
		System.out.println(id);
		Notice notice = noticeRepository.selectById(id);
		String ipAddress=request.getRemoteAddr();
		noticeRepository.updateViews(id);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/board/noticeDetail.jsp").forward(request, response);
	}

	/*
	 * 공지사항 리스트 페이지 처리
	 */
	private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = noticeRepository.selectNoticeCount();
		int pageSize = 10;
		int page = count / pageSize;
		int now = Integer.parseInt(request.getParameter("page"));
		int offset = now * pageSize;
		List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy(pageSize,offset);
		request.setAttribute("now", now);
		request.setAttribute("page", page);
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String action = request.getPathInfo();
			
			HttpSession session = request.getSession();
			
			switch (action) {
			case "/search":
				searchNotice(request,response);
				break;
			case "/createNotice":
				createNotice(request, response, session);
				break;
				
			case "/updateNotice":
				String category = request.getParameter("category");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String updateId = request.getParameter("id");
				System.out.println("category : " + category);
				System.out.println("title : " + title);
				System.out.println("content : " + content);
				System.out.println("updateId : " + updateId);
				
				noticeRepository.updateNotice(category, title, content, updateId);
				response.sendRedirect(request.getContextPath() + "/notice/detail?page=" + updateId);
				break;
			
			default:
				break;
			}
	}
			
	/*
	 * 검색 처리 기능
	 */
	private void searchNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String type = request.getParameter("type");
			String order = request.getParameter("order");
			int pageSize = 10;
			int now = Integer.parseInt(request.getParameter("page"));
			int offset = now * pageSize;
				if(type != null && order != null) {
					NoticePageFormDto notice = NoticePageFormDto.builder().keyword(order).build();
					if(type.equals("title")) {
						int count = noticeRepository.selectNoticeCountByTitle(notice);
						int page = count / pageSize;
						List<Notice>noticeList = noticeRepository.selectNoticeByTitle(notice,pageSize,offset);
						request.setAttribute("now", now);
						request.setAttribute("page", page);
						request.setAttribute("noticeList", noticeList);
						request.setAttribute("order", order);
						request.setAttribute("type", type);
						request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp?search=true").forward(request, response);
					} else{
						int count = noticeRepository.selectNoticeCountByKeyword(notice);
						int page = count / pageSize;
						List<Notice>noticeList = noticeRepository.selectNoticeByKeyword(notice,pageSize,offset);
						request.setAttribute("now", now);
						request.setAttribute("page", page);
						request.setAttribute("noticeList", noticeList);
						request.setAttribute("order", order);
						request.setAttribute("type", type);
						request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp?search=true").forward(request, response);
					}
				} else {
					int count = noticeRepository.selectNoticeCount();
					int page = count / pageSize;
					List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy(pageSize,offset);
					request.setAttribute("now", now);
					request.setAttribute("page", page);
					request.setAttribute("noticeList", noticeList);
					request.getRequestDispatcher("/WEB-INF/views/board/notice.jsp").forward(request, response);
				}
			} 
	private void createNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		System.out.println("여기 들어옴");
		Staff principal = (Staff) session.getAttribute("principal");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		noticeRepository.insertCreateNotice(category, title, content);
		System.out.println("실행됨");
		response.sendRedirect(request.getContextPath() + "/notice/list?page=0");
	}
	
}
