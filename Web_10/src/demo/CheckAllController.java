package demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckAllController")
public class CheckAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckAllController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database();
		String nextPage = null;
		ArrayList<DTOStudent> list = db.findGradeAll();	// 학생 정보가 담긴 리스트를 받아서 DTOStudent클래스 형태로 변환
		
		
		for (int i = 0; i < list.size(); i++) {	// for문 돌면서 리스트에 담긴 값을 Attribute로 넘김
			request.setAttribute("list", list);
		}
		
		nextPage = "checkAll.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(nextPage);
		disp.forward(request, response);
	}

}
