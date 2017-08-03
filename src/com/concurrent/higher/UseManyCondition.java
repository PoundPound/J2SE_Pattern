/**    
 * @Title: UseManyCondition.java  
 * @Package com.concurrent.higher  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 7:44:22 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ClassName: UseManyCondition  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 7:44:22 AM  
 *    
 */
public class UseManyCondition
{
	private ReentrantLock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	
	public void m1()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入m1等待...");
			Thread.sleep(2000);
			c1.await();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "m1继续执行");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public void m2()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入m2等待...");
			Thread.sleep(2500);
			c1.await();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "m2继续执行");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public void m3()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入m3等待...");
			Thread.sleep(2000);
			c2.await();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "m3继续执行");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public void m4()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "开始唤醒c1...");
			Thread.sleep(2500);
			c1.signalAll();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public void m5()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "开始唤醒c2...");
			Thread.sleep(2000);
			c2.signal();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public static void main(String[] args)
	{
		final UseManyCondition useManyCondition = new UseManyCondition();
		
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useManyCondition.m1();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useManyCondition.m2();
			}
		}, "t2");
		
		Thread t3 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useManyCondition.m3();
			}
		}, "t3");
		
		Thread t4 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useManyCondition.m4();
			}
		}, "t4");
		
		Thread t5 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useManyCondition.m5();
			}
		}, "t5");
		
		t1.start();
		t2.start();
		t3.start();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		t4.start();

		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		t5.start();
	}
}
