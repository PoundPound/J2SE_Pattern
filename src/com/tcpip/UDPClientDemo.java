/**    
 * @Title: UDPClientDemo.java  
 * @Package com.tcpip  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 29, 2017 10:29:14 AM  
 * @version V1.0    
 */
package com.tcpip;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @ClassName: UDPClientDemo
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 29, 2017 10:29:14 AM
 * 
 */
public class UDPClientDemo
{
	public static void main(String[] args)
	{
		try
		{
			// 1.创建服务器 类+指定端口
			DatagramSocket client = new DatagramSocket(8889);
			// 2.准备发送容器 字节数组
			// String msg = "this is message!";
			// byte[] buf = msg.getBytes();

			byte[] buf = convert(78.12);

			// 3.封装成包 DatagramPacket(byte buf[], int length, SocketAddress
			// address)
			DatagramPacket p = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 8888));
			// 4.发送
			client.send(p);
			// 5.释放资源
			client.close();
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static byte[] convert(double d)
	{

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try
		{
			dos.writeDouble(d);
			dos.close();
			return bos.toByteArray();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
