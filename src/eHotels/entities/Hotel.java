package eHotels.entities;

import java.util.ArrayList;

public class Hotel {
	private String rating;
	private String name;
	private String chain;
	private String address;
	private String noRooms;
	private ArrayList<Room> rooms;
	
	public Hotel() {
		
	}
	
	public Hotel(String rating, String name, String chain, String address, String noRooms, Room rooms) {
		this.setRating(rating);
		this.setName(name);
		this.setChain(chain);
		this.setAddress(address);
		this.setNoRooms(noRooms);
		this.setRooms(rooms);
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChain() {
		return chain;
	}

	public void setChain(String chain) {
		this.chain = chain;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(String noRooms) {
		this.noRooms = noRooms;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
}
