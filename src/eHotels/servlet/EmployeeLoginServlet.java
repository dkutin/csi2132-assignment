package eHotels.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotels.connections.PostgreSQLConn;
import eHotels.entities.Employee;

public class EmployeeLoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		employee account = new employee();
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		
		PostgreSQLConn con = new PostgreSQLConn();
		String pwdfromdb = con.getPassByUsername(username);
		
		
		if (pwd.equals(pwdfromdb)) {			
				System.out.println("success");
				req.setAttribute("employee_id", username);
				resp.sendRedirect("login_success.jsp?employee_id="+username);
				return;			
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}