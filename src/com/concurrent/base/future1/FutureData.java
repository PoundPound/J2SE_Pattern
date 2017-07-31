/**    
 * @Title: FutureData.java  
 * @Package com.concurrent.future  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:14:08 AM  
 * @version V1.0    
 */
package com.concurrent.base.future1;

/**  
 * @ClassName: FutureData  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:14:08 AM  
 *    
 */
public class FutureData implements Data
{
	private RealData realData;
	
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData)
	{
		//如果已经加载完毕则直接返回
		if (isReady)
		{
			return;
		}
		//如果没有装载，进行装载真实对象
		this.realData = realData;
		isReady = true;
		//进行通知
		notify();
	}

	/*  
	 * <p>Title: getResponse</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.concurrent.future.Data#getResponse()  
	 */
	@Override
	public synchronized String response()
	{
		//如果没有装载好，程序就一直处于阻塞状态
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
		//装载好直接获取数据即可
		return this.realData.response();
	}
}
