/**    
 * @Title: CloseUtil.java  
 * @Package com.socketio.base.bio1  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:55:36 AM  
 * @version V1.0    
 */
package com.socketio.base.bio1;

import java.io.Closeable;
import java.io.IOException;

/**  
 * @ClassName: CloseUtil  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 3, 2017 9:55:36 AM  
 *    
 */
public class CloseUtil
{
	public static boolean close(Closeable... closeables)
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
//					e.printStackTrace();
					System.out.println("关闭流失败!");
					return false;
				}
			}
		}
		return true;
	}
}
