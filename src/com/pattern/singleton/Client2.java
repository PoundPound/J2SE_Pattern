package com.pattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client2 {
	public static void main(String[] args) {
		SingletonDemo6 s1 = SingletonDemo6.getInstance();
		SingletonDemo6 s2 = SingletonDemo6.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		/*try {
			Class<SingletonDemo6> clazz = (Class<SingletonDemo6>) Class.forName("com.pattern.singleton.demo.SingletonDemo6");
			Constructor<SingletonDemo6> c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);
			SingletonDemo6 s3 = c.newInstance();
			SingletonDemo6 s4 = c.newInstance();
			System.out.println(s3);
			System.out.println(s4);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
			try {
				FileOutputStream fos = new FileOutputStream("/home/lewis/workspace/test");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(s1);
				
				oos.close();
				fos.close();
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/home/lewis/workspace/test")));
				SingletonDemo6 s3 = (SingletonDemo6) ois.readObject();
				System.out.println(s3);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
