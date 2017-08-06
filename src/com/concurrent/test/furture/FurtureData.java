/**    
 * @Title: FurtureData.java  
 * @Package com.concurrent.test.furture  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:09:27 AM  
 * @version V1.0    
 */
package com.concurrent.test.furture;

/**  
 * @ClassName: FurtureData  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:09:27 AM  
 *    
 */
public class FurtureData implements Data
{
	private RealData realData;
	private boolean isReady = false;
	
	/**
	 * @param realData the realData to set
	 */
	public synchronized void setRealData(RealData realData)
	{
		if (isReady)
		{
			return;
		}
		this.realData = realData;
		isReady = true;
		notify();
	}
	
	/*  
	 * <p>Title: response</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.concurrent.test.furture.Data#response()  
	 */
	@Override
	public synchronized String response()
	{
		while (!isReady)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		return realData.response();
	}


}
