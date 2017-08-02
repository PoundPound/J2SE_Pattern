/**    
 * @Title: UseSemaphore.java  
 * @Package com.concurrent.higher  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 2, 2017 8:59:00 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**  
 * @ClassName: UseSemaphore  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 2, 2017 8:59:00 AM  
 *    
 */
public class UseSemaphore
{
	public static void main(String[] args)
	{
		//线程池
		ExecutorService executor = Executors.newCachedThreadPool();
		//只能5个线程同时访问
		Semaphore semaphore = new Semaphore(5);
		//模拟20个客户端访问
		for (int i = 1; i <= 20; i++)
		{
			final int no = i;
			Runnable runnable = new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						//获取许可
						semaphore.acquire();
						System.out.println("Accessing: " + no);
						//模拟实际业务逻辑
						Thread.sleep(5000);
						//访问完毕后释放
						semaphore.release();
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
					}
				}
			};
			executor.execute(runnable);
		}
	}
}
