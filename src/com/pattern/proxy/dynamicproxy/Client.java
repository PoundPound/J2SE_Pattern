package com.pattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		ExecuteProxy execute = new Execute();
		ProxyHandler proxy = new ProxyHandler(execute);
		ExecuteProxy dynamicProxy = (ExecuteProxy) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{ExecuteProxy.class}, proxy);
		dynamicProxy.doSomething1();
		dynamicProxy.doSomething2();
		dynamicProxy.doSomething3();
	}
}
