/**    
 * @Title: UDPServerDemo.java  
 * @Package com.tcpip  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 29, 2017 10:29:39 AM  
 * @version V1.0    
 */
package com.tcpip;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName: UDPServerDemo
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 29, 2017 10:29:39 AM
 * 
 */
public class UDPServerDemo
{
	public static void main(String[] args)
	{

		try
		{
			// 1.创建服务器 类+指定端口
			DatagramSocket server = new DatagramSocket(8888);
			// 2.准备接收容器 字节数组
			byte[] buf = new byte[1024];
			// 3.封装成包 DatagramPacket(byte buf[], int length)
			DatagramPacket p = new DatagramPacket(buf, buf.length);
			// 4.接收数据
			server.receive(p);
			// 5.分析
			byte[] data = p.getData();
//			int len = p.getLength();
//			System.out.println(new String(data, 0, len));

			System.out.println(convert(data));
			// 6.释放资源
			server.close();
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

	public static double convert(byte[] b)
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(bais));
		try
		{
			return dis.readDouble();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return Double.NaN;
	}
}
