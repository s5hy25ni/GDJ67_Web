package com.min.edu.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBase {

	public DataBase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1단계 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.8.132:1521:XE";
		String user = "sqld";
		String pw = "sqld";
		
		conn = DriverManager.getConnection(url, user, pw);
		
		return conn;
	}
	
	public void closed(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			System.out.println("6단계 닫기 성공");
		} catch (SQLException e) {
			System.out.println("6단계 닫기 실패");
			e.printStackTrace();
		}
	}
}
