package com.pattern.proxy.dynamicproxy;

public class Execute implements ExecuteProxy {

	@Override
	public void doSomething1() {
		System.out.println("I can do Something1");
	}

	@Override
	public void doSomething2() {
		System.out.println("I can do Something2");
	}

	@Override
	public void doSomething3() {
		System.out.println("just only Execute can do Something3");
	}

}
