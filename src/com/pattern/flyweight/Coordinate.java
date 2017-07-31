/**    
 * @Title: Coordinate.java  
 * @Package com.pattern.flyweight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:14:03 AM  
 * @version V1.0    
 */
package com.pattern.flyweight;

/**
 * @ClassName: Coordinate
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:14:03 AM
 * 
 */
public class Coordinate
{
	private int x, y;

	public Coordinate(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}
