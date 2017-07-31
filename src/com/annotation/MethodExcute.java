/**    
 * @Title: MethodExcute.java  
 * @Package com.annotation  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 5, 2017 9:23:27 AM  
 * @version V1.0    
 */
package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName: MethodExcute
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 5, 2017 9:23:27 AM
 * 
 */
public class MethodExcute
{
	public static void main(String[] args)
	{
		/*
		 * try { Class clazz = Class.forName("com.annotation.Client"); Method[]
		 * methods = clazz.getDeclaredMethods(); for (Method m : methods) {
		 * MethodAnnotationDemo aDemo =
		 * m.getAnnotation(MethodAnnotationDemo.class);
		 * 
		 * System.out.println(aDemo.value()); String annotation = aDemo.value();
		 * if (annotation.equals("createThread")) { new Thread(new Runnable() {
		 * 
		 * @Override public void run() { for (int i = 0; i < 10; i++) {
		 * System.out.println(i); }
		 * 
		 * } }).start(); } } } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); }
		 */
		String string = "Stephan";
		int len = string.length();
		System.out.println(reverse(string, "", len));
	}

	public static String reverse(String str, String des, int len)
	{
		des = des + str.charAt(str.length() - 1);
		return len == 1 ? des : reverse(str.substring(0, len - 1), des, --len);
	}
}
