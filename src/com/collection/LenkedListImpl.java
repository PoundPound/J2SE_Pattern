/**    
 * @Title: LenkedListImpl.java  
 * @Package com.collection  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 19, 2017 9:47:05 AM  
 * @version V1.0    
 */
package com.collection;

/**
 * @ClassName: LenkedListImpl
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 19, 2017 9:47:05 AM
 * 
 */
public class LenkedListImpl
{
	private Node first;

	private Node last;

	private int size;

	public int size()
	{
		return size;
	}

	public void add(Object obj)
	{
		Node node = new Node();
		if (first == null)
		{
			node.setPrevious(null);
			node.setObj(obj);
			node.setNext(null);
			first = node;
			last = node;
		}
		else
		{
			node.setPrevious(last);
			node.setObj(obj);
			node.setNext(null);
			last.setNext(node);
			last = node;
		}
		size++;
	}

	public Object get(int index)
	{
		Node node = node(index);
		return node.getObj();
	}

	private Node node(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		if (first == null)
		{
			return null;
		}
		/*Node tmp = first;
		for (int i = 0; i < index; i++)
		{
			tmp = tmp.getNext();
		}*/
		if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
	}

	public void remove(int index)
	{
		Node node = node(index);

		Node up = node.previous;
		Node down = node.next;

		up.next = down;
		down.previous = up;
	}

	// 没加细节判断
	public void add(int index, Object obj)
	{
		Node newNode = new Node();
		newNode.setObj(obj);

		Node node = node(index);
		Node up = node.previous;
		up.next = newNode;
		newNode.previous = up;
		newNode.next = node;
		node.previous = newNode;
	}

	public static void main(String[] args)
	{
		LenkedListImpl lenkedlist = new LenkedListImpl();
		lenkedlist.add("0");
		lenkedlist.add("1");
		lenkedlist.add("2");
		lenkedlist.add("3");
		lenkedlist.add("4");
		lenkedlist.add("5");
		/*
		 * System.out.println(lenkedlist.size());
		 * System.out.println(lenkedlist.get(1)); lenkedlist.remove(1);
		 * System.out.println(lenkedlist.get(1));
		 */
		System.out.println(lenkedlist.get(2));
		lenkedlist.add(2, "22222");
		System.out.println(lenkedlist.get(2));
	}
}
