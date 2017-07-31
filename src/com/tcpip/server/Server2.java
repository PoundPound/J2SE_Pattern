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
public class Server2
{
	private ServerSocket server;
	private boolean flag;

	public Server2()
	{
	}

	public Server2(int port)
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

	//post方式
	public void receive()
	{
		try
		{
			Socket client = server.accept();
			byte[] buf = new byte[20480];
			int len = client.getInputStream().read(buf);

			System.out.println(new String(buf, 0, len));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		Server2 server = new Server2(8888);
		server.receive();
	}
}
