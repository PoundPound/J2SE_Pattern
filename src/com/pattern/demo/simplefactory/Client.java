package com.pattern.demo.simplefactory;

public class Client {
	public static void main(String[] args) {
		/*Product p1 = Factory.createProduct(1);
		Product p2 = Factory.createProduct(2);
		Product p3 = Factory.createProduct(3);
		p1.name();
		p2.name();
		p3.name();*/
		
		Product p1 = Factory.createProduct1();
		Product p2 = Factory.createProduct2();
		Product p3 = Factory.createProduct3();
		p1.name();
		p2.name();
		p3.name();
	}
}
