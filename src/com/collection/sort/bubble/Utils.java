/**    
 * @Title: Utils.java  
 * @Package com.collection.sort.bubble  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 7:59:56 AM  
 * @version V1.0    
 */
package com.collection.sort.bubble;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: Utils
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 7:59:56 AM
 * 
 */
public class Utils
{
	public static void sort(String[] arr, Comparator<String> comparator)
	{
		boolean sorted;
		int len = arr.length;
		for (int i = 1; i < len - 1; i++)
		{
			sorted = true;
			for (int j = 0; j < len - 1; j++)
			{
				// >0 升序 <0 降序
				if ((comparator.compare(arr[j], arr[j + 1])) > 0)
				{
					String tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					sorted = false;
				}
			}
			if (sorted)
			{
				break;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static <T extends Comparable<T>> void sort(List<T> list)
	{
		Object[] arr = list.toArray();
		sort(arr);
		for (int i = 0; i < arr.length; i++)
		{
			list.set(i, (T) arr[i]);
		}
	}

	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		boolean sorted;
		int len = arr.length;
		for (int i = 1; i < len - 1; i++)
		{
			sorted = true;
			for (int j = 0; j < len - 1; j++)
			{
				// >0 升序 <0 降序
				if (((Comparable<T>) arr[j]).compareTo(arr[j + 1]) > 0)
				{
					T tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					sorted = false;
				}
			}
			if (sorted)
			{
				break;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

	public static void sort(Object[] arr)
	{
		boolean sorted;
		int len = arr.length;
		for (int i = 1; i < len - 1; i++)
		{
			sorted = true;
			for (int j = 0; j < len - 1; j++)
			{
				// >0 升序 <0 降序
				if (((Comparable) arr[j]).compareTo(arr[j + 1]) > 0)
				{
					Object tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					sorted = false;
				}
			}
			if (sorted)
			{
				break;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
