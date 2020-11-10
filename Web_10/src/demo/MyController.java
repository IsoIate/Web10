package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyController() {
        super();
        System.out.println("111");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		String nextPage = null;
		
		Database db = new Database();
		DTOStudent dto = db.findNumber(number);
		db.inputGrade(number, name, kor, mat, eng);
		System.out.println("?");
		if(Integer.toString(dto.getNumber()) != null) {
			if(Integer.toString(dto.getNumber()).equals(number)) {
				System.out.println("번호 확인");
				
				
			}
		}
		else {
			nextPage = "check.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(nextPage);
		disp.forward(request, response);
	}
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	*/
}
