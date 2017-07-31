/**    
 * @Title: Sen.java  
 * @Package com.tcpip.chat2  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 10:30:16 PM  
 * @version V1.0    
 */
package com.tcpip.chat4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * @ClassName: Sen
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 10:30:16 PM
 * 
 */
public class Send implements Runnable
{
	private String name;
	private BufferedReader br;
	private DataOutputStream bw;
	private boolean isRunning = true;

	public Send()
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			stop();
		}
	}

	public Send(Socket client)
	{
		this();
		try
		{
			bw = new DataOutputStream(client.getOutputStream());
		}
		catch (IOException e)
		{
			e.printStackTrace();
			stop();
		}
	}

	public Send(Socket client, String name)
	{
		this(client);
		this.name = name;
		send(name, true);
	}

	public void stop()
	{
		this.isRunning = false && CloseUtils.close(bw, br);
	}

	public void send(String msg)
	{
		try
		{
			bw.writeUTF(msg);
			bw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			stop();
		}
	}

	public void send(String msg, boolean flag)
	{
		if (flag)
		{
			this.send(msg);
		}
		else
		{
			this.send("(" + this.name + ")说-->" + msg);
		}
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
				// System.out.println("请输入发送内容...");
				String msg = br.readLine();
				send(msg, false);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				stop();
			}

		}
	}
}
