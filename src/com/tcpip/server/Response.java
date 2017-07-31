/**    
 * @Title: Response.java  
 * @Package com.tcpip.server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 10:29:49 AM  
 * @version V1.0    
 */
package com.tcpip.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * @ClassName: Response
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 3, 2017 10:29:49 AM
 * 
 */
public class Response
{
	public static final int CODE_200 = 200;
	public static final String TEXT_HTML = "text/html";
	public static final String UTF_8 = "utf-8";

	private static final String CRLF = "\r\n";
	private static final String BLANK = " ";

	private StringBuilder head;
	private StringBuilder context;
	private BufferedWriter br;
	private int len;

	public Response()
	{
		head = new StringBuilder();
		context = new StringBuilder();
		len = 0;
	}

	public Response(OutputStream os)
	{
		this();
		this.br = new BufferedWriter(new OutputStreamWriter(os));
	}

	private void init(int code, String type, String encoding)
	{
		// 1.协议版本 状态代码 描述
		head.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch (code)
		{
			case 200:
				head.append("ok");
				break;
			case 404:
				head.append("NOT FOUND");
				break;
			case 500:
				head.append("SERVER ERROR");
				break;
			default:
				head.append("SERVER ERROR");
				break;
		}
		head.append(CRLF);
		// 2.响应头
		head.append("Server:Apache Tomcat/8.0.23").append(CRLF);
		head.append("Date:").append(new Date()).append(CRLF);
		head.append("Context-type:" + type + ";charset=" + encoding).append(CRLF);
	}

	public void print(String str)
	{
		context.append(str);
		len += context.length();
	}

	public void println(String str)
	{
		context.append(str).append(CRLF);
		len += context.length();
	}

	public void respond(int code, String type, String encoding)
	{
		init(code, type, encoding);
		// 3.正文长度
		head.append("Context-Length:").append(len).append(CRLF);
		// 4.正文之前
		head.append(CRLF);
		// 5.正文
		head.append(context.toString());

		try
		{
			br.write(head.toString());
			br.flush();
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
