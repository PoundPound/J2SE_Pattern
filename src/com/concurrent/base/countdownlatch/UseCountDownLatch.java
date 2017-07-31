/**    
 * @Title: UseCountDownlatch.java  
 * @Package com.concurrent.base.countdownlatch  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 9:33:07 AM  
 * @version V1.0    
 */
package com.concurrent.base.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**  
 * @ClassName: UseCountDownlatch  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 9:33:07 AM  
 *    
 */
public class UseCountDownLatch
{
	public static void main(String[] args)
	{
		final CountDownLatch countDownLatch = new CountDownLatch(2);
		
		Thread t1 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				try
				{
					System.out.println("进入线程t1,等待其他线程处理完毕...");
					countDownLatch.await();
					System.out.println("t1线程继续执行...");
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
					System.out.println("t2线程进行初始化操作...");
					Thread.sleep(3000);
					System.out.println("t2线程执行完毕，通知t1线程继续...");
					countDownLatch.countDown();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				try
				{
					System.out.println("t3线程进行初始化操作...");
					Thread.sleep(5000);
					System.out.println("t3线程执行完毕，通知t1线程继续...");
					countDownLatch.countDown();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
