package eHotels.entities;

public class Customer {
	private String SSN;
	private String customer_pass;

	public Customer() {

	}
	
	public Customer(String SSN, String pass) {
		this.SSN = SSN;
		this.customer_pass = pass;
	}

	public String getCustomerSSN() {
		return SSN;
	}
	
	public String getCustomerPass() {
		return customer_pass;
	}
	
	public void setCustomerSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public void setCustomerPass(String pass) {
		this.customer_pass = pass;
	}
}
