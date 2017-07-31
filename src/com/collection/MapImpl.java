/**    
 * @Title: MapImpl.java  
 * @Package com.collection  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 20, 2017 9:09:57 AM  
 * @version V1.0    
 */
package com.collection;

/**
 * @ClassName: MapImpl
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 20, 2017 9:09:57 AM
 * 
 */
public class MapImpl
{
	private LenkedListImpl[] keys = new LenkedListImpl[10];

	private int size;

	public int size()
	{
		return size;
	}

	public void put(Object key, Object value)
	{
		int hash = key.hashCode() < 0 ? -key.hashCode() : key.hashCode();
		int index = hash % keys.length;
		if (keys[index] == null)
		{
			Entry entry = new Entry(key, value);
			LenkedListImpl linkedList = new LenkedListImpl();
			linkedList.add(entry);
			keys[index] = linkedList;
		}
		else
		{
			LenkedListImpl linkedList = keys[index];
			for (int i = 0; i < linkedList.size(); i++)
			{
				Entry entry = (Entry) linkedList.get(i);
				if (entry.key.equals(key))
				{
					entry.value = value;
					return;
				}
			}
			keys[index].add(value);
		}

		size++;
	}

	public Object get(Object key)
	{
		int index = key.hashCode() % keys.length;

		if (keys[index] != null)
		{
			LenkedListImpl linkedList = keys[index];
			for (int i = 0; i < linkedList.size(); i++)
			{
				Entry entry = (Entry) linkedList.get(i);
				if (entry.key.equals(key))
				{
					return entry.value;
				}
			}
		}

		return null;
	}

	public static void main(String[] args)
	{
		MapImpl map = new MapImpl();
		map.put("a", "aaaaa");
		System.out.println(map.get("a"));
		map.put("b", "bbbbb");
		map.put("a", "ccccc");
		System.out.println(map.get("a"));
	}
}
