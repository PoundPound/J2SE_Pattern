package com.pattern.demo.abstractfactory;

public class Mouse {
	public Mouse(String configuration) {
		if (configuration.equalsIgnoreCase("luxury")) {
			this.luxury();
		}else if (configuration.equalsIgnoreCase("low")) {
			this.low();
		}
	}
	
	private void luxury() {
		System.out.println("luxury mouse");
	}

	private void low() {
		System.out.println("low mouse");
	}
}
