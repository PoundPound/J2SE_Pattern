/**    
 * @Title: Move.java  
 * @Package com.thread  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:06:54 AM  
 * @version V1.0    
 */
package com.thread.trafficlight;

/**
 * @ClassName: Move
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:06:54 AM
 * 
 */
public class Road
{
	private String lane;

	private boolean flag = true;

	public String getLane()
	{
		return lane;
	}

	public void setLane(String lane)
	{
		this.lane = lane;
	}

	public void trafficLight(String msg)
	{
		System.out.println(msg);
	}

	public synchronized void highway()
	{
		// flag = true car -> run
		if (!flag)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		//
		trafficLight("Car is run, Person stop");
		flag = false;
		this.notifyAll();
	}

	public synchronized void footway()
	{
		// flag = false person -> run
		if (flag)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		trafficLight("Person is run, Car stop");
		flag = true;
		this.notify();
	}
}
