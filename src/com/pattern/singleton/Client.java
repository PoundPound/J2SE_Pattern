package com.pattern.singleton;

public class Client {
	public static void main(String[] args) {
		SingletonDemo1 s11 = SingletonDemo1.getInstance();
		SingletonDemo1 s12 = SingletonDemo1.getInstance();
		System.out.println(s11);
		System.out.println(s12);
		
		SingletonDemo2 s21 = SingletonDemo2.getInstance();
		SingletonDemo2 s22 = SingletonDemo2.getInstance();
		System.out.println(s21);
		System.out.println(s22);
		
		SingletonDemo3 s31 = SingletonDemo3.getInstance();
		SingletonDemo3 s32 = SingletonDemo3.getInstance();
		System.out.println(s31);
		System.out.println(s32);
		
		SingletonDemo4 s41 = SingletonDemo4.getInstance();
		SingletonDemo4 s42 = SingletonDemo4.getInstance();
		System.out.println(s41);
		System.out.println(s42);
		
		System.out.println(SingletonDemo5.INSTANCE == SingletonDemo5.INSTANCE);
	}
}
