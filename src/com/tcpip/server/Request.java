/**    
 * @Title: Request.java  
 * @Package com.tcpip.server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 11:04:17 AM  
 * @version V1.0    
 */
package com.tcpip.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Request
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 11:04:17 AM
 * 
 */
public class Request
{
	private static final String CRLF = "\r\n";
	private static final String BLANK = " ";
	private static final String PROTOCOL = "HTTP/";

	private String request;
	private int len;
	private Map<String, List<String>> parameters;
	private InputStream in;

	public Request()
	{
		request = "";
		len = 0;
	}

	public Request(InputStream in)
	{
		this();
		this.in = in;
		parameters = new HashMap<String, List<String>>();
		this.requestParser();
	}

	private void requestParser()
	{
		try
		{
			byte[] buf = new byte[20480];
			len = in.read(buf);
			request = new String(buf, 0, len);

			String firstLine = request.substring(0, request.indexOf(CRLF));
			String method = firstLine.substring(0, firstLine.indexOf(BLANK));
			String url = firstLine.substring(request.indexOf(BLANK + "/") + 1, request.indexOf(PROTOCOL) - 1);

			if (method.equalsIgnoreCase("get"))
			{
				if (url.contains("?"))
				{
					String[] params = url.split("&");
					split(params);
				}
			}
			else if (method.equalsIgnoreCase("post"))
			{
				String context = request.substring(request.lastIndexOf(CRLF) + 2, request.length());
				String[] params = context.split("&");
				split(params);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void split(String[] params)
	{
		for (int i = 0; i < params.length; i++)
		{
			String key = params[i].split("=")[0];
			String value = params[i].split("=")[1];
			if (parameters.get(key) != null)
			{
				parameters.get(key).add(value);
			}
			else
			{
				List<String> list = new ArrayList<String>();
				list.add(value);
				parameters.put(key, list);
			}
		}
	}

	public Map<String, List<String>> getParameters()
	{
		return parameters;
	}

	public Set<String> getKeys()
	{
		return parameters.keySet();
	}

	public List<String> getValues(String key)
	{
		return parameters.get(key);
	}
}