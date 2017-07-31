/**    
 * @Title: Client.java  
 * @Package com.jvm  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 10, 2017 9:35:47 AM  
 * @version V1.0    
 */
package com.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: Client
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 10, 2017 9:35:47 AM
 * 
 */
public class Client
{

	/**
	 * @Title: main @Description: TODO @param @param args @return void @throws
	 */
	public static void main(String[] args)
	{
		String rootDir = "/home/lewis/workspace/J2SE_Pattern/src/com/jvm";
		FileSystemClassLoader fsl = new FileSystemClassLoader(rootDir);

		try
		{
			Class<?> clazz = fsl.findClass("com.jvm.HelloWorld");
			System.out.println(clazz.getName());
			Method method = clazz.getDeclaredMethod("main", String[].class);
			method.invoke(clazz, (Object)new String[]{});
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}

}
