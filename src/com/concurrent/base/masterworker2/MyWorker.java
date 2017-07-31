/**    
 * @Title: MyWorker.java  
 * @Package com.concurrent.base.masterworker2  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 11:53:56 AM  
 * @version V1.0    
 */
package com.concurrent.base.masterworker2;

/**  
 * @ClassName: MyWorker  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 11:53:56 AM  
 *    
 */
public class MyWorker extends Worker
{

	public static Object handler(Task task)
	{
		Object result = null;
		try
		{
			//表示处理Task任务的耗时，可能是数据的加工，也可能是操作数据库......
			Thread.sleep(500);
			
			result = task.getNum();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
