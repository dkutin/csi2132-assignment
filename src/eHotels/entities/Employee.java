package eHotels.entities;

import java.util.ArrayList;

public class Employee {
	private String employee_id;
	private String employee_pass;
	private ArrayList<String> employee_role;
	
	public Employee() {

	}

	public String getEmployeeID() {
		return employee_id;
	}

	public String getEmployeePass() {
		return employee_pass;
	}

	public void setEmployeeID(String ID) {
		this.employee_id = ID;
	}

	public void setEmployeePass(String pass) {
		this.employee_pass = pass;
	}

	public String getEmployeeRole() {
		return employee_role.toString();
	}
	
	public void setEmployeeRole(ArrayList<String> employee_role) {
		this.employee_role = employee_role;
	}
}
