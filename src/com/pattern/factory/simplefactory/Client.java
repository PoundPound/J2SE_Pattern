package com.pattern.factory.simplefactory;

public class Client {
	public static void main(String[] args) {
		Car audi = CarFactory.createCar("audi");
		Car benz = CarFactory.createCar("benz");
		
		audi.run();
		benz.run();
	}
}
