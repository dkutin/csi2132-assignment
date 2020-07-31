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

public class EmployeeRegisterServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
//		employee account = new employee();
		String empSSN = req.getParameter("ssn");
		String empName = req.getParameter("username");
		String empFirst = req.getParameter("firstname");
		String empLast = req.getParameter("lastname");
		String empAddress = req.getParameter("address");
		String empPass = req.getParameter("password");
		String empPostalCode = req.getParameter("postalcode");
		String empCity = req.getParameter("city");
		String empCountry = req.getParameter("country");
		String empDob = req.getParameter("dob");
		String empProvince = req.getParameter("province");
		String[] table1 = new String[] {empName, empSSN, empFirst,empLast,empDob};
		String[] table2 = new String[] {empName, empPass};
		String[] table3 = new String[] {empName, empAddress, empCity, empProvince, empCountry, empPostalCode};
		PostgreSQLConn con = new PostgreSQLConn();
		boolean pwdfromdb = con.addNewEmployee(table1, table2, table3);
		
		System.out.println(pwdfromdb);
		
		if (pwdfromdb) {			
				System.out.println("success");
//				
//				ArrayList<Room> bookedRooms = con.getBookedRooms();
//				
//				ArrayList<Room> allRooms = con.getAllAvailRooms();
//				
//				System.out.println(allRooms);
//				
//				req.setAttribute("CustName", custName);
//				req.setAttribute("bookedRooms", bookedRooms);
//				req.setAttribute("allRooms", allRooms);
////homepage.jsp for customer
//				req.getRequestDispatcher("booking.jsp").forward(req, resp);
				return;			
		}
		resp.sendRedirect("register_failure.jsp");
		return;
	}
	

}
