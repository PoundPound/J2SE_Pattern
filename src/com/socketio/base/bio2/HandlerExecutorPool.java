/**    
 * @Title: HandlerExecutorPool.java  
 * @Package com.socketio.base.bio2  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 4, 2017 10:22:58 AM  
 * @version V1.0    
 */
package com.socketio.base.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**  
 * @ClassName: HandlerExecutorPool  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 4, 2017 10:22:58 AM  
 *    
 */
public class HandlerExecutorPool
{
	private ExecutorService executor;
	
	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>    
	 */
	public HandlerExecutorPool(int maximumPoolSize, int capacity)
	{
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maximumPoolSize, 120L,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(capacity));
	}
	
	public void executor(Runnable task)
	{
		this.executor.execute(task);
	}
}
