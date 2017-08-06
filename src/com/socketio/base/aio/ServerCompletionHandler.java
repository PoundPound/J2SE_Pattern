/**    
 * @Title: ServerCompletionHandler.java  
 * @Package com.socketio.base.aio  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 11:23:28 PM  
 * @version V1.0    
 */
package com.socketio.base.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**  
 * @ClassName: ServerCompletionHandler  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 11:23:28 PM  
 *    
 */
public class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Server>
{

	/*  
	 * <p>Title: completed</p>  
	 * <p>Description: </p>  
	 * @param result
	 * @param attachment  
	 * @see java.nio.channels.CompletionHandler#completed(java.lang.Object, java.lang.Object)  
	 */
	@Override
	public void completed(AsynchronousSocketChannel asc, Server attachment)
	{
		// 当有下一个客户端接入的时候,直接调用Server的accept()方法,这样反复执行下去,保证多个客户端都可以阻塞
		attachment.assc.accept(attachment, this);
		read(asc);
	}

	/**  
	 * @Title: read  
	 * @Description: TODO  
	 * @param @param result 
	 * @return void 
	 * @throws  
	 */
	private void read(final AsynchronousSocketChannel asc)
	{
		// 读取数据
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		asc.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>()
		{

			@Override
			public void completed(Integer resultSize, ByteBuffer attachment)
			{
				// 进行读取之后,重置标示位
				attachment.flip();
				// 获得读取的字节数
				System.out.println("Server -> 收到客户端的数据长度为:" + resultSize);
				// 获得读取的数据
				String resultData = new String(attachment.array()).trim();
				System.out.println("Server -> 收到客户端的数据信息为:" + resultData);
				String response = "服务器响应,收到了客户端发来的数据:" + resultData;
				write(asc, response);
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment)
			{
				exc.printStackTrace();
			}
		});
	}

	/**  
	 * @Title: write  
	 * @Description: TODO  
	 * @param @param asc
	 * @param @param response 
	 * @return void 
	 * @throws  
	 */
	private void write(AsynchronousSocketChannel asc, String response)
	{
		try
		{
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(response.getBytes());
			buffer.flip();
			asc.write(buffer).get();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}
	}

	/*  
	 * <p>Title: failed</p>  
	 * <p>Description: </p>  
	 * @param exc
	 * @param attachment  
	 * @see java.nio.channels.CompletionHandler#failed(java.lang.Throwable, java.lang.Object)  
	 */
	@Override
	public void failed(Throwable exc, Server attachment)
	{
		exc.printStackTrace();
	}
}
