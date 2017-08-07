/**    
 * @Title: Test.java  
 * @Package com.rpc  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 10:16:03 AM  
 * @version V1.0    
 */
package com.rpc;

import java.net.InetSocketAddress;

/**  
 * @ClassName: Test  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 10:16:03 AM  
 *    
 */
public class Test
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
		HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 9876));
        System.out.println(service.sayHi("aaa"));
	}

}
