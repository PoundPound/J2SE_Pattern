/**    
 * @Title: Server.java  
 * @Package com.socketio.base.nio  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 9:08:19 AM  
 * @version V1.0    
 */
package com.socketio.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


/**  
 * @ClassName: Server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 9:08:19 AM  
 *    
 */
public class Server implements Runnable
{
	// 1.多路复用器（管理所有的通道）
	private Selector selector;
	// 2.建立缓冲区（读写分开）
	private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	
	public Server(int port)
	{
		try
		{
			// 1.打开多路复用器
			selector = Selector.open();
			// 2.打开服务器通道
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			// 3.设置服务器通道为非阻塞模式
			serverSocketChannel.configureBlocking(false);
			// 4.绑定地址
			serverSocketChannel.bind(new InetSocketAddress(port));
			// 5.把服务器通道注册到多路复用器上，并且监听阻塞事件
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			System.out.println("Server start , port: " + port);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	/*  
	 * <p>Title: run</p>  
	 * <p>Description: </p>    
	 * @see java.lang.Runnable#run()  
	 */
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				// 1.必须让多路复用器开始监听
				this.selector.select();
				// 2.返回多路复用器已经选择的结果集
				Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
				// 3.进行遍历
				while (keys.hasNext())
				{
					// 4.获取一个选择的元素
					SelectionKey selectionKey = (SelectionKey) keys.next();
					// 5.直接从容器中移除就可以了
					keys.remove();
					// 6.如果是有效的
					if (selectionKey.isValid())
					{
						// 7.如果为阻塞状态
						if (selectionKey.isAcceptable())
						{
							this.accept(selectionKey);
						}
						// 8.如果为可读取状体
						if (selectionKey.isReadable())
						{
							this.read(selectionKey);
						}
						// 9.如果为可写状态
						if (selectionKey.isWritable())
						{
//							this.write(selectionKey); //serverSocketChannel
						}
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**  
	 * @Title: write  
	 * @Description: TODO  
	 * @param @param selectionKey 
	 * @return void 
	 * @throws  
	 */
	private void write(SelectionKey selectionKey)
	{
		try
		{
			ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
			ssc.register(selector, SelectionKey.OP_WRITE);
		}
		catch (ClosedChannelException e)
		{
			e.printStackTrace();
		}
	}

	/**  
	 * @Title: read  
	 * @Description: TODO  
	 * @param @param selectionKey 
	 * @return void 
	 * @throws  
	 */
	private void read(SelectionKey selectionKey)
	{
		try
		{
			// 1.清空缓冲区旧的数据
			this.readBuffer.clear();
			// 2.获取之前注册的socket通道对象
			SocketChannel sc = (SocketChannel) selectionKey.channel();
			// 3.读取数据
			int count = sc.read(readBuffer);
			// 4.如果没有数据
			if (count == -1)
			{
				selectionKey.channel().close();
				selectionKey.cancel();
				return;
			}
			// 5.有数据则进行读取，读取之前需要进行复位方法（把position和limit进行复位）
			this.readBuffer.flip();
			// 6.根据缓冲区的数据长度，创建相应大小的byte数组，接收缓冲区的数据
			byte[] bytes = new byte[this.readBuffer.remaining()];
			// 7.接收缓冲区数据
			this.readBuffer.get(bytes);
			// 8.打印结果
			String body = new String(bytes).trim();
			System.out.println("Server: " + body);
			
			// 9.可以写回给客户端数据
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**  
	 * @Title: accept  
	 * @Description: TODO  
	 * @param @param selectionKey 
	 * @return void 
	 * @throws  
	 */
	private void accept(SelectionKey selectionKey)
	{
		try
		{
			// 1.获取服务通道
			ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
			// 2.执行阻塞方法
			ssc.accept();
			// 3.设置阻塞模式
			ssc.configureBlocking(false);
			// 4.注册到多路复用器上，并设置读取标示
			ssc.register(selector, SelectionKey.OP_READ);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new Thread(new Server(9876)).start();;
	}
}
