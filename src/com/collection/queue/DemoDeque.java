/**    
 * @Title: demoQueue.java  
 * @Package com.collection.queue  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 9:56:32 PM  
 * @version V1.0    
 */
package com.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @ClassName: demoQueue
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 9:56:32 PM
 * 
 */
public class DemoDeque
{
	public static void main(String[] args)
	{
		Deque<Request> container = new ArrayDeque<Request>();
		for (int i = 0; i < 10; i++)
		{
			final int num = i + 1;
			container.offer(new Request()
			{
				@Override
				public void deposit()
				{
					System.out.println("客户:" + num + ",的存款为:" + Math.random() * 100000);
				}
			});
		}
		
		dealWhith(container);
	}

	public static void dealWhith(Queue<Request> container)
	{
		Request req = null;
		while (null != (req = container.poll()))
		{
			req.deposit();
		}
	}

}

interface Request
{
	public void deposit();
}