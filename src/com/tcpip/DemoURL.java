/**    
 * @Title: DemoURL.java  
 * @Package com.ip  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 29, 2017 10:07:28 AM  
 * @version V1.0    
 */
package com.tcpip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName: DemoURL
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 29, 2017 10:07:28 AM
 * 
 */
public class DemoURL
{
	public static void main(String[] args)
	{
		try
		{
			URL url = new URL("http://www.baidu.com");

			InputStream is = url.openStream();
			/*byte[] cbuf = new byte[1024];
			int len = 0;
			while ((len = is.read(cbuf)) != -1)
			{
				System.out.println(new String(cbuf, 0, len));
			}
			is.close();*/
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String msg = null;
			while ((msg = br.readLine()) != null)
			{
				System.out.println(msg);
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
