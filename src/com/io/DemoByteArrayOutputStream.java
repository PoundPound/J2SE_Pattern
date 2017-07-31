/**    
 * @Title: DemoByteArrayOutputStream.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 10:16:41 AM  
 * @version V1.0    
 */
package com.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @ClassName: DemoByteArrayOutputStream
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 10:16:41 AM
 * 
 */
public class DemoByteArrayOutputStream
{
	public static void main(String[] args)
	{
		write();
	}

	public static void write()
	{
		String msg = "测试字节数组输出流";
		byte[] b = msg.getBytes();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(b, 0, b.length);
		byte[] output = bos.toByteArray();
		try
		{
			bos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(new String(output, 0, output.length));
	}
}
