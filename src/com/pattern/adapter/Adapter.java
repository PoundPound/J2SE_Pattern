package com.pattern.adapter;

/**
 * 类适配器
 * @author lewis
 *
 */
public class Adapter extends Module implements Target{
	@Override
	public void handlerRequest() {
		super.doSomething();
	}
}
