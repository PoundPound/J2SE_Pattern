/**    
 * @Title: Provider.java  
 * @Package com.concurrent.base.providerconsumer  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 8:26:29 AM  
 * @version V1.0    
 */
package com.concurrent.base.providerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**  
 * @ClassName: Provider  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 8:26:29 AM  
 *    
 */
public class Provider implements Runnable
{
	//共享缓存区
	private BlockingQueue<Data> queue;
	//多线程间是否启动变量，有强制从主内存中刷新的功能。即使返回线程的状态
	private volatile boolean isRunning = true;
	//id生成器
	private static AtomicInteger count = new AtomicInteger();
	//随即对象
	private static Random random = new Random();

	public Provider(BlockingQueue<Data> queue)
	{
		super();
		this.queue = queue;
	}

	/*  
	 * <p>Title: run</p>  
	 * <p>Description: </p>    
	 * @see java.lang.Runnable#run()  
	 */
	@Override
	public void run()
	{
		while (isRunning)
		{
			try
			{
				//随即休眠0-1000毫秒，表示获取数据（产生数据的耗时）
				Thread.sleep(random.nextInt(1000));
				//获取的数据进行累计
				int id = count.incrementAndGet();
				//比如通过一个getData()防火获取了Data
				Data data = new Data(id, "数据:" + id);
				System.out.println("当前线程:" + Thread.currentThread().getName() + ",获取了数据,id为:" + id + ",进行装载到公共缓存区中...");
				if (!this.queue.offer(data, 2, TimeUnit.SECONDS))
				{
					System.out.println("提交缓冲区数据失败...");
					//do something... 比如重新提交
				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**  
	 * @Title: stop  
	 * @Description: TODO  
	 * @param  
	 * @return void 
	 * @throws  
	 */
	public void stop()
	{
		this.isRunning = false;
	}
}
