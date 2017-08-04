/**    
 * @Title: ServerHandler.java  
 * @Package com.socketio.base.bio1  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:41:49 AM  
 * @version V1.0    
 */
package com.socketio.base.bio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**  
 * @ClassName: ServerHandler  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:41:49 AM  
 *    
 */
public class ServerHandler implements Runnable
{
	private Socket socket;
	
	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>    
	 */
	public ServerHandler(Socket socket)
	{
		this.socket = socket;
	}

	/*  
	 * <p>Title: run</p>  
	 * <p>Description: </p>    
	 * @see java.lang.Runnable#run()  
	 */
	@Override
	public void run()
	{
		BufferedReader in = null;
		PrintStream out = null;
		
		try
		{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
			out = new PrintStream(socket.getOutputStream(), true);
			
			while (true)
			{
				String response = in.readLine();
				if (response == null)
				{
					break;
				}
				System.out.println("Server{get data from client}:[" + response  + "]");
				out.println("send data to client ...");
			}
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
