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

public class CustomerRegisterServlet extends HttpServlet{


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
		String custSSN = req.getParameter("ssn");
		String custName = req.getParameter("username");
		String custLast = req.getParameter("lastname");
		String custAddress = req.getParameter("address");
		String custPwd = req.getParameter("password");
		String custPostalCode = req.getParameter("postalcode");
		String custCity = req.getParameter("city");
		String custCountry = req.getParameter("country");
		String[] param = new String[] {custSSN,custName,custLast,custPwd,custAddress,custCity, custCountry, custPostalCode};
		
		PostgreSQLConn con = new PostgreSQLConn();
		boolean pwdfromdb = con.addNewCustomer(param);
		
		System.out.println(pwdfromdb);
		
		if (pwdfromdb) {			
				System.out.println("success");
				
				ArrayList<Room> bookedRooms = con.getBookedRooms(custSSN);
				
				ArrayList<Room> allRooms = con.getAllAvailRooms();
				
				System.out.println(allRooms);
				
				req.setAttribute("CustName", custName);
				req.setAttribute("bookedRooms", bookedRooms);
				req.setAttribute("allRooms", allRooms);
				req.getRequestDispatcher("Customer_landing.jsp").forward(req, resp);
				return;			
		}
		resp.sendRedirect("register_failure.jsp");
		return;
	}
	

}
