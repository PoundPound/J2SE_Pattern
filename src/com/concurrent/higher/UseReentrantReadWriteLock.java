/**    
 * @Title: UseReentrantReadWriteLock.java  
 * @Package com.concurrent.higher  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 8:39:28 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**  
 * @ClassName: UseReentrantReadWriteLock  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 8:39:28 AM  
 *    
 */
public class UseReentrantReadWriteLock
{
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReadLock read = lock.readLock();
	private WriteLock write = lock.writeLock();
	
	public void read()
	{
		try
		{
			read.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
			Thread.sleep(3000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			read.unlock();
		}
	}
	
	public void write()
	{
		try
		{
			write.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
			Thread.sleep(2000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			write.unlock();;
		}
	}
	
	public static void main(String[] args)
	{
		final UseReentrantReadWriteLock urrwl = new UseReentrantReadWriteLock();
		
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				urrwl.read();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				urrwl.read();
			}
		}, "t2");
		
		Thread t3 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				urrwl.write();
			}
		}, "t3");
		
//		t1.start();
//		t2.start();
		
		t1.start();
		t3.start();
	}
}
