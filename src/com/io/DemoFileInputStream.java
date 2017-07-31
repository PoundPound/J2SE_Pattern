/**    
 * @Title: DemoFileInputStream.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 6:31:19 AM  
 * @version V1.0    
 */
package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName: DemoFileInputStream
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 6:31:19 AM
 * 
 */
public class DemoFileInputStream
{
	public static void main(String[] args)
	{
		// 1.建立连接
		File file = new File("test.txt");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		// 2.选择流
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			// 3.操作 缓冲数组 + read()
			byte[] data = new byte[1024];
			// 接收实际读取大小
			int len = 0;
			// 操作不断读取缓冲数组
			while ((len = fis.read(data)) != -1)
			{
				// 输出字节数组转字符串
				String str = new String(data, 0, len);
				System.out.println(str);
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			if (fis != null)
			{
				try
				{
					// 4.释放资源
					fis.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
