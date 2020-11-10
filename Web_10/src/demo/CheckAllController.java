package demo;

import java.io.IOException;

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
		int num = 1;
		Database db = new Database();
		String nextPage = null;
		while(num < 4) {
			DTOStudent student = db.findGradeAll(num);
			
			request.setAttribute("no", student.getNumber());
			request.setAttribute("name", student.getName());
			request.setAttribute("kor", student.getKor());
			request.setAttribute("mat", student.getMat());
			request.setAttribute("eng", student.getEng());
			num++;
		}
		
		nextPage = "checkAll.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(nextPage);
		disp.forward(request, response);
	}

}
