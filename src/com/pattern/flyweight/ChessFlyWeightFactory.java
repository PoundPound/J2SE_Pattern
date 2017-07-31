/**    
 * @Title: ChessFlyWeightFactory.java  
 * @Package com.pattern.flyweight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:20:00 AM  
 * @version V1.0    
 */
package com.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: ChessFlyWeightFactory  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:20:00 AM  
 *    
 */
public class ChessFlyWeightFactory
{
	private static Map<String, ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();
	
	public static ChessFlyWeight getChess(String colour)
	{
		if (map.get(colour) != null)
		{
			return map.get(colour);
		}
		else
		{
			ChessFlyWeight chess = new ConcreteChessFlyWeight(colour);
			map.put(colour, chess);
			return chess;
		}
	}
}
