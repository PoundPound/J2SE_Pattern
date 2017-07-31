package com.pattern.demo.factorymethod;

public interface Product {
	public void name();
}

class Product1 implements Product {
	public void name(){
		System.out.println("Product1");
	}
}

class Product2 implements Product {
	public void name(){
		System.out.println("Product2");
	}
}

class Product3 implements Product {
	public void name(){
		System.out.println("Product3");
	}
}