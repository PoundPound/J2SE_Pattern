package com.pattern.singleton;

/**
 * 懒汉式单例模式(如何防止反射和凡序列化漏洞)
 * @author lewis
 *
 */
public class SingletonDemo2 {
	//类初始化时，不初始化这个对象（延时加载，真正用的时候在创建）
	private static SingletonDemo2 instance;
	
	private SingletonDemo2() {}
	
	//方法同步调用效率低
	public static synchronized SingletonDemo2 getInstance(){
		if (instance == null) {
			instance = new SingletonDemo2();
		}
		return instance;
	}
}
