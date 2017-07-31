package com.pattern.factory.abstractfactory;

public class LuxuryEngine implements Engine {

	@Override
	public void run() {
		System.out.println("高端引擎跑的快！");
	}

	@Override
	public void start() {
		System.out.println("高端引擎起步快！");
	}

}
