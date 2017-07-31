/**    
 * @Title: DemoFileOutputStream.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 6:31:35 AM  
 * @version V1.0    
 */
package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: DemoFileOutputStream
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 6:31:35 AM
 * 
 */
public class DemoFileOutputStream
{
	public static void main(String[] args)
	{
		// 1.建立连接
		File file = new File("test.txt");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		// 2.选择流
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file, true);
			// 3.操作
			// 数据大小
			String str = "just test FileOutputStream \r\n";
			byte[] data = str.getBytes();
			// 执行操作
			fos.write(data, 0, data.length);

			// 强制刷新出去（因为流相当于一根管道，管道没有满里面的内容不出去，满了之后会不断推出去）
			fos.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("文件未找到");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("写数据操作失败");
		}
		finally
		{
			if (fos != null)
			{
				try
				{
					//4.释放资源
					//close()之前会调用flush()
					fos.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
