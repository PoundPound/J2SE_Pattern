/**    
 * @Title: RPCTest.java  
 * @Package com.rpc  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:52:21 AM  
 * @version V1.0    
 */
package com.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**  
 * @ClassName: RPCTest  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:52:21 AM  
 *    
 */
public class RPCTest
{
	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				try
				{
					Server serviceServer = new ServiceCenter(9876);
					serviceServer.register(HelloService.class, HelloServiceImpl.class);
					serviceServer.start();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
		
		HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 9876));
        System.out.println(service.sayHi("test"));
	}
}
