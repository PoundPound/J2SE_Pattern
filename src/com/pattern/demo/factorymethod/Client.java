package com.pattern.demo.factorymethod;

public class Client {
	public static void main(String[] args) {
		Product1 p1 = new Factory1().createProduct();
		Product2 p2 = new Factory2().createProduct();
		Product3 p3 = new Factory3().createProduct();
		p1.name();
		p2.name();
		p3.name();
	}
}
