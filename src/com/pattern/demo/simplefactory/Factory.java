package com.pattern.demo.simplefactory;

public class Factory {
	/*public static Product createProduct(int number){
		if (number == 1) {
			return new Product1();
		}else if (number == 2) {
			return new Product2();
		}else {
			return new Product3();
		}
	}*/
	//or 这种方式
	public static Product1 createProduct1(){
		return new Product1();
	}
	public static Product2 createProduct2(){
		return new Product2();
	}
	public static Product3 createProduct3(){
		return new Product3();
	}
}
