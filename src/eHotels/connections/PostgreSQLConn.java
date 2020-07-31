package eHotels.connections;

import java.sql.*;

import eHotels.entities.Hotel;
import eHotels.entities.Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostgreSQLConn {

	Connection db = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	String sql = null;

	public PostgreSQLConn() {

	}

	public void connect() {

		try {

			Class.forName("org.postgresql.Driver");

			db = DriverManager.getConnection("URL", "USERNAME", "PASSWORD");
		} catch (Exception e) {
			System.out.println("unable to connect");
		}
	}

	public void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (st != null) {
				st.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (Exception e) {
		}
	}

	public String getPassByUsername(String username) {
		connect();

		String password = "";

		try {
			ps = db.prepareStatement(
					"select employee_pass from e_hotel.employee where employee_user=" + "'" + username + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				password = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return password;

	}

	public String[] getUserInfoSSN(String ssn) {
		System.out.println(ssn);
		connect();

		String[] userinfo = new String[3];

		try {
			ps = db.prepareStatement("select * from e_hotel.customer where ssn='" + Integer.parseInt(ssn) + "'");

			rs = ps.executeQuery();

			while (rs.next()) {
				userinfo[0] = rs.getString(1);
				userinfo[1] = rs.getString(2);
				userinfo[2] = rs.getString(4);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println(userinfo[0] + " " + userinfo[1]);
		return userinfo;
	}

	public boolean addNewEmployee(String[] table1, String[] table2, String[] table3) {
		connect();

		try {
			st = db.createStatement();
			sql = "insert into e_hotel.employee_creds values('" + table1[0] + "','" + table1[1] + "','" + table1[2]
					+ "','" + table1[3] + "'," + "'" + table1[4] + "')";
			String insertEmployee = "insert into e_hotel.employee values('" + table2[0] + "','" + table2[1] + "')";
			String insertAddresses = "insert into e_hotel.employee_addresses values('" + table3[0] + "','" + table3[1]
					+ "','" + table3[2] + "','" + table3[3] + "'," + "'" + table3[4] + "'," + "'" + table3[5] + "')";
			System.out.print(sql + " " + insertAddresses + " " + insertEmployee);

			st.execute(insertEmployee);
			st.executeUpdate(insertAddresses);
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}

	}

	public boolean addNewCustomer(String[] cust) {
		connect();

		try {
			st = db.createStatement();
			sql = "insert into e_hotel.customer values('" + cust[0] + "','" + cust[1] + "','" + cust[2] + "','"
					+ cust[3] + "')";
			String insertAddress = "insert into e_hotel.customer_addresses values('" + cust[4] + "','" + cust[5] + "','"
					+ cust[6] + "','" + cust[7] + "','" + cust[8] + "')";
			System.out.print(sql + " " + insertAddress);

			st.executeUpdate(sql);
			st.executeUpdate(insertAddress);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
	}

	public ArrayList<Room> getAllRooms() {

		connect();

		ArrayList<Room> Rooms = new ArrayList<Room>();

		try {
			ps = db.prepareStatement("select * from e_hotel.room where room_status='available'");
			rs = ps.executeQuery();
			while (rs.next()) {
				String room_no = rs.getString("room_no");
				String room_status = rs.getString("room_status");
				// Room room = new Room(room_no, room_status);
				// Rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return Rooms;

	}

	public ArrayList<Room> getAllBookedRooms() {

		connect();

		ArrayList<Room> Rooms = new ArrayList<Room>();

		try {
			ps = db.prepareStatement("select * from e_hotel.room where room_status='booked'");
			rs = ps.executeQuery();
			while (rs.next()) {
				String room_no = rs.getString("room_no");
				String room_status = rs.getString("room_status");
				Room room = new Room(room_no, room_status);
				Rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return Rooms;
	}

	public ArrayList<Room> getBookedRooms(String custSSN) {

		connect();

		ArrayList<Room> Rooms = new ArrayList<Room>();

		try {
			st = db.createStatement();
			st.execute(
					"create view e_hotel.customer_rooms as select booking.cust_ssn, booking.booking_id, booking.start_date, booking.end_date, hotel.name, room.room_number, room.price from e_hotel.booking, e_hotel.hotel, e_hotel.room where booking.room_id = room.room_id and room.hotel_id = hotel.id and cust_ssn='"
							+ custSSN + "'");
			ps = db.prepareStatement("select * from e_hotel.customer_rooms");
			rs = ps.executeQuery();

			while (rs.next()) {
				String bookingID = rs.getString("booking_id");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String hotelName = rs.getString("name");
				String roomNo = rs.getString("room_number");
				String price = rs.getString("price");

				System.out.println(hotelName + roomNo);

				Room room = new Room(bookingID, startDate, endDate, hotelName, roomNo, price);
				Rooms.add(room);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st = db.createStatement();
				st.execute("drop view e_hotel.customer_rooms");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			disconnect();
		}
		return Rooms;

	}

	public ArrayList<Room> getAllAvailRooms() {

		connect();

		ArrayList<Room> Rooms = new ArrayList<Room>();

		try {
			ps = db.prepareStatement(
					"select * hotel_chain.chain_name, hotel.name, room.price, hotel.rating, hotel.num_of_rooms, room.capacity, hotel_address from e_hotel.room, e_hotel.hotel, e_hotel.hotel_chain where hotel_chain.id = hotel.owned_by AND room.hotel_id = hotel.id AND (NOT EXISTS (SELECT * FROM e_hotel.booking WHERE booking.room_id = room.room_id AND (booking.start_date = CURRENT_DATE OR booking.end_date = CURRENT_DATE))) ");
			rs = ps.executeQuery();
			while (rs.next()) {
				String roomPrice = rs.getString("room_price");
				String chainName = rs.getString("chain_name");
				String hotelName = rs.getString("name");
				String ratings = rs.getString("rating");
				String capacity = rs.getString("capacity");
				String address = rs.getString("address");

				Room room = new Room();
				room.setCapacity(capacity);
				room.setPrice(roomPrice);
				room.setAddress(address);
				room.setHotelName(hotelName);
				room.setHotelChain(chainName);
				room.setRating(ratings);
				
				Rooms.add(room);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return Rooms;

	}

	public String bookRoom(String custSSN, String roomNo) {
		connect();

		try {

			st = db.createStatement();
			sql = "update e_hotel.room set customer_ssn='" + custSSN + "', room_status='booked' where room_id='"
					+ roomNo + "'";
			st.executeUpdate(sql);

			return custSSN;

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} finally {
			disconnect();
		}

	}

	public static void main(String[] args) {
		PostgreSQLConn conn = new PostgreSQLConn();
		conn.bookRoom("john", "2");

	}
}
