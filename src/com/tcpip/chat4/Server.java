/**    
 * @Title: Server.java  
 * @Package com.tcpip.chat  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:22:34 PM  
 * @version V1.0    
 */
package com.tcpip.chat4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Server
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:22:34 PM
 * 
 */
public class Server
{
	private ServerSocket server;
	private List<MyChannel> clients;

	public Server()
	{
		clients = new ArrayList<MyChannel>();
	}

	public Server(ServerSocket server)
	{
		this();
		this.server = server;
	}

	public void start()
	{
		MyChannel channel = null;
		try
		{
			while (true)
			{
				Socket socket = server.accept();
				channel = new MyChannel(socket);
				clients.add(channel);
				new Thread(channel).start();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private class MyChannel implements Runnable
	{
		private String name;
		private Socket socket;
		private DataInputStream br;
		private DataOutputStream bw;
		private boolean isRunning = true;

		public void stop()
		{
			this.isRunning = false && CloseUtils.close(bw, br);
		}

		public MyChannel(Socket socket)
		{
			this.socket = socket;
			try
			{
				br = new DataInputStream(socket.getInputStream());
				bw = new DataOutputStream(socket.getOutputStream());
				name = br.readUTF();
				System.out.println("服务器日志:---有客户端(" + name + ")加入---");
				send("欢迎进入聊天室:" + name);
				sendOthers(name + "-->进入了聊天室");
			}
			catch (IOException e)
			{
				e.printStackTrace();
				stop();
			}
		}

		public void send(String msg)
		{
			try
			{
				// 发送数据-->客户端
				bw.writeUTF(msg);
				bw.flush();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				stop();
			}
		}

		public String Receive()
		{
			String msg = "";
			try
			{
				// 客户端-->接收数据
				msg = br.readUTF();
				System.out.println("服务器日志:收到来自客户端的消息-->:" + msg);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				stop();
				clients.remove(this);
			}
			return msg;
		}

		public void sendOthers(String msg)
		{
			for (MyChannel otherClient : clients)
			{
				if (otherClient.equals(this))
				{
					continue;
				}

				if (msg.contains("@") && msg.contains(":"))
				{
					String currentUser = msg.substring(msg.indexOf("(") + 1, msg.indexOf(")"));
					String sendName = msg.substring(msg.indexOf("@") + 1, msg.indexOf(":"));
					String sendMsg = msg.substring(msg.indexOf(":") + 1);
					if (otherClient.name.equals(sendName))
					{
						otherClient.send("(" + currentUser + ")对你悄悄的说:" + sendMsg);
					}
				}
				else
				{
					otherClient.send(msg);
				}
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
				sendOthers(Receive());
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Server server = new Server(new ServerSocket(8888));
			server.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
