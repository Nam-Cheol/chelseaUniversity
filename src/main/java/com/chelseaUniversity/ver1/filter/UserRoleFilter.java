package com.chelseaUniversity.ver1.filter;

import java.io.IOException;

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
       

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ServletRequest를 HttpServletRequest로 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // HttpSession을 얻기 위해 getSession() 호출
        HttpSession session = httpRequest.getSession();
        	String action = httpRequest.getPathInfo();
        	if(action != null) {
        		if(action.equals("/user/signin") || action.equals("/user/signup")) {
            		chain.doFilter(httpRequest, httpResponse);
            	}
        	}
        if(session.getAttribute("principal") == null) {
        	httpRequest.getRequestDispatcher("/user/signin").forward(httpRequest, httpResponse);
        }
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
