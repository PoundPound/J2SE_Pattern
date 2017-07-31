/**    
 * @Title: MapDemo1.java  
 * @Package com.collection.demo  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 21, 2017 11:24:27 AM  
 * @version V1.0    
 */
package com.collection.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: MapDemo1
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 21, 2017 11:24:27 AM
 * 
 */
public class MapDemo1
{
	// because he can give me advices and help me to make the best decision
	// 统计每个单词出现的次数
	// 使用hashmap分拣存储
	public static void main(String[] args)
	{
		String str = "because he can give me advices and help me to make the best decision";
		Map<String, Integer> map = MapDemo1.sorte(str);
		Set<String> keys = map.keySet();
		for (String key : keys)
		{
			System.out.println("单词:" + key + ",出现次数:" + map.get(key));
		}
	}

	public static Map<String, Integer> sorte(String str)
	{
		String[] arry = str.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : arry)
		{
			Integer value = map.get(s);
			if (value == null)
				map.put(s, 0);

			map.put(s, map.get(s) + 1);
		}
		return map;
	}
}
