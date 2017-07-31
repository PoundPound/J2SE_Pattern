/**    
 * @Title: Client.java  
 * @Package com.tcpip.chat  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:29:43 PM  
 * @version V1.0    
 */
package com.tcpip.chat1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			// 构造器一执行就与服务器进行连接
			Socket client = new Socket("127.0.0.1", 8888);

			// 从控制台接收
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			System.out.println("请输入...");
			String msg = in.readLine();

			// 发送数据给服务器
			DataOutputStream bw = new DataOutputStream(client.getOutputStream());
			bw.writeUTF(msg);
			bw.flush();

			// 从服务器接收数据
			DataInputStream br = new DataInputStream(client.getInputStream());
			String response = br.readUTF();
			System.out.println("客户端日志:收到来自服务器的消息-->:" + response);

			// 关闭流
			CloseUtils.close(in, bw, br);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
