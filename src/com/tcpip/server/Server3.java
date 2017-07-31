/**    
 * @Title: Server.java  
 * @Package com.tcpip.server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 8:14:57 AM  
 * @version V1.0    
 */
package com.tcpip.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName: Server
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 8:14:57 AM
 * 
 */
public class Server3
{
	private ServerSocket server;
	private boolean flag;

	private static final String CRLF = "\r\n";
	private static final String BLANK = " ";

	public Server3()
	{
	}

	public Server3(int port)
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
			byte[] buf = new byte[20480];
			int len = client.getInputStream().read(buf);

			System.out.println(new String(buf, 0, len));

			StringBuilder responceContext = new StringBuilder();
			responceContext.append("<html><meta charset=\"UTF-8\"><head><title>HTTP响应示例</title></head><body><p>responded!</p></body></html>");

			StringBuilder responce = new StringBuilder();
			//1.协议版本 状态代码 描述
			responce.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
			//2.响应头
			responce.append("Server:Apache Tomcat/8.0.23").append(CRLF);
			responce.append("Date:").append(new Date()).append(CRLF);
			responce.append("Context-type:text/html;charset=utf-8").append(CRLF);
			//3.正文长度
			responce.append("Context-Length:").append((responceContext.toString()).getBytes().length).append(CRLF);
			//4.正文之前
			responce.append(CRLF);
			//5.正文
			responce.append(responceContext.toString());
			
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			br.write(responce.toString());
			br.flush();
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
	{
		Server3 server = new Server3(8888);
		server.receive();
	}
}
