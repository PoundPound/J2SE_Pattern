/**    
 * @Title: Server.java  
 * @Package com.socketio.netty.helloworld  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:16:32 AM  
 * @version V1.0    
 */
package com.socketio.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**  
 * @ClassName: Server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:16:32 AM  
 *    
 */
public class Server
{
	public static void main(String[] args) throws InterruptedException
	{
		EventLoopGroup pGroup = new NioEventLoopGroup();			// 1.一个是用于处理服务器端接收客户端连接
		EventLoopGroup cGroup = new NioEventLoopGroup();			// 一个是进行网络通信的（网络读写的）
		ServerBootstrap bootstrap = new ServerBootstrap();			// 2.创建辅助工具类，用于服务器通道的一系列配置
		bootstrap.group(pGroup, cGroup)								// 绑定两个线程组
			.channel(NioServerSocketChannel.class)					// 指定NIO的模式
			.option(ChannelOption.SO_BACKLOG, 1024)					// 设置TCP缓冲区
			.option(ChannelOption.SO_SNDBUF, 32 * 1024)				// 设置发送缓冲大小
			.option(ChannelOption.SO_RCVBUF, 32 * 1024)				// 设置接收缓冲大小
			.option(ChannelOption.SO_KEEPALIVE, true)				// 保持连接（默认为true）
			.childHandler(new ChannelInitializer<SocketChannel>()
			{
				@Override
				protected void initChannel(SocketChannel sc) throws Exception
				{
					sc.pipeline().addLast(new ServerHandler());		// 3.在这里配置具体数据接收方法的处理(可以加入多个handler)
				}
			});
		
		System.out.println("Server start...");
		ChannelFuture cf = bootstrap.bind(9876).sync();				// 4.进行绑定(可以绑定多个)
//		ChannelFuture cf2 = bootstrap.bind(9875).sync();
//		cf2.channel().closeFuture().sync();
		
		//与Thread.sleep(Integer.MAX_VALUE)功能一样
		cf.channel().closeFuture().sync();							// 5.等待关闭
		
		pGroup.shutdownGracefully();								// 6.释放资源
		cGroup.shutdownGracefully();
	}
}
