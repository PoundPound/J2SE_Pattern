/**    
 * @Title: FileCopyUtils.java  
 * @Package com.io  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 9:14:22 AM  
 * @version V1.0    
 */
package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: FileCopyUtils
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 25, 2017 9:14:22 AM
 * 
 */
public class FileCopyUtils
{
	public static void main(String[] args)
	{
		String srcPath = "test.txt";
		String destPath = "testCopy.txt";
		FileCopyUtils.copyFile(srcPath, destPath);
	}
	
	public static void copyFile(String srcPatht, String destPath)
	{
		File src = new File(srcPatht);
		File dest = new File(destPath);

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);

			byte[] data = new byte[1024];
			int len = 0;
			while ((len = fis.read(data)) != -1)
			{
				fos.write(data, 0, len);
			}
			fos.flush();
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
			try
			{
				fos.close();
				fis.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
