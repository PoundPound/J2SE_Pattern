/**    
 * @Title: main.java  
 * @Package com.concurrent.test.furture  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:25:29 AM  
 * @version V1.0    
 */
package com.concurrent.test.furture;

/**  
 * @ClassName: main  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:25:29 AM  
 *    
 */
public class Main
{
	public static void main(String[] args)
	{
		FurtureClient client = new FurtureClient();
		Data data = client.request("请求发送");
		System.out.println(data.response());
	}
}
