package com.pattern.factory.abstractfactory;

public class LowEngine implements Engine {

	@Override
	public void run() {
		System.out.println("低端引擎跑的慢！");
	}

	@Override
	public void start() {
		System.out.println("低端引擎起步慢！");
	}

}
