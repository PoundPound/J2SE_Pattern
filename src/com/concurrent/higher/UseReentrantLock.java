/**    
 * @Title: Use.java  
 * @Package com.concurrent.higher  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 7:11:59 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ClassName: Use  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 7:11:59 AM  
 *    
 */
public class UseReentrantLock
{
	private ReentrantLock lock = new ReentrantLock();
	
	public void method1()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1");
			Thread.sleep(1000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1");
			Thread.sleep(1000);
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
	
	public void method2()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method2");
			Thread.sleep(2000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method2");
			Thread.sleep(2000);
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
		final UseReentrantLock useLock = new UseReentrantLock();
		
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useLock.method1();
				useLock.method2();
			}
		}, "t1");
		
		t1.start();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}