package com.pattern.builder;

public class Car {
	private String name;
	private Engine engine;
	private Seat seat;
	private Wheel wheel;
	
	public void run(){
		System.out.println("车启动了。。。。。。");
	}
	
	public Car(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", engine=" + engine + ", seat=" + seat + ", wheel=" + wheel + "]";
	}
}
