package com.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式 懒汉式
 * @author lewis
 *
 */
public class SingletonDemo6 implements Serializable{
	//类初始化时，不初始化这个对象（延时加载，真正用的时候在创建）
	private static SingletonDemo6 instance;
	
	private SingletonDemo6() {
		//第一次调正常创建，多次调用抛出异常（反射调用直接抛出异常）
		if (instance != null) {
			throw new RuntimeException();
		}
	}
	
	//方法同步调用效率低
	public static synchronized SingletonDemo6 getInstance(){
		if (instance == null) {
			instance = new SingletonDemo6();
		}
		return instance;
	}
	
	//反序列化时，如果定义了readResolve()则直接返回此方法指定的对象，而不需要单独创建新对象
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}
