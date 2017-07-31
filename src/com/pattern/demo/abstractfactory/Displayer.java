package com.pattern.demo.abstractfactory;

public class Displayer {
	public Displayer(String configuration) {
		if (configuration.equalsIgnoreCase("luxury")) {
			this.luxury();
		}else if (configuration.equalsIgnoreCase("low")) {
			this.low();
		}
	}
	
	private void luxury(){
		System.out.println("luxury displayer");
	}
	private void low(){
		System.out.println("low displayer");
	}
}
