package com.kenya.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	// MEMBER VARIABLES
	private ArrayList<String> patientNotes;

	// CONSTRUCTOR
	public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
		
	}

//	INTERFACES
	@Override
	public boolean assignPin(int pin) {
		String digitPin = String.valueOf(pin);
		if( digitPin.length() != 4) {
			return false;
		}else {
			this.pin = pin;
			return true;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		Integer compareId = Integer.valueOf(this.id);
		Integer confirmCompare = Integer.valueOf(confirmedAuthID);
//		Integer confirmedAuthID = compareId;
		if(  confirmCompare.equals(compareId)) {
			return true;
			
		}else {
			
			return false;
		}
		
	}

// METHODS
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	// Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}
