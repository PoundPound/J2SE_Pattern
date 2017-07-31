package com.pattern.demo.factorymethod;

public interface Factory {
	public Product createProduct();
}

class Factory1 implements Factory{

	@Override
	public Product1 createProduct() {
		return new Product1();
	}
	
}
class Factory2 implements Factory{

	@Override
	public Product2 createProduct() {
		return new Product2();
	}
	
}
class Factory3 implements Factory{

	@Override
	public Product3 createProduct() {
		return new Product3();
	}
	
}
