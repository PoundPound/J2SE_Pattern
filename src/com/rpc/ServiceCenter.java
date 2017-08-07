/**    
 * @Title: ServiceCenter.java  
 * @Package com.rpc  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:35:56 AM  
 * @version V1.0    
 */
package com.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @ClassName: ServiceCenter  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:35:56 AM  
 *    
 */
public class ServiceCenter implements Server
{
	private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	private static final HashMap<String, Class<?>> serviceRegistry = new HashMap<String, Class<?>>();
	
	private static boolean isRunning = false;
	
	private static int port;
	
	public ServiceCenter(int port)
	{
		this.port = port;
	}
	
	/*  
	 * <p>Title: stop</p>  
	 * <p>Description: </p>    
	 * @see com.rpc.Server#stop()  
	 */
	@Override
	public void stop()
	{
		isRunning = false;
		executor.shutdown();
	}

	/*  
	 * <p>Title: start</p>  
	 * <p>Description: </p>  
	 * @throws IOException  
	 * @see com.rpc.Server#start()  
	 */
	@Override
	public void start() throws IOException
	{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(port));
		System.out.println("start server");

		try
		{
			while (true)
			{
				// 1.监听客户端的TCP连接，接到TCP连接后将其封装成task，由线程池执行
				executor.execute(new ServiceTask(server.accept()));
			}
		}
		finally
		{
			server.close();
		}
	}

	/*  
	 * <p>Title: register</p>  
	 * <p>Description: </p>  
	 * @param serviceInterface
	 * @param impl  
	 * @see com.rpc.Server#register(java.lang.Class, java.lang.Class)  
	 */
	@Override
	public void register(Class<?> serviceInterface, Class<?> impl)
	{
		serviceRegistry.put(serviceInterface.getName(), impl);
	}

	/*  
	 * <p>Title: isRunning</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.rpc.Server#isRunning()  
	 */
	@Override
	public boolean isRunning()
	{
		return isRunning;
	}

	/*  
	 * <p>Title: getPort</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.rpc.Server#getPort()  
	 */
	@Override
	public int getPort()
	{
		return port;
	}

	private static class ServiceTask implements Runnable
	{
		Socket client = null;
		
		ServiceTask(Socket client)
		{
			this.client = client;
		}
		
		/*  
		 * <p>Title: run</p>  
		 * <p>Description: </p>    
		 * @see java.lang.Runnable#run()  
		 */
		@Override
		public void run()
		{
			ObjectInputStream input = null;
			ObjectOutputStream output = null;
			try
			{
				// 2.将客户端发送的码流反序列化成对象，反射调用服务实现者，获取执行结果
				input = new ObjectInputStream(client.getInputStream());
				String serviceName = input.readUTF();
				String methodName = input.readUTF();
				Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
				Object[] arguments = (Object[]) input.readObject();
				Class<?> serviceClass = serviceRegistry.get(serviceName);
				if (serviceClass == null)
				{
					throw new ClassNotFoundException(serviceName + " not found");
				}
				Method method = serviceClass.getMethod(methodName, parameterTypes);
				Object result = method.invoke(serviceClass.newInstance(), arguments);

				// 3.将执行结果反序列化，通过socket发送给客户端
				output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(result);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				CloseUtil.close(output, input, client);
			}
		}

	}
}
