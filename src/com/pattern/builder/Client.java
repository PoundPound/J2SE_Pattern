package com.pattern.builder;

public class Client {
	public static void main(String[] args) {
		
		MyCarDirector myCarDirector = new MyCarDirector(new MyCarBuilder());
		Car myCar = myCarDirector.createCar();
		System.out.println(myCar);
		myCar.run();
	}
}
