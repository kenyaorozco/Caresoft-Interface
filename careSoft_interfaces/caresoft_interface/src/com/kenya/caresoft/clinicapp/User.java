package com.kenya.caresoft.clinicapp;

public class User {
	// Member Variable
    protected Integer id;
    protected int pin;
    
//    Constructor to only take in an ID
	public User(Integer id) {
		super();
		this.id = id;

	}
	// Constructor that takes in an id and a pin 
//	public User(Integer id, int pin) {
//		super();
//		this.id = id;
//		this.pin = pin;
//
//	}



	//	-----GET ID -------
	public Integer getId() {
		return id;
	}
	
// ------- SET ID----------
	public void setId(Integer id) {
		this.id = id;
	}
	
//	-----GET PIN -------
	public int getPin() {
		return pin;
	}
	
//	-----SET PIN -------
	public void setPin(int pin) {
		this.pin = pin;
	}
 
}