/**    
 * @Title: UseCondition.java  
 * @Package com.concurrent.higher  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 7:34:02 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ClassName: UseCondition  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 7:34:02 AM  
 *    
 */
public class UseCondition
{
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void method1()
	{
		try
		{
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入等待状态...");
			Thread.sleep(3000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "释放锁...");
			condition.await(); // Object wait()
			System.out.println("当前线程:" + Thread.currentThread().getName() + "继续执行...");
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
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
			Thread.sleep(3000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "发出唤醒...");
			condition.signal(); // Object notify()
			System.out.println("当前线程:" + Thread.currentThread().getName() + "继续执行...");
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
		final UseCondition useCondition = new UseCondition();
		
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useCondition.method1();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				useCondition.method2();
			}
		}, "t2");
		
		t1.start();
		t2.start();
	}
}
