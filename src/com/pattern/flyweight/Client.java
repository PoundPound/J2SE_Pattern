/**    
 * @Title: Client.java  
 * @Package com.pattern.flyweight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:23:51 AM  
 * @version V1.0    
 */
package com.pattern.flyweight;

/**
 * @ClassName: Client
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:23:51 AM
 * 
 */
public class Client
{
	public static void main(String[] args)
	{
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess3 = ChessFlyWeightFactory.getChess("白色");
		ChessFlyWeight chess4 = ChessFlyWeightFactory.getChess("白色");
		
		System.out.println(chess1.hashCode());
		System.out.println(chess2.hashCode());
		System.out.println(chess3.hashCode());
		System.out.println(chess4.hashCode());
		
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(12, 12));
		chess3.display(new Coordinate(1, 1));
		chess4.display(new Coordinate(5, 5));
	}
}
