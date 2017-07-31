/**    
 * @Title: Test.java  
 * @Package com.reflect  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 6, 2017 10:08:16 AM  
 * @version V1.0    
 */
package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 6, 2017 10:08:16 AM
 * 
 */
public class Test
{

	/**
	 * @Title: main @Description: TODO @param @param args @return void @throws
	 */
	public static void main(String[] args)
	{
		try
		{
			Class<com.reflect.Person> clazz = (Class<Person>) Class.forName("com.reflect.Person");
			
			Person p1 = clazz.newInstance();
			System.out.println(p1);
			System.out.println(p1.hashCode());
			
			Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
			Person p2 = constructor.newInstance("cool", 18);
			System.out.println(p2);
			System.out.println(p2.hashCode());
			
			Field field = clazz.getDeclaredField("name");
			field.setAccessible(true);
			System.out.println(field.get(p2));
			field.set(p2, "hot");
			System.out.println(field.get(p2));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
