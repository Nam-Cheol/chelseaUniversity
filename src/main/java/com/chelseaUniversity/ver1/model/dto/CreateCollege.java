package com.chelseaUniversity.ver1.model.dto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chelseaUniversity.ver1.utill.DBUtil;

@WebServlet("/create-college")
public class CreateCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCollege() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String collegeName = request.getParameter("College-name");
		
		// TODO - MYSQL 확인 후 수정 예정
		try (Connection conn = DBUtil.getConnection()){
			String sql = " INSERT INTO college_tb(id) VALUES (?) ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, collegeName);
			pstmt.executeUpdate();
			response.sendRedirect("admintest.jsp?message=create-success");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admintest.jsp?message=error");		
			}
	}

}
