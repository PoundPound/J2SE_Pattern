package com.pattern.builder;

public class MyCarBuilder implements CarBuilder {

	@Override
	public Engine builderEngine() {
		System.out.println("构建发动机！");
		return new Engine("波音发动机");
	}

	@Override
	public Seat buildSeat() {
		System.out.println("构建真皮沙发！");
		return new Seat("真皮沙发");
	}

	@Override
	public Wheel buildWheel() {
		System.out.println("构建耐磨轮胎！");
		return new Wheel("耐磨轮胎");
	}

}
