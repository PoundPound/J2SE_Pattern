/**    
 * @Title: DemoByteArrayInputStream.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 10:08:45 AM  
 * @version V1.0    
 */
package com.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**  
 * @ClassName: DemoByteArrayInputStream  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 10:08:45 AM  
 *    
 */
public class DemoByteArrayInputStream
{
	public static void main(String[] args)
	{
		read();
	}
	
	public static void read()
	{
		String str = "测试字节数组输入流";
		byte[] date = str.getBytes();
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(date));
		
		byte[] b = new byte[1024];
		int len = 0;
		try
		{
			while ((len = is.read(b, 0, b.length)) != -1)
			{
				System.out.println(new String(b, 0, len));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
