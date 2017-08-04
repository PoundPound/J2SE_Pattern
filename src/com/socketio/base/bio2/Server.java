/**    
 * @Title: Server.java  
 * @Package com.socketio.base.bio1  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:37:33 AM  
 * @version V1.0    
 */
package com.socketio.base.bio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**  
 * @ClassName: Server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:37:33 AM  
 *    
 */
public class Server
{
	public static final int SERVER_PORT = 9876;
	
	public static void main(String[] args)
	{
		ServerSocket server = null;
		try
		{
			server = new ServerSocket(SERVER_PORT);
			System.out.println("Server start ...");
			HandlerExecutorPool pool = new HandlerExecutorPool(50, 100);
			while (true)
			{
				//进行阻塞
				Socket socket = server.accept();
				//线程池执行客户端的任务
				pool.executor(new ServerHandler(socket));
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			CloseUtil.close(server);
		}
	}
}
