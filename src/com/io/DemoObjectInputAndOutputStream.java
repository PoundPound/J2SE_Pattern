/**    
 * @Title: DemoObjectInputAndOutputStream.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 26, 2017 9:37:24 AM  
 * @version V1.0    
 */
package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName: DemoObjectInputAndOutputStream
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 26, 2017 9:37:24 AM
 * 
 */
public class DemoObjectInputAndOutputStream
{
	public static void main(String[] args)
	{
		TestClass t = new TestClass("test name");
		write("testObjectStream.txt", t);

		read("testObjectStream.txt");
	}

	public static <T extends Object> void write(String dest, T t)
	{
		File file = new File(dest);
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			oos.writeObject(t);

			oos.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		finally
		{
			if (oos != null)
			{
				try
				{
					oos.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(String src)
	{
		TestClass t = null;

		File file = new File(src);
		ObjectInputStream bis = null;
		try
		{
			bis = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Object obj = bis.readObject();
			if (obj instanceof TestClass)
			{
				t = (TestClass) obj;
			}
			System.out.println(t.getName());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (bis != null)
			{
				try
				{
					bis.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}

class TestClass implements Serializable
{
	private String name;

	public TestClass(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}