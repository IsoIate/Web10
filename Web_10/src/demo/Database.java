package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;

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
	
	// 성적 입력
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
	
	// 번호 조회
	public int findNumber(int num) {
		PreparedStatement pstmt;
		int number = 0;
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM student WHERE no=?");	// 입력받은 값과 데이터베이스에 존재하는 no 값 비교하는 질의문
			pstmt.setInt(1,num); 	// 1번째 칸(no)에 num 삽입
			ResultSet rs = pstmt.executeQuery();	// 쿼리 실행
			number = rs.getInt(1);	// number에 1번째 칸(no)의 값 대입
			pstmt.close();
		} catch(SQLException e) {
			System.out.println("입력한 번호가 존재하지 않음");
		}

		return number;
	}
	
	// 성적 조회
	public DTOStudent findGrade(int num) {
		PreparedStatement pstat;
		DTOStudent dto = new DTOStudent();
		
		try {
			pstat = conn.prepareStatement("SELECT * FROM student WHERE no=?");
			pstat.setInt(1, num);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				dto.setNumber(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setKor(rs.getInt(3));
				dto.setMat(rs.getInt(4));
				dto.setEng(rs.getInt(5));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("입력한 번호에 상응하는 데이터 미존재");
		}
		
		return dto;
	}
	
	// 전체 성적 조회
	public DTOStudent findGradeAll(int num) {
		PreparedStatement pstat;
		DTOStudent dto = new DTOStudent();
		
		try {
			pstat = conn.prepareStatement("SELECT * FROM student WHERE no=?");
			pstat.setInt(1, num);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				dto.setNumber(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setKor(rs.getInt(3));
				dto.setMat(rs.getInt(4));
				dto.setEng(rs.getInt(5));
			}
				
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("입력한 번호에 상응하는 데이터 미존재");
		}
		return dto;
	}
}
