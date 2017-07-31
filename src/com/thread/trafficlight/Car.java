/**    
 * @Title: Car.java  
 * @Package com.thread  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:16:21 AM  
 * @version V1.0    
 */
package com.thread.trafficlight;

/**
 * @ClassName: Car
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:16:21 AM
 * 
 */
public class Car implements Runnable
{
	private Road road;

	public Car()
	{
	}

	public Car(Road road)
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
				e.printStackTrace();
			}
			road.highway();
		}

	}

}
