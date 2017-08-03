/**    
 * @Title: Client.java  
 * @Package com.socketio.base.bio1  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:37:43 AM  
 * @version V1.0    
 */
package com.socketio.base.bio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**  
 * @ClassName: Client  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:37:43 AM  
 *    
 */
public class Client
{
	private static final String SERVER_ADDRESS = "127.0.0.1";
	private static final int SERVER_PORT = 9876;
	
	/**  
	 * @Title: main  
	 * @Description: TODO  
	 * @param @param args 
	 * @return void 
	 * @throws  
	 */
	public static void main(String[] args)
	{
		Socket socket = null;
		BufferedReader in = null;
		PrintStream out = null;
		try
		{
			socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf8"));
			out = new PrintStream(socket.getOutputStream(), true);
			
			//向服务器发送数据
			out.println("send data to server ...");
			String response = in.readLine();
			System.out.println("Client{get data from server}:[" + response  + "]");
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			CloseUtil.close(out, in, socket);
		}
	}

}
