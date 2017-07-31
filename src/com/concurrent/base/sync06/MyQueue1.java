/**    
 * @Title: MyQueue.java  
 * @Package com.concurrent.base.sync06  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 9:44:57 PM  
 * @version V1.0    
 */
package com.concurrent.base.sync06;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**  
 * @ClassName: MyQueue  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 9:44:57 PM  
 *    
 */
public class MyQueue1
{
	//链表容器存放数据
	private LinkedList<Object> list = new LinkedList<Object>();
	
	//计数器
	private AtomicInteger count = new AtomicInteger(0);
	
	//锁
	private final Object lock = new Object();
	
	//容器存放数据的最小值
	private final int minSize = 0;
	
	//容器存放数据的最大值
	private final int maxSize;
	
	public MyQueue1(int size)
	{
		this.maxSize = size;
	}

	public void put(Object obj)
	{
		synchronized (lock)
		{
			//放满了则等着
			if (count.get() == maxSize)
			{
				try
				{
					lock.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			//加入元素
			list.add(obj);
			//计数器自增
			count.incrementAndGet();
			System.out.println("放入了一个对象:" + obj);
			//唤醒其他线程
			lock.notify();
		}
	}
	
	public Object take()
	{
		Object result = null;
		synchronized (lock)
		{
			//没有元素则等待
			if (count.get() == minSize)
			{
				try
				{
					lock.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			//取出第一个元素
			result = list.removeFirst();
			//数量自减
			count.decrementAndGet();
			//通知其他线程可以方了
			lock.notify();
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		MyQueue1 mq = new MyQueue1(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				mq.put("f");
				mq.put("g");
			}
		});
		
		t1.start();
		
		try
		{
			TimeUnit.SECONDS.sleep(2);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				Object o1 = mq.take();
				System.out.println(o1);
				Object o2 = mq.take();
				System.out.println(o2);
			}
		});
		
		t2.start();
	}
}
