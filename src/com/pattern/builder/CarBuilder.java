package com.pattern.builder;

public interface CarBuilder {
	public Engine builderEngine();
	public Seat buildSeat();
	public Wheel buildWheel();
}
