package com.in28minutes.rest.webservices.restful_web_services.versionning;

public class PersonV1 {

	private String name;

	public PersonV1(String name) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
