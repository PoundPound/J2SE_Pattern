/**    
 * @Title: DemoDeque.java  
 * @Package com.collection.queue  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 10:14:10 PM  
 * @version V1.0    
 */
package com.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: DemoDeque
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 10:14:10 PM
 * 
 */
public class MyStack<E>
{
	private Deque<E> container = new ArrayDeque<E>();

	private int capacity;

	public int size()
	{
		return capacity;
	}

	private MyStack(int capacity)
	{
		super();
		this.capacity = capacity;
	}

	// 压栈
	public boolean push(E e)
	{
		if (container.size() + 1 > capacity)
		{
			return false;
		}
		return container.offerLast(e);
	}

	// 弹栈
	public E pop()
	{
		return container.pollLast();
	}

	// 获取
	public E peek()
	{
		return container.peekLast();
	}

	public static void main(String[] args)
	{
		MyStack<String> myStack = new MyStack<String>(3);
		myStack.push("www.baidu.com");
		myStack.push("www.google.com");
		myStack.push("www.sina.com");
		myStack.push("www.163.com");
		System.out.println(myStack.size());

		String addr2 = null;
		while (null != (addr2 = myStack.peek()))
		{
			System.out.println(addr2);
		}
		String addr = null;
		while (null != (addr = myStack.pop()))
		{
			System.out.println(addr);
		}
		
	}
}
