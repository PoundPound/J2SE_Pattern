/**    
 * @Title: Client.java  
 * @Package com.concurrent.test.furture  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:06:38 AM  
 * @version V1.0    
 */
package com.concurrent.test.furture;

/**  
 * @ClassName: Client  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:06:38 AM  
 *    
 */
public class FurtureClient
{
	public Data request(String req)
	{
		final FurtureData furtureData = new FurtureData();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				RealData realData = new RealData(req);
				furtureData.setRealData(realData);
			}
		}).start();
		
		return furtureData;
	}
}
