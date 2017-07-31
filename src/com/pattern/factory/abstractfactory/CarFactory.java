package com.pattern.factory.abstractfactory;

public interface CarFactory {
	public Engine createEngine();
	public Seat createSeat();
	public Wheel createWheel();
}
