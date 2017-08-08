/**    
 * @Title: Client.java  
 * @Package com.socketio.netty.helloworld  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:16:39 AM  
 * @version V1.0    
 */
package com.socketio.netty.helloworld;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**  
 * @ClassName: Client  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:16:39 AM  
 *    
 */
public class Client
{
	public static void main(String[] args) throws Exception
	{
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ChannelInitializer<SocketChannel>()
			{
				@Override
				protected void initChannel(SocketChannel sc) throws Exception
				{
					sc.pipeline().addLast(new ClientHandle());
				}
			});
		
		ChannelFuture cf = bootstrap.connect("127.0.0.1", 9876).sync();
//		ChannelFuture cf2 = bootstrap.connect("127.0.0.1", 9875).sync();
		
		String msg = "Hi, Netty!!";
		cf.channel().writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
//		cf2.channel().writeAndFlush(Unpooled.copiedBuffer("Hi, world!!".getBytes()));
		
		//在ServerHandler端调用了.addListener(ChannelFutureListener.CLOSE),则会执行到这,进行关闭
		cf.channel().closeFuture().sync();
//		cf2.channel().closeFuture().sync();
		
		group.shutdownGracefully();
	}
}
