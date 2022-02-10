package kr.co.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class DBTest {

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3307/project5?serverTimezone=UTC";
	private final static String USER = "root";
	private final static String PW = "1234";
	String sql;
	
	ResultSet rs = null;
	Connection conn = null; 
	PreparedStatement pstmt = null;
	
	
	
	@Test
	public void testConnection() throws Exception {
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PW);
			sql = "select * from mem";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			System.out.println("DB가 제대로 연결되었습니다.");
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			System.out.println("DB 연결이 실패되었습니다.");
			e.printStackTrace();
		}
	}

}
