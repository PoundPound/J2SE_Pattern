/**    
 * @Title: MyThread.java  
 * @Package com.concurrent.demo01  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 14, 2017 10:35:45 PM  
 * @version V1.0    
 */
package com.concurrent.base.sync01;

/**
 * @ClassName: MyThread
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 14, 2017 10:35:45 PM
 * 
 */
public class MyThread extends Thread
{
	private int count = 10;

	@Override
	public synchronized void run()//synchronized
	{
		count--;
		System.out.println(this.currentThread().getName() + " count=" + count);
	}

	public static void main(String[] args)
	{
		/**
		 * 分析: 当多个线程访问myThread的run方法时,以排队的方式进行处理 (这里排队指的是按照CPU分配的先后顺序而定的)，
		 * 		一个线程想要执行synchronized修饰的方法里的代码:
		 * 		1.尝试获得锁
		 * 		2.如果拿到锁,执行synchronized代码体内容,拿不到锁,这个线程就会不断的尝试获得这把锁,直到拿到为止,
		 * 		  而且是多个线程同时去竞争这把锁.(也就是会有锁竞争的问题)
		 */
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		Thread t4 = new Thread(myThread, "t4");
		Thread t5 = new Thread(myThread, "t5");
		Thread t6 = new Thread(myThread, "t6");
		Thread t7 = new Thread(myThread, "t7");
		Thread t8 = new Thread(myThread, "t8");
		Thread t9 = new Thread(myThread, "t9");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}
}
