package eHotels.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotels.connections.PostgreSQLConn;
import eHotels.entities.Room;
import eHotels.entities.Employee;

public class RoombookServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String custName = req.getParameter("custName");
		String roomno = req.getParameter("roomno");
		
		
		PostgreSQLConn con = new PostgreSQLConn();
		
		String userSSN = con.bookRoom(custName,roomno);
		
		//[0]:SSN,[1]:pwd, [2]:name
		String[] pwdfromdb = con.getUserInfoSSN(userSSN);
	
		if (userSSN.length()==8) {			
			
			ArrayList<Room> bookedRooms = con.getBookedRooms(userSSN);
			
			ArrayList<Room> allRooms = con.getAllAvailRooms();
			
			
			req.setAttribute("CustName", custName);
			req.setAttribute("bookedRooms", bookedRooms);
			req.setAttribute("allRooms", allRooms);

			req.getRequestDispatcher("booking.jsp").forward(req, resp);
			return;	
		}
		resp.sendRedirect("login_failure.jsp");
		return;
	}
}