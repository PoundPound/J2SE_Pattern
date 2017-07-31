/**    
 * @Title: Server.java  
 * @Package com.tcpip.server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 8:14:57 AM  
 * @version V1.0    
 */
package com.tcpip.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Server
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 8:14:57 AM
 * 
 */
public class Server
{
	private ServerSocket server;
	private boolean flag;

	public Server()
	{
	}

	public Server(int port)
	{
		this.start(port);
	}

	public void start(int port)
	{
		try
		{
			server = new ServerSocket(port);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			stop();
		}
	}

	public void stop()
	{
		flag = false;
		CloseUtils.close(server);
	}

	//get方式
	public void receive()
	{
		try
		{
			Socket client = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String msg = null;
			while ((msg = br.readLine()).length() > 0)
			{
				if (msg == null)
				{
					break;
				}
				sb.append(msg.trim() + "\r\n");
			}
			System.out.println(sb.toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		Server server = new Server(8888);
		server.receive();
	}
}
