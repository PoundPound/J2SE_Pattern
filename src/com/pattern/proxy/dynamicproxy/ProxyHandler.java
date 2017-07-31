package com.pattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

	ExecuteProxy execute;
	
	public ProxyHandler(ExecuteProxy execute) {
		super();
		this.execute = execute;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		method.invoke(execute, args);
		
		return null;
	}

}
