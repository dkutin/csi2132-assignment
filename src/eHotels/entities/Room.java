package eHotels.entities;

public class Room {
	
		private String roomNo;
		private String custSSN;
		private String roomStatus;
		private String hotelID;
		private String capacity;
		private String price;
		private boolean extendable;
		private String roomDesc;
		private String roomView;
		private String bookingID;
		private String startDate;
		private String endDate;
		private String hotelName;
		private String address;
		private String hotelChain;
		private String rating;
		
		

		public Room() {
			
		}
		
		public Room(String roomNo, String roomStatus, String hotelID,String capacity, String price, boolean extendable, String roomDesc, String roomView) {
			this.roomNo = roomNo;
			this.roomStatus = roomStatus;
			this.setHotelID(hotelID);
			this.setCapacity(capacity);
			this.setPrice(price);
			this.setExtendable(extendable);
			this.setRoomDesc(roomDesc);
			this.setRoomView(roomView);
			
		}
		public Room(String bookingID, String startDate, String endDate, String hotelName, String roomNo, String price) {
			this.setBookingID(bookingID);
			this.setStartDate(startDate);
			this.setEndDate(endDate);
			this.setHotelName(hotelName);
			this.roomNo = roomNo;
			this.setPrice(price); 
		}
		public Room(String roomNo, String roomStatus) {
			this.roomNo = roomNo;
			this.roomStatus = roomStatus;
		}

		public void setRoomNo(String newRoomNo) {
			this.roomNo = newRoomNo;
			
		}
		
		public void setRoomStatus(String newRoomStatus) {
			this.roomStatus = newRoomStatus;
		}
		
		public void setCustSSN(String newCust) {
			this.custSSN = newCust;
		}
		
		public String getRoomNo() {
			return roomNo;
		}
		
		public String getcustSSN() {
			return custSSN;
		}
		
		public String getRoomStatus() {
			return roomStatus;
		}

		public String getRoomDesc() {
			return roomDesc;
		}

		public void setRoomDesc(String roomDesc) {
			this.roomDesc = roomDesc;
		}

		public String getHotelName() {
			return hotelName;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getCapacity() {
			return capacity;
		}

		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}

		public String getHotelID() {
			return hotelID;
		}

		public void setHotelID(String hotelID) {
			this.hotelID = hotelID;
		}

		public boolean isExtendable() {
			return extendable;
		}

		public void setExtendable(boolean extendable) {
			this.extendable = extendable;
		}

		public String getRoomView() {
			return roomView;
		}

		public void setRoomView(String roomView) {
			this.roomView = roomView;
		}

		public String getBookingID() {
			return bookingID;
		}

		public void setBookingID(String bookingID) {
			this.bookingID = bookingID;
		}
		
		public void setRating(String ratings) {
			this.rating = ratings;
		}
		public void setHotelChain(String hotelChain) {
			this.hotelChain = hotelChain;
		}
		public void setAddress(String address) {
			this.address = address;
		}
}
