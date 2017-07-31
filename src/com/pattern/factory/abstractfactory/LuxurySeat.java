package com.pattern.factory.abstractfactory;

public class LuxurySeat implements Seat {

	@Override
	public void massage() {
		System.out.println("高端座椅有按摩功能！");
	}

}
