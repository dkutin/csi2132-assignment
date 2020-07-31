<%@page import="java.util.ArrayList"%>
<%@page import="eHotels.entities.Room"%>
<%@page import="eHotels.connections.PostgreSQLConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Bookings</title>
</head>
<body>

	<%
		String CustName = (String) request.getAttribute("CustName");
	%>
	<form method="post" action="roombook">
		<h4>
			Welcome,
			<%=CustName%></h4>
				<h4>Here are the room(s) you booked</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							for (Room room : broomList) {
								String roominfo = room.getRoomNo() + " at " + room.getHotelName() + " From: " + room.getStartDate() + " - " + room.getEndDate() + " For: "+ room.getPrice();
					%>
					<li><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
				<input type="hidden" name="custName" value="<%=CustName%>" />
				<h4>Rooms Available</h4>

				<select name = "roomno">
					<%
						PostgreSQLConn conn = new PostgreSQLConn();
						ArrayList<Room> roomList = conn.getAllAvailRooms();
						if (roomList != null) {
							for (Room room : roomList) {
								String roominfo = room.getRoomNo() + "---" + room.getRoomStatus();
					%>					
						<li><%=roominfo %></li>
					<%
						}
						}
					%>
				</select>
				<button type="submit" onclick="return confirm('book?');">book</button>
	</form>


</body>
</html>