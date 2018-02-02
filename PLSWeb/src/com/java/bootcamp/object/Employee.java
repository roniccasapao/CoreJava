package com.java.bootcamp.object;

public class Employee {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String seatId;
	
	public Employee(String employeeId, String firstName, String lastName, String seatId) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.seatId = seatId;
	}
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", seatId=" + seatId + "]";
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
}
