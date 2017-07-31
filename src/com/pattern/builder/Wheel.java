package com.pattern.builder;

public class Wheel {
	private String name;

	public Wheel(String name) {
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
		return "Wheel [name=" + name + "]";
	}

	
}
