package com.chelseaUniversity.ver1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/*")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();

		switch (action) {
		case "/admin":
			request.getRequestDispatcher("/WEB-INF/views/admin/admintest.jsp").forward(request, response);
			break;
		case "/delete":
			
			break;
		case "/update":
			
			break;
		default:
			break;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
