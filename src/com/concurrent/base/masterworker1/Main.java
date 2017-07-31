/**    
 * @Title: Main.java  
 * @Package com.concurrent.base.masterworker  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 11:18:38 AM  
 * @version V1.0    
 */
package com.concurrent.base.masterworker1;

import java.util.Random;

/**  
 * @ClassName: Main  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 11:18:38 AM  
 *    
 */
public class Main
{

	/**  
	 * @Title: main  
	 * @Description: TODO  
	 * @param @param args 
	 * @return void 
	 * @throws  
	 */
	public static void main(String[] args)
	{
		Master master = new Master(new Worker(), 20);
		
		Random random = new Random();
		for (int i = 1; i <= 100; i++)
		{
			Task task = new Task();
			task.setId(i);
			task.setName("task-" + i);
			task.setNum(random.nextInt(1000));
			master.submit(task);
		}
		
		master.execute();
		
		long start = System.currentTimeMillis();
		
		while (true)
		{
			if (master.isComplete())
			{
				long end = System.currentTimeMillis() - start;
				int ret = master.getResult();
				System.out.println("最终结果:" + ret + ",耗时:" + end);
				break;
			}
		}
	}

}
