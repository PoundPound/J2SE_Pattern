/**    
 * @Title: Client.java  
 * @Package com.tcpip.chat  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:29:43 PM  
 * @version V1.0    
 */
package com.tcpip.chat4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
			System.out.println("请输入用户名:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			String name = br.readLine();
			if (name.equals(""))
			{
				System.out.println("没有输入用户名...");
				return;
			}
			
			Socket client = new Socket("127.0.0.1", 8888);
			Send s = new Send(client, name);
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
