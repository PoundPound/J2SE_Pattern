/**    
 * @Title: DemoByteArrayInputAndOutputAndFileStream.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 10:28:44 AM  
 * @version V1.0    
 */
package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName: DemoByteArrayInputAndOutputAndFileStream
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 10:28:44 AM
 * 
 */
public class DemoByteArrayInputAndOutputAndFileStream
{
	public static void main(String[] args)
	{
		String src = "test.txt";
		String dest = "testCopy2.txt";
		
		byte[] data = read(src);
		System.out.println(new String(data, 0, data.length));
		write(data, dest);
	}
	
	public static byte[] read(String srcPath)
	{
		byte[] result = null;
		File file = new File(srcPath);
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try
		{
			is = new BufferedInputStream(new FileInputStream(file));
			baos = new ByteArrayOutputStream();

			byte[] buf = new byte[1024];
			int len = 0;
			while (-1 != (len = is.read(buf, 0, buf.length)))
			{
				baos.write(buf, 0, len);
			}
			baos.flush();
			result = baos.toByteArray();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (baos != null)
			{
				try
				{
					baos.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void write(byte[] info, String destPath)
	{
		InputStream is = null;
		OutputStream os = null;

		File file = new File(destPath);

		try
		{
			is = new BufferedInputStream(new ByteArrayInputStream(info));
			os = new BufferedOutputStream(new FileOutputStream(file));

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = is.read(buf, 0, buf.length)) != -1)
			{
				os.write(buf, 0, len);
			}
			os.flush();
		}
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (os != null)
			{
				try
				{
					os.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
