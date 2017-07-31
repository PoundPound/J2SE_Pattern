package com.pattern.factory.abstractfactory;

public class LuxuryCarFactory implements CarFactory {

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}

	@Override
	public Wheel createWheel() {
		return new LuxuryWheel();
	}

}
