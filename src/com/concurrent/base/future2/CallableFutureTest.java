/**    
 * @Title: Main.java  
 * @Package com.concurrent.future2  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:57:46 AM  
 * @version V1.0    
 */
package com.concurrent.base.future2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName: Main
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:57:46 AM
 * 
 */
public class CallableFutureTest
{
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		Task1 task = new Task1();
		Future<Integer> result = executor.submit(task);
		executor.shutdown();

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}

		System.out.println("主线程在执行任务");

		try
		{
			System.out.println("task运行结果" + result.get());
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}

		System.out.println("所有任务执行完毕");
	}
}

class Task1 implements Callable<Integer>
{

	/*
	 * <p>Title: call</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception
	{
		System.out.println("子线程在进行计算...");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}

}
