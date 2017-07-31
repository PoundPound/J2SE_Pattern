/**    
 * @Title: FutureClient.java  
 * @Package com.concurrent.future  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:13:40 AM  
 * @version V1.0    
 */
package com.concurrent.base.future1;

/**  
 * @ClassName: FutureClient  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:13:40 AM  
 *    
 */
public class FutureClient
{
	public Data request(final String req)
	{
		//1.我想要一个代理对象（Data接口的实现类），先返回给发送请求的客户端，告诉他请求已经接收到，可以做其他事情
		final FutureData futureData = new FutureData();
		
		//2.启动一个新的线程，去加载真实的数据，传递给这个代理对象
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				//3.这个新的线程可以慢慢的去加载真实对象，然后传递给代理对象
				RealData realData = new RealData(req);
				futureData.setRealData(realData);
			}
		}).start();
		
		return futureData;
	}
}
