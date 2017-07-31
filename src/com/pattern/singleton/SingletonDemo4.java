package com.pattern.singleton;

/**
 * 静态内部类实现单列模式
 * 优点：线程安全，调用效率高，懒加载
 * @author lewis
 *
 */
public class SingletonDemo4 {

	private SingletonDemo4() {}
	
	private static class SingletonClassInstance {
		private static final SingletonDemo4 instance = new SingletonDemo4();
	}
	
	public static SingletonDemo4 getInstance(){
		return SingletonClassInstance.instance;
	}
}
