/**    
 * @Title: Receive.java  
 * @Package com.tcpip.chat2  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 10:30:51 PM  
 * @version V1.0    
 */
package com.tcpip.chat4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName: Receive
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 10:30:51 PM
 * 
 */
public class Receive implements Runnable
{
	private DataInputStream dis;
	private boolean isRunning = true;

	public Receive(Socket client)
	{
		try
		{
			dis = new DataInputStream(client.getInputStream());
		}
		catch (IOException e)
		{
			e.printStackTrace();
			stop();
		}
	}

	public void stop()
	{
		this.isRunning = false && CloseUtils.close(dis);
	}

	/*
	 * <p>Title: run</p> <p>Description: </p>
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		while (isRunning)
		{
			try
			{
				String msg = dis.readUTF();
				System.out.println("来自聊天室的消息:" + msg);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				stop();
			}
		}
	}

}
