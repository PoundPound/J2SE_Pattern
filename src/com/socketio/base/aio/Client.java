/**    
 * @Title: Client.java  
 * @Package com.socketio.base.aio  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 11:16:34 PM  
 * @version V1.0    
 */
package com.socketio.base.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**  
 * @ClassName: Client  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 5, 2017 11:16:34 PM  
 *    
 */
public class Client implements Runnable
{
	private AsynchronousSocketChannel asc;
	private String server;
	private int port;

	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>    
	 * @throws IOException 
	 */
	public Client(String server, int port) throws IOException
	{
		asc = AsynchronousSocketChannel.open();
		this.server = server;
		this.port = port;
	}

	public void connect()
	{
		asc.connect(new InetSocketAddress(this.server, this.port));
	}
	
	public void write(String request)
	{
		try
		{
			asc.write(ByteBuffer.wrap(request.getBytes())).get();
			read();
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
	
	/**  
	 * @Title: read  
	 * @Description: TODO  
	 * @param  
	 * @return void 
	 * @throws  
	 */
	public void read()
	{
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try
		{
			asc.read(buffer).get();
			buffer.flip();
			byte[] responseByte = new byte[buffer.remaining()];
			buffer.get(responseByte);
			System.out.println(new String(responseByte, "utf8").trim());
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
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
			
		}
	}

	public static void main(String[] args) throws IOException
	{
		String server = "127.0.0.1";
		int port = 9876;
		
		Client c1 = new Client(server, port);
		Client c2 = new Client(server, port);
		Client c3 = new Client(server, port);
		
		c1.connect();
		c2.connect();
		c3.connect();
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		c1.write("c1 aaa");
		c2.write("c2 cccc");
		c3.write("c3 bbbbb");
	}
}
