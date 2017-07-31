package com.pattern.builder;

public class MyCarDirector implements CarDirector {

	private CarBuilder builder;
	
	public MyCarDirector(CarBuilder builder) {
		super();
		this.builder = builder;
	}

	@Override
	public Car createCar() {
		Engine engine = builder.builderEngine();
		Seat seat = builder.buildSeat();
		Wheel wheel = builder.buildWheel();
		
		Car car = new Car("My Car");
		car.setEngine(engine);
		car.setSeat(seat);
		car.setWheel(wheel);
		return car;
	}

	public CarBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(CarBuilder builder) {
		this.builder = builder;
	}

}
