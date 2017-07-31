/**    
 * @Title: Server.java  
 * @Package com.tcpip.chat  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:22:34 PM  
 * @version V1.0    
 */
package com.tcpip.chat1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Server
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:22:34 PM
 * 
 */
public class Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server = new ServerSocket(8888);

			Socket socket = server.accept();
			System.out.println("服务器日志:--有客户端加入--");

			// 客户端-->接收数据
			DataInputStream br = new DataInputStream(socket.getInputStream());
			String msg = br.readUTF();
			System.out.println("服务器日志:收到来自客户端的消息-->:" + msg);

			// 发送数据-->客户端
			DataOutputStream bw = new DataOutputStream(socket.getOutputStream());
			bw.writeUTF("欢迎...");
			bw.flush();

			// 关闭流(服务器不主动关闭)
			// CloseUtils.close(bw, br);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
