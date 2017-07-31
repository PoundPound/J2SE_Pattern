/**    
 * @Title: DirtyRead.java  
 * @Package com.concurrent.sync04  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 3:40:24 AM  
 * @version V1.0    
 */
package com.concurrent.base.sync04;

/**  
 * @ClassName: DirtyRead  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 15, 2017 3:40:24 AM  
 *    
 */

/**
 * 业务整体需要使用完整的synchronized，保持业务的原子性
 *
 */
public class DirtyRead
{
	private String username = "user";
	private String password = "passwd";
	
	public synchronized void setValue(String username, String password)
	{
		this.username = username;
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		this.password = password;
		
		System.out.println("setValue最终结果: username = " + username + ",password = " + password);
	}
	
	/**
	 * synchronized
	 */
	public synchronized void getValue()
	{
		System.out.println("getValue方法得到: username = " + username + ",password = " + password);
	}
	
	public static void main(String[] args)
	{
		final DirtyRead dr = new DirtyRead();
		
		Thread t1 = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				dr.setValue("u001", "p001");
			}
		});
		
		t1.start();
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		dr.getValue();
	}
}
