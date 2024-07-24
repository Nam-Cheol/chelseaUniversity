package com.chelseaUniversity.ver1.model.dto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chelseaUniversity.ver1.utill.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create-college")
public class CreateCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCollege() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String collegeName = request.getParameter("college-name");
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			String sql = " INSERT INTO college_tb(name) VALUES(?) ";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, collegeName);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			response.sendRedirect("admintest.jsp?message=create-success");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("admintest.jsp?message=error");		
			}
	}

}
