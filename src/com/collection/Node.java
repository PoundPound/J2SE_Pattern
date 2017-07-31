/**    
 * @Title: Node.java  
 * @Package com.collection  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 19, 2017 9:42:43 AM  
 * @version V1.0    
 */
package com.collection;

/**
 * @ClassName: Node
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 19, 2017 9:42:43 AM
 * 
 */
public class Node
{
	Node previous;

	Object obj;

	Node next;

	public Node()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(Node previous, Object obj, Node next)
	{
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}

	public Node getPrevious()
	{
		return previous;
	}

	public void setPrevious(Node previous)
	{
		this.previous = previous;
	}

	public Object getObj()
	{
		return obj;
	}

	public void setObj(Object obj)
	{
		this.obj = obj;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}
}
