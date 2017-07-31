package com.pattern.singleton;

/**
 * 单例模式 饿汉式
 * @author lewis
 *
 */
public class SingletonDemo1 {
	//类初始化时，立即加载这个对象（没有延时加载的优势）
	private static SingletonDemo1 instance = new SingletonDemo1();

	private SingletonDemo1() {}
	
	//static关键字会在类加载时初始化属性，创建对象，此时不会涉及到多个对象访问该对象的问题
	//虚拟机会保证只装载一次该类，肯定不会发生并发访问的问题，故此处省略synchronized
	//方法没有同步，调用效率高
	public static SingletonDemo1 getInstance(){
		return instance;
	}
}
