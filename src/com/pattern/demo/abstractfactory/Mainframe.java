package com.pattern.demo.abstractfactory;

public class Mainframe {
	public Mainframe(String configuration) {
		if (configuration.equalsIgnoreCase("luxury")) {
			this.luxury();
		}else if (configuration.equalsIgnoreCase("low")) {
			this.low();
		}
	}
	
	private void luxury() {
		System.out.println("luxury mainframe");
	}

	private void low() {
		System.out.println("low mainframe");
	}
}
