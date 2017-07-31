/**    
 * @Title: Person.java  
 * @Package com.thread  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:09:06 AM  
 * @version V1.0    
 */
package com.thread.trafficlight;

/**
 * @ClassName: Person
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:09:06 AM
 * 
 */
public class Person implements Runnable
{
	private Road road;

	public Person()
	{
	}

	public Person(Road road)
	{
		this.road = road;
	}

	/*
	 * <p>Title: run</p> <p>Description: </p>
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(1500);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			road.footway();
		}
	}

}
