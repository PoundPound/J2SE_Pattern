package com.pattern.proxy.staticproxy;

public class Client {
	public static void main(String[] args) {
		Execute excute = new Execute();
		Proxy proxy = new RealProxy(excute);
		
		proxy.doSomething1();
		proxy.doSomething2();
		proxy.doSomething3();
	}
}
