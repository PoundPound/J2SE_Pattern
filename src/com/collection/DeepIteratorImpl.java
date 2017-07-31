/**    
 * @Title: ArrayListIteratorImpl.java  
 * @Package com.collection  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 21, 2017 9:53:16 AM  
 * @version V1.0    
 */
package com.collection;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @ClassName: ArrayListIteratorImpl
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 21, 2017 9:53:16 AM
 * 
 */
public class DeepIteratorImpl
{
	private Object[] elementData =
	{ 1, 2, 3, 4, 5 };

	private int size = elementData.length;

	private class MyIterator implements Iterator
	{
		// 指针 游标
		private int coursor = -1;

		public boolean hasNext()
		{
			return coursor + 1 < size;
		}

		public Object next()
		{
			coursor++;
			return elementData[coursor];
		}

		public void remove()
		{
			System.arraycopy(elementData, coursor + 1, elementData, coursor, size - (coursor + 1));
			size--;
			coursor--;
			elementData[size] = null;
		}
	}

	public Iterator iterator()
	{
		return new MyIterator();
	}

	public Iterator iterator2()
	{
		class MyIterator implements Iterator
		{
			// 指针 游标
			private int coursor = -1;

			public boolean hasNext()
			{
				return coursor + 1 < size;
			}

			public Object next()
			{
				coursor++;
				return elementData[coursor];
			}

			public void remove()
			{
				System.arraycopy(elementData, coursor + 1, elementData, coursor, size - (coursor + 1));
				size--;
				coursor--;
				elementData[size] = null;
			}
		}
		return new MyIterator();
	}

	public Iterator iterator3()
	{
		return new Iterator()
		{
			// 指针 游标
			private int coursor = -1;

			public boolean hasNext()
			{
				return coursor + 1 < size;
			}

			public Object next()
			{
				coursor++;
				return elementData[coursor];
			}

			public void remove()
			{
				System.arraycopy(elementData, coursor + 1, elementData, coursor, size - (coursor + 1));
				size--;
				coursor--;
				elementData[size] = null;
			}
		};
	}

	@Override
	public String toString()
	{
		return "ArrayListIteratorImpl [elementData=" + Arrays.toString(elementData) + "]";
	}

	public static void main(String[] args)
	{
		DeepIteratorImpl list = new DeepIteratorImpl();
		Iterator it = list.iterator3();
		System.out.println("size:" + list.size);
		if (it.hasNext())
		{
			System.out.println(it.next());
			it.remove();
		}
		if (it.hasNext())
		{
			System.out.println(it.next());
			it.remove();
		}
		if (it.hasNext())
		{
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(list);
		System.out.println("size:" + list.size);
		System.out.println(list.elementData[4]);
	}
}
