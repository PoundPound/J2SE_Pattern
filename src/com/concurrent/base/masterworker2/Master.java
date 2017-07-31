/**    
 * @Title: Master.java  
 * @Package com.concurrent.base.masterworker  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 10:43:33 AM  
 * @version V1.0    
 */
package com.concurrent.base.masterworker2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**  
 * @ClassName: Master  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 10:43:33 AM  
 *    
 */
public class Master
{
	// 1.应该有一个承装任务的集合
	private ConcurrentLinkedQueue<Task> workerQueue = new ConcurrentLinkedQueue<Task>();
	
	// 2.使用HashMap去承装所有的Worker对象
	private HashMap<String, Thread> workers = new HashMap<String, Thread>();
	
	// 3.使用一个容器承装每一个Worker并发执行任务的结果集(这个容器必须支持高并发条件下的修改操作)
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	// 4.构造方法
	public Master(Worker worker, int workerCount)
	{
		// 每一个Worker对象都需要有Master的引用，workerQueue用于任务的领取，resultMap用于任务的提交
		worker.setWorkerQueue(workerQueue);
		worker.setResultMap(resultMap);
		
		for (int i = 1; i <= workerCount; i++)
		{
			// key表示每一个Worker的名字
			workers.put("childNode-" + i, new Thread(worker));
		}
	}
	
	// 5.提交方法
	public void submit(Task task)
	{
		this.workerQueue.add(task);
	}
	
	// 6.需要有一个执行方法（启动应用程序，让所有的Workder工作）
	public void execute()
	{
		for (Map.Entry<String, Thread> worker : workers.entrySet())
		{
			worker.getValue().start();
		}
	}

	/**  
	 * @Title: isComplete  
	 * @Description: TODO  
	 * @param @return 
	 * @return boolean 
	 * @throws  
	 */
	public boolean isComplete()
	{
		// 7.判断线程是否执行完毕
		for (Map.Entry<String, Thread> worker : workers.entrySet())
		{
			if (worker.getValue().getState() != Thread.State.TERMINATED)
			{
				return false;
			}
		}
		return true;
	}
	
	// 8.返回结果集数据
	public int getResult()
	{
		int result = 0;
		for (Map.Entry<String, Object> worker : resultMap.entrySet())
		{
			// 汇总的逻辑......
			result += (Integer) worker.getValue();
		}
		return result;
	}
}
