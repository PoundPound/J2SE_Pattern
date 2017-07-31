package com.pattern.proxy.staticproxy;

public class RealProxy implements Proxy {
	private Execute excute;

	public RealProxy(Execute excute) {
		super();
		this.excute = excute;
	}

	@Override
	public void doSomething1() {
		System.out.println("I can do Something1");
	}

	@Override
	public void doSomething2() {
		System.out.println("I can do Something1");
	}

	@Override
	public void doSomething3() {
		excute.doSomething3();
	}
}
