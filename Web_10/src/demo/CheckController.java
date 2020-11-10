package demo;

import java.io.IOException;
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
		
		Database db = new Database();
		DTOStudent dto = db.findNumber(number);
		if(db.findNumber(number) != null) {
			if(db.findGrade(number).equals(number)) {
				
			}
		}
		
	}

}
