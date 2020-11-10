package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertController() {
        super();
        System.out.println("insertController");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		String nextPage = null;
		
		Database db = new Database();
		DTOStudent dto = db.inputGrade(number, name, kor, mat, eng);
		nextPage = "index.jsp";
		
		RequestDispatcher disp = request.getRequestDispatcher(nextPage);
		disp.forward(request, response);
		
	}

}
