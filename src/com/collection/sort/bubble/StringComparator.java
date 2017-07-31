/**    
 * @Title: StringComparator.java  
 * @Package com.collection.sort.bubble  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 8:33:43 AM  
 * @version V1.0    
 */
package com.collection.sort.bubble;

import java.util.Comparator;

/**
 * @ClassName: StringComparator
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jun 24, 2017 8:33:43 AM
 * 
 */
public class StringComparator implements Comparator<String>
{
	/*
	 * <p>Title: compare</p> <p>Description: </p>
	 * 
	 * @param o1
	 * 
	 * @param o2
	 * 
	 * @return
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2)
	{
		int l1 = o1.length();
		int l2 = o2.length();
		return l1 - l2;
	}

}
