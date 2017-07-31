/**    
 * @Title: Client.java  
 * @Package com.tcpip.chat  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:29:43 PM  
 * @version V1.0    
 */
package com.tcpip.chat2;

import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName: Client
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:29:43 PM
 * 
 */
public class Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket client = new Socket("127.0.0.1", 8888);
			Send s = new Send(client);
			Receive r = new Receive(client);
			new Thread(s).start();
			new Thread(r).start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
