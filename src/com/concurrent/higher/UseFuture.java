/**    
 * @Title: UseFuture.java  
 * @Package com.concurrent.higher  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 2, 2017 9:07:37 AM  
 * @version V1.0    
 */
package com.concurrent.higher;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**  
 * @ClassName: UseFuture  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 2, 2017 9:07:37 AM  
 *    
 */
public class UseFuture implements Callable<String>
{
	private String param; 
	
	public UseFuture(String param)
	{
		this.param = param;
	}

	/*  
	 * <p>Title: call</p>  
	 * <p>Description: </p>  
	 * @return
	 * @throws Exception  
	 * @see java.util.concurrent.Callable#call()  
	 */
	@Override
	public String call() throws Exception
	{
		//模拟执行耗时
		Thread.sleep(3000);
		String result = this.param + "处理完成";
		return result;
	}
	
	//主控函数
	public static void main(String[] args) throws Exception
	{
		String queryStr = "query";
		//构造FutureTask，并且传入需要真正进行业务逻辑处理的类，该类一定是实现了Callable接口的类
		FutureTask<String> task = new FutureTask<String>(new UseFuture(queryStr));
		//创建一个固定线程的线程池，并且线程数为1
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//这里提交任务future，则开启线程执行RealData的call()方法执行
		//submit和execute的区别：第一点是submit可以传入实现Callable接口的实例对象，第二点是submit方法有返回值
		Future future = executor.submit(task);
		System.out.println("请求完毕");
		
		//这里可以做额外的数据操作，也就是主程序执行其他的业务逻辑
		Thread.sleep(1000);
		
		//调用获取数据方法，如果call()方法没有执行完成，则依然会进行等待
		System.out.println("数据:" + future.get());
		
		executor.shutdown();
	}
}
