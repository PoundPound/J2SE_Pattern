package com.pattern.demo.abstractfactory;

public class Keyboard {
	public Keyboard(String configuration) {
		if (configuration.equalsIgnoreCase("luxury")) {
			this.luxury();
		}else if (configuration.equalsIgnoreCase("low")) {
			this.low();
		}
	}

	private void luxury() {
		System.out.println("luxury keyboard");
	}

	private void low() {
		System.out.println("low keyboard");
	}
}
