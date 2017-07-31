package com.pattern.singleton;

/**
 * 双重检查锁实现单例模式
 * @author lewis
 *
 */
public class SingletonDemo3 {
	private static SingletonDemo3 instance = null;

	private SingletonDemo3() {}
	
	public static SingletonDemo3 getInstance(){
		if (instance == null) {
			SingletonDemo3 sd;
			synchronized (SingletonDemo3.class) {
				sd = instance;
				if (sd == null) {
					synchronized (SingletonDemo3.class) {
						if (sd == null) {
							sd = new SingletonDemo3();
						}
					}
					instance = sd;
				}
			}
		}
		return instance;
	}
}
