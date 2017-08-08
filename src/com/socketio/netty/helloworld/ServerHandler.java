/**    
 * @Title: ServerHandler.java  
 * @Package com.socketio.netty.helloworld  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:54:08 AM  
 * @version V1.0    
 */
package com.socketio.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**  
 * @ClassName: ServerHandler  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:54:08 AM  
 *    
 */
public class ServerHandler extends ChannelHandlerAdapter
{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "utf8");
		System.out.println("Server: " + body);
		
//		String response = "进行返回给客户端的响应: " + body;
		String response = "Hi, Client!!";
		ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
		//关闭当前通道连接
		//.addListener(ChannelFutureListener.CLOSE)
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		ctx.close();
	}

}
