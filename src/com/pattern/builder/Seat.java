package com.pattern.builder;

public class Seat {
	private String name;

	public Seat(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Seat [name=" + name + "]";
	}
	
}
