package com.chelseaUniversity.ver1.filter;

import java.io.IOException;
import java.util.List;

import com.chelseaUniversity.ver1.model.Notice;
import com.chelseaUniversity.ver1.model.Schedule;
import com.chelseaUniversity.ver1.model.Staff;
import com.chelseaUniversity.ver1.repository.NoticeRepositoryImpl;
import com.chelseaUniversity.ver1.repository.ScheuleRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.NoticeRepository;
import com.chelseaUniversity.ver1.repository.interfaces.ScheuleRepository;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class UserRoleFilter extends HttpFilter implements Filter {
    public NoticeRepository noticeRepository;
    public ScheuleRepository scheuleRepository; 
    
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ServletRequest를 HttpServletRequest로 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // HttpSession을 얻기 위해 getSession() 호출
        HttpSession session = httpRequest.getSession();
        String action = httpRequest.getRequestURI();
        System.out.println(action);
        if(action != null) {
        	if(action.equals(httpRequest.getContextPath()+"/user/signin") || action.equals(httpRequest.getContextPath()+"/user/signup")) {
            	chain.doFilter(httpRequest, httpResponse);
            	return;
            }
        	if (action.startsWith(httpRequest.getContextPath() + "/resources/") || action.startsWith(httpRequest.getContextPath() + "/user/find")) {
        		// 필터링을 생략하고 다음 필터 또는 서블릿으로 요청을 전달
        		chain.doFilter(request, response);
        		return;
        	}
        	if(action.startsWith(httpRequest.getContextPath() + "/grade/evaluation")) {
        		chain.doFilter(request, response);
        		return;
        	}
        } else if(action.equals("/")) {
        	httpRequest.getRequestDispatcher("/user/signin").forward(httpRequest, httpResponse);
        	chain.doFilter(httpRequest, httpResponse);
        	return;
        } else {
        	httpRequest.getRequestDispatcher("/user/signin").forward(httpRequest, httpResponse);
        	chain.doFilter(httpRequest, httpResponse);
        	return;
        }
        if(session.getAttribute("principal") == null) {
        	httpRequest.getRequestDispatcher("/user/signin").forward(httpRequest, httpResponse);
        	chain.doFilter(httpRequest, httpResponse);
        	return;
        } else {
        	int limit = 8;
			int offset = 0;
			List<Notice> noticeList = noticeRepository.selectByNoticeDtoOrderBy(limit, offset);
			List<Schedule> scheduleList = scheuleRepository.selectSchodule(limit, offset);
			request.setAttribute("notice", noticeList);
			request.setAttribute("schedule", scheduleList);
        	chain.doFilter(request, response);
        	return;
        }
	}
	public void init(FilterConfig fConfig) throws ServletException {
		noticeRepository = new NoticeRepositoryImpl();
		scheuleRepository = new ScheuleRepositoryImpl();
	}
}
