package eHotels.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotels.connections.PostgreSQLConn;
import eHotels.entities.*;

public class CustomerLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pwd = req.getParameter("password");
		String userSSN = req.getParameter("username");

		PostgreSQLConn con = new PostgreSQLConn();
//		[0]:name,[1]:pwd
		String[] userInfo = con.getUserInfoSSN(userSSN);
		if (pwd.equals(userInfo[1])) {

			ArrayList<Room> bookedRooms = con.getBookedRooms(userSSN);

			ArrayList<Room> allRooms = con.getAllAvailRooms();

			req.setAttribute("CustName", userInfo[2]);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("Customer_landing.jsp").forward(req, resp);
			return;
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}