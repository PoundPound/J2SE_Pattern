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
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: test01
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 10:10:30 AM
 * 
 */
public class Test3
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
		final CountDownLatch countDownLatch = new CountDownLatch(1);

		final Test3 test = new Test3();

		Thread t1 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					for (int i = 1; i < 11; i++)
					{
						test.add("num:" + i);
						System.out.println("list add:" + i);
						Thread.sleep(500);
						if (list.size() == 5)
						{
							System.out.println("发出通知");
							countDownLatch.countDown();
						}
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					if (test.getSize() != 5)
					{
						countDownLatch.await();
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("线程停止");
				throw new RuntimeException();
			}
		});

		t2.start();
		t1.start();
	}
}
