/**    
 * @Title: Server.java  
 * @Package com.tcpip.server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 8:14:57 AM  
 * @version V1.0    
 */
package com.tcpip.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @ClassName: Server
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 8:14:57 AM
 * 
 */
public class Server4
{
	private ServerSocket server;
	private boolean flag;

	public Server4()
	{
	}

	public Server4(int port)
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

	// post方式
	public void receive()
	{
		try
		{
			Socket client = server.accept();
			/*
			 * byte[] buf = new byte[20480]; int len =
			 * client.getInputStream().read(buf);
			 * 
			 * System.out.println(new String(buf, 0, len));
			 */

			Request request = new Request(client.getInputStream());
			Set<String> keys = request.getKeys();
			for (String key : keys)
			{
				System.out.println(key);
			}

			Response response = new Response(client.getOutputStream());
			response.println(
					"<html><meta charset=\"UTF-8\"><head><title>HTTP响应示例</title></head><body><p>responded!</p></body></html>");
			response.respond(Response.CODE_200, Response.TEXT_HTML, Response.UTF_8);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		Server4 server = new Server4(8888);
		server.receive();
	}
}
