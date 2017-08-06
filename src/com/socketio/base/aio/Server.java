/**    
 * @Title: Server.java  
 * @Package com.socketio.base.aio  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 11:16:25 PM  
 * @version V1.0    
 */
package com.socketio.base.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @ClassName: Server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 11:16:25 PM  
 *    
 */
public class Server
{
	// 线程池
	private ExecutorService executor;  
	// 线程组
	private AsynchronousChannelGroup threadGroup;
	// 服务器通道
	AsynchronousServerSocketChannel assc;

	public Server(int port)
	{
		try
		{
			// 创建一个缓存池
			executor = Executors.newCachedThreadPool();
			// 创建线程组
			threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executor, 1);
			// 创建服务器通道
			assc = AsynchronousServerSocketChannel.open(threadGroup);
			// 进行绑定
			assc.bind(new InetSocketAddress(port));
			
			System.out.println("Server start , port : " + port);
			// 进行阻塞
			assc.accept(this, new ServerCompletionHandler());
			// 一直阻塞，不让服务器停止
			Thread.sleep(Integer.MAX_VALUE);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Server server = new Server(9876);
	}
}
