/**    
 * @Title: Main.java  
 * @Package com.concurrent.future  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:13:01 AM  
 * @version V1.0    
 */
package com.concurrent.base.future1;

/**
 * @ClassName: Main
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 8:13:01 AM
 * 
 */
public class Main
{
	public static void main(String[] args)
	{
		FutureClient client = new FutureClient();
		Data data = client.request("请求参数");
		System.out.println("请求发送成功!");
		System.out.println("作其他的事情...");
		
		String resp = data.response();
		System.out.println(resp);
	}
}
