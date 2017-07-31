/**    
 * @Title: Worker.java  
 * @Package com.concurrent.base.masterworker  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 10:43:40 AM  
 * @version V1.0    
 */
package com.concurrent.base.masterworker2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**  
 * @ClassName: Worker  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 10:43:40 AM  
 *    
 */
public class Worker implements Runnable
{
	private ConcurrentLinkedQueue<Task> workerQueue;
	private ConcurrentHashMap<String, Object> resultMap;
	
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
			Task task = this.workerQueue.poll();
			if (task == null)
			{
				break;
			}
			//真正的去做业务处理
			Object result = MyWorker.handler(task);
			//处理结果放到Master的结果集里
			this.resultMap.put(task.getId() + "", result);
		}
	}

	/**  
	 * @Title: handler  
	 * @Description: TODO  
	 * @param @param input
	 * @param @return 
	 * @return Object 
	 * @throws  
	 */
	public static Object handler(Task task)
	{
		return null;
	}

	/**  
	 * @Title: setWorkerQueue  
	 * @Description: TODO  
	 * @param @param workerQueue 
	 * @return void 
	 * @throws  
	 */
	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue)
	{
		this.workerQueue = workerQueue;
	}

	/**  
	 * @Title: setResultMap  
	 * @Description: TODO  
	 * @param @param resultMap 
	 * @return void 
	 * @throws  
	 */
	public void setResultMap(ConcurrentHashMap<String, Object> resultMap)
	{
		this.resultMap = resultMap;
	}
}
