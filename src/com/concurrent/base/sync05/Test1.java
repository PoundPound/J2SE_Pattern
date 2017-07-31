/**    
 * @Title: test01.java  
 * @Package com.concurrent.base.test  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 10:10:30 AM  
 * @version V1.0    
 */
package com.concurrent.base.sync05;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: test01
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 10:10:30 AM
 * 
 */
public class Test1
{
	private volatile static List<String> list = new ArrayList<String>();

	public void add(String str)
	{
		list.add(str);
	}

	public int getSize()
	{
		return list.size();
	}

	public static void main(String[] args)
	{
		final Test1 test = new Test1();

		Thread t1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				for (int i = 0; i < 10; i++)
				{
					test.add("num:" + i);
					System.out.println("list add:" + i);
				}
			}
		});

		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				while (test.getSize() == 5)
				{
					System.out.println("线程停止");
					throw new RuntimeException();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
