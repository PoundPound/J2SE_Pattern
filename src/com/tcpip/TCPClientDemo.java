/**    
 * @Title: TCPClientDemo.java  
 * @Package com.tcpip  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 30, 2017 9:42:05 PM  
 * @version V1.0    
 */
package com.tcpip;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName: TCPClientDemo
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 30, 2017 9:42:05 PM
 * 
 */
public class TCPClientDemo
{
	public static void main(String[] args)
	{
		try
		{
			Socket client = new Socket("127.0.0.1", 8888);

			client.getOutputStream();
			String msg = "client send messags";

			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
			dos.close();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
