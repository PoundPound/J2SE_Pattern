/**    
 * @Title: CloseUtils.java  
 * @Package com.tcpip.chat  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:40:07 PM  
 * @version V1.0    
 */
package com.tcpip.chat1;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName: CloseUtils
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 1, 2017 9:40:07 PM
 * 
 */
public class CloseUtils
{
	public static void close(Closeable... closeables)
	{
		for (Closeable closeable : closeables)
		{
			if (closeable != null)
			{
				try
				{
					closeable.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
					System.out.println("关闭流失败");
				}
			}
		}
	}
}
