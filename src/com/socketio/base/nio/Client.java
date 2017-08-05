/**    
 * @Title: Client.java  
 * @Package com.socketio.base.nio  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 9:47:16 AM  
 * @version V1.0    
 */
package com.socketio.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**  
 * @ClassName: Client  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 9:47:16 AM  
 *    
 */
public class Client
{
	public static void main(String[] args)
	{
		// 创建连接的地址
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9876);
		// 声明连接通道
		SocketChannel socketChannel = null;
		// 建立缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		try
		{
			// 打开通道
			socketChannel = SocketChannel.open();
			// 进行连接
			socketChannel.connect(address);
			System.out.println(socketChannel.isConnected());
			/*while (true)
			{
				// 定义一个字节数组，然后使用系统录入功能
				byte[] bytes = new byte[1024];
				System.in.read(bytes);
				
				// 把数据放到缓冲区中
				buffer.put(bytes);
				// 对缓冲区进行复位 
				buffer.flip();
				// 写出数据
				socketChannel.write(buffer);
				// 清空缓冲区数据
				buffer.clear();
			}*/
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (socketChannel != null)
			{
				try
				{
					socketChannel.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
