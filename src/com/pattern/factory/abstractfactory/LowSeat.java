package com.pattern.factory.abstractfactory;

public class LowSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("低端座椅没有按摩功能！");
	}

}
