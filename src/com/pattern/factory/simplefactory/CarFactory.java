package com.pattern.factory.simplefactory;

public class CarFactory {
	//方式一
	/*public static Car createAudi(){
		return new Audi();
	}
	
	public static Car createBenz(){
		return new Benz();
	}*/
	
	//方式二
	public static Car createCar(String brand){
		if ("audi".equalsIgnoreCase(brand)) {
			return new Audi();
		}else if ("benz".equalsIgnoreCase(brand)) {
			return new Benz();
		}else{
			return null;
		}
	}
}
