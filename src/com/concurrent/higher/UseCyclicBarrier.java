/**    
 * @Title: Use.java  
 * @Package com.concurrent.base  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 9:49:09 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @ClassName: Use  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 9:49:09 AM  
 *    
 */
public class UseCyclicBarrier
{
	public static void main(String[] args)
	{
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		
		ExecutorService excutor = Executors.newFixedThreadPool(3);
		
		excutor.submit(new Thread(new Runner(cyclicBarrier, "张三")));
		excutor.submit(new Thread(new Runner(cyclicBarrier, "李四")));
		excutor.submit(new Thread(new Runner(cyclicBarrier, "王五")));
		
		excutor.shutdown();
	}
}

class Runner implements Runnable
{
	private CyclicBarrier cb;
	private String name;
	
	public Runner(java.util.concurrent.CyclicBarrier cyclicBarrier, String name)
	{
		super();
		this.cb = cyclicBarrier;
		this.name = name;
	}

	/*  
	 * <p>Title: run</p>  
	 * <p>Description: </p>    
	 * @see java.lang.Runnable#run()  
	 */
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(new Random().nextInt(1000));
			System.out.println(name + "准备OK.");
			cb.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
		System.out.println(name + "跑!");
	}
	
}