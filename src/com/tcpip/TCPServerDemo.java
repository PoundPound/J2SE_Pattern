/**    
 * @Title: TCPServerDemo.java  
 * @Package com.tcpip  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 30, 2017 9:42:24 PM  
 * @version V1.0    
 */
package com.tcpip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: TCPServerDemo
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 30, 2017 9:42:24 PM
 * 
 */
public class TCPServerDemo
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server = new ServerSocket(8888);
			Socket socket = server.accept();
			System.out.println("client join ...");
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			System.out.println(dis.readUTF());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
