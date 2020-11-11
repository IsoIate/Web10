package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public void inputGrade(int num, String name, int kor, int mat, int eng) {
		PreparedStatement pstat;
		
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
	}
	
	// 번호 조회
	public String findNumber(int num) {
		PreparedStatement pstmt;
		String number = null;
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM student WHERE no=?");	// 입력받은 값과 데이터베이스에 존재하는 no 값 비교하는 질의문
			pstmt.setInt(1,num); 	// 1번째 칸(no)에 num 삽입
			ResultSet rs = pstmt.executeQuery();	// 쿼리 실행
			number = Integer.toString(rs.getInt(1));	// number에 1번째 칸(no)의 값 대입
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
	
	
	// 성적 수정
	public void updateGrade(int num, String name, int kor, int mat, int eng) {
		PreparedStatement pstat;
		
		try {
			pstat = conn.prepareStatement("UPDATE student SET name = ?, kor = ?, mat = ?, eng = ? WHERE no = ?;");
			pstat.setString(1, name);
			pstat.setInt(2, kor);
			pstat.setInt(3, mat);
			pstat.setInt(4, eng);
			pstat.setInt(5, num);
			pstat.executeUpdate();
			pstat.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateGrade 오류");
		}
	}

	
	// 전체 성적 조회
	public ArrayList<DTOStudent> findGradeAll() {
		PreparedStatement pstat;
//		DTOStudent dto = new DTOStudent();
		ArrayList<DTOStudent> list = new ArrayList<DTOStudent>();
		
		try {
			pstat = conn.prepareStatement("SELECT * FROM student");	// 전체 학생 조회
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				int number = (rs.getInt(1));
				String name = (rs.getString(2));
				int kor = (rs.getInt(3));
				int mat = (rs.getInt(4));
				int eng = (rs.getInt(5));
				
				DTOStudent student = new DTOStudent(number, name, kor, mat, eng);	// DTOStudent 객체 생성, 생성자에 값 대입
				list.add(student);	// 리스트에 인스턴스 값 삽입
			}
			
			
				
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("입력한 번호에 상응하는 데이터 미존재");
		}
		return list;	// 학생 정보 담긴 리스트 반환
	}
}
