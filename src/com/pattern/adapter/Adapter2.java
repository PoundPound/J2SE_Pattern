package com.pattern.adapter;


/**
 * 对象适配器
 * @author lewis
 *
 */
public class Adapter2 implements Target{
	private Module module;
	
	public Adapter2(Module module) {
		super();
		this.module = module;
	}

	@Override
	public void handlerRequest() {
		module.doSomething();
	}
}
