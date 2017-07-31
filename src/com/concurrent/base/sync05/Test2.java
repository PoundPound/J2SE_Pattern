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
public class Test2
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
		final Test2 test = new Test2();

		final Object lock = new Object();

		Thread t1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				synchronized (lock)
				{
					for (int i = 0; i < 10; i++)
					{
						test.add("num:" + i);
						System.out.println("list add:" + i);
						if (list.size() == 5)
						{
							System.out.println("发出通知");
							lock.notify();
						}
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				synchronized (lock)
				{
					try
					{
						if (test.getSize() != 5)
						{
							lock.wait();
							System.out.println("线程停止");
							throw new RuntimeException();
						}
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		});

		t2.start();
		t1.start();
	}
}
