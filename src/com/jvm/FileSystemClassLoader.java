/**    
 * @Title: FileSystemLoader.java  
 * @Package com.jvm  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 10, 2017 9:13:16 AM  
 * @version V1.0    
 */
package com.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: FileSystemLoader
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 10, 2017 9:13:16 AM
 * 
 */
public class FileSystemClassLoader extends ClassLoader
{
	private String rootDir;

	public FileSystemClassLoader(String rootDir)
	{
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		// 自定义加载器 双亲委派机制
		Class<?> clazz = findLoadedClass(name);
		if (clazz != null)
		{
			return clazz;
		}
		else
		{
			// AppClassloader
			ClassLoader parent = getParent();
			clazz = parent.loadClass(name);
			if (clazz != null)
			{
				return clazz;
			}
			else
			{
				// ExtClassloader
				ClassLoader second = parent.getParent();
				clazz = second.loadClass(name);
				if (clazz != null)
				{
					return clazz;
				}
				else
				{
					// BootstrapClassloader
					ClassLoader third = second.getParent();
					clazz = third.loadClass(name);
					if (clazz != null)
					{
						return clazz;
					}
					else
					{
						byte[] b = getClassData(name);
						clazz = defineClass(name, b, 0, b.length);
						if (clazz != null)
						{
							return clazz;
						}
					}
				}
			}
		}

		return clazz;
	}

	public byte[] getClassData(String className)
	{
		byte[] result = null;
		String classPath = rootDir + "/" + className.replace(".", "/") + ".class";

		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try
		{
			is = new FileInputStream(classPath);
			baos = new ByteArrayOutputStream();

			byte[] b = new byte[1024];
			int len = 0;
			while ((len = is.read(b)) != -1)
			{
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
			baos.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			result = null;
		}
		finally
		{
			if (baos != null)
			{
				try
				{
					baos.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
