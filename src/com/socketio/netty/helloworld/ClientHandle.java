/**    
 * @Title: ClientHandle.java  
 * @Package com.socketio.netty.helloworld  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:53:35 AM  
 * @version V1.0    
 */
package com.socketio.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**  
 * @ClassName: ClientHandle  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 8, 2017 10:53:35 AM  
 *    
 */
public class ClientHandle extends ChannelHandlerAdapter
{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		try
		{
			ByteBuf buf = (ByteBuf) msg;
			byte[] req = new byte[buf.readableBytes()];
			buf.readBytes(req);
			String body = new String(req, "utf8");
			System.out.println("Client: " + body);
		}
		finally
		{
			//用完必须释放不然会有position指针问题，如果有写操作,则不用释放,write会自动释放
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{
		ctx.close();
	}

}
