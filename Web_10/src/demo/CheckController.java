package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckController")
public class CheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));
		String nextPage = null;

		Database db = new Database();
		DTOStudent student = db.findGrade(number);
		
		request.setAttribute("no", student.getNumber());
		request.setAttribute("name", student.getName());
		request.setAttribute("kor", student.getKor());
		request.setAttribute("mat", student.getMat());
		request.setAttribute("eng", student.getEng());
		nextPage = "check.jsp";
		
		RequestDispatcher disp = request.getRequestDispatcher(nextPage);
		disp.forward(request, response);
	}

}
