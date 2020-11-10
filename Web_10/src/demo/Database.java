package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	Connection conn = null;
	
	public Database() {
		String url = "jdbc:mysql://localhost:3306/webprograming?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "root";
		String pw = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}
	
	public DTOStudent findNumber(int num) {
		PreparedStatement pstmt;
		DTOStudent dto = new DTOStudent();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM student WHERE number=?");
			pstmt.setInt(1,num); 
			ResultSet rs = pstmt.executeQuery();
			pstmt.close();
		} catch(SQLException e) {
			System.out.println("데이터베이스 조회 실패");
		}

		return dto;
	}
	
	public DTOStudent findGrade(int num) {
		PreparedStatement pstat;
		DTOStudent dto = new DTOStudent();
		
		try {
			pstat = conn.prepareStatement("SELECT * FROM student WHERE number=?");
			pstat.setInt(1, num);
			ResultSet rs = pstat.executeQuery();
			dto.setNumber(rs.getInt(1));
			dto.setName(rs.getNString(2));
			dto.setName(rs.getNString(3));
			dto.setName(rs.getNString(4));
			dto.setName(rs.getNString(5));
		} catch(SQLException e) {
			System.out.println("데이터베이스 조회 오류");
		}
		
		return dto;
	}
	
	public DTOStudent inputGrade(int num, String name, int kor, int mat, int eng) {
		PreparedStatement pstat;
		DTOStudent dto = new DTOStudent();
		
		try {
			pstat = conn.prepareStatement("INSERT INTO student(no, name, kor, mat, eng) VALUES(?, ?, ?, ?, ?)");
			pstat.setInt(1, num);
			pstat.setString(2, name);
			pstat.setInt(3, kor);
			pstat.setInt(4, mat);
			pstat.setInt(5, eng);
			pstat.executeUpdate();
			pstat.close();
		} catch(SQLException e) {
			System.out.println("데이터베이스 입력 오류");
		}
		
		return dto;
	}
}
