package com.kenya.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;


public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

//	MEMBER VARIABLES
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents;

	// CONSTRUCTOR
	public AdminUser(Integer employeeID, String role) {
		super(employeeID);
		this.employeeID = employeeID;
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}

//    METHODS

//    INTERFACES
	@Override
	public boolean assignPin(int pin) {
		String digitPin = String.valueOf(pin);
		if( digitPin.length() != 6) {
			return false;
		}else {
			this.pin = pin;
			return true;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		Integer compareId = Integer.valueOf(this.employeeID);
		Integer confirmCompare = Integer.valueOf(confirmedAuthID);
		if(  compareId.equals(confirmCompare)) {
			return true;
			
		}else {
			authIncident();
			return false;
		}
	}

	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
				this.employeeID, notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", new Date(), this.employeeID,
				"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}
	
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.securityIncidents;
	}
	
	

	// Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}