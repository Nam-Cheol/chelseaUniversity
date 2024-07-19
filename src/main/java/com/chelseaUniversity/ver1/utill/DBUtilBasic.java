package com.chelseaUniversity.ver1.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilBasic {
	
	private static final String DB_URL = "jdbc:mysql://192.168.0.145:3306/university?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "university";
	private static final String DB_PASSWORD = "1234";
	
	static {
		try {
			Class.forName("com.mysql.cj.Driver");
		} catch (Exception e) {
			System.out.println("DB 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
}
