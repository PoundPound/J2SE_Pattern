package com.pattern.singleton;

import java.util.concurrent.CountDownLatch;

public class Client3 {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int threadNum = 20;
		final CountDownLatch count = new CountDownLatch(threadNum);
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						Object o = SingletonDemo4.getInstance();
					}
					count.countDown();
				}
			}).start();
		}
		
		try {
			count.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("总耗时:" + (end - start));//demo1-17,demo2-50,demo3-22,demo4-35
	}
}
