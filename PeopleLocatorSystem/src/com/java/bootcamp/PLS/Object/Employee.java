package com.java.bootcamp.PLS.Object;

public class Employee {
	private String employeeID;
	private String firstname;
	private String lastName;
	private String seatId;
	private String localNum;
	private String shift;
	private String role;
	private String projects;
	
	public Employee(String employeeID, String firstname, String lastName, String seatId,
			String localNum, String shift, String projects) {
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastName = lastName;
		this.seatId = seatId;
		this.localNum = localNum;
		this.shift = shift;
		this.projects = projects;
	}
	
	
	@Override
	public String toString() {
		StringBuffer stringbuffer = new StringBuffer();
		return stringbuffer.append(String.format("%" + (-8) + "s", employeeID)).append(" | ")
				.append(String.format("%" + (-11) + "s", firstname)).append(" | ")
				.append(String.format("%" + (-11) + "s", lastName)).append(" | ")
				.append(String.format("%" + (-11) + "s", seatId)).append(" | ")
				.append(String.format("%" + (-11) + "s", localNum)).append(" | ")
				.append(String.format("%" + (-11) + "s", shift)).append(" | ")
				.append(String.format("%" + (-30) + "s", projects)).append(" | ").toString(); 
	}

	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocalNum() {
		return localNum;
	}
	public void setLocalNum(String localNum) {
		this.localNum = localNum;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
