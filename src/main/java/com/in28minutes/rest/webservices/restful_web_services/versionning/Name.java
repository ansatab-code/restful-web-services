package com.in28minutes.rest.webservices.restful_web_services.versionning;

public class Name {

	private String fistName;
	private String LastName;
	public Name(String fistName, String lastName) {
		super();
		this.fistName = fistName;
		LastName = lastName;
	}
	public String getFistName() {
		return fistName;
	}
	public String getLastName() {
		return LastName;
	}
	@Override
	public String toString() {
		return "Name [fistName=" + fistName + ", LastName=" + LastName + "]";
	}
	
}
