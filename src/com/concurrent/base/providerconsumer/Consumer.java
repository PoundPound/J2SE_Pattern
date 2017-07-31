/**    
 * @Title: Consumer.java  
 * @Package com.concurrent.base.providerconsumer  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 8:26:37 AM  
 * @version V1.0    
 */
package com.concurrent.base.providerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**  
 * @ClassName: Consumer  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 8:26:37 AM  
 *    
 */
public class Consumer implements Runnable
{
	private BlockingQueue<Data> queue;
	//随即对象
	private static Random random = new Random();
	
	public Consumer(BlockingQueue<Data> queue)
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
		while (true)
		{
			try
			{
				//获取数据
				Data data = this.queue.take();
				//进行数据处理,休眠0-1000毫秒模拟耗时
				Thread.sleep(random.nextInt(1000));
				System.out.println("当前消费线程:" + Thread.currentThread().getName() + ",消费成功,消费数据为id:" + data.getId());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
