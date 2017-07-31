/**    
 * @Title: ConcreteChessFlyWeight.java  
 * @Package com.pattern.flyweight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:16:06 AM  
 * @version V1.0    
 */
package com.pattern.flyweight;

/**  
 * @ClassName: ConcreteChessFlyWeight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:16:06 AM  
 *    
 */
public class ConcreteChessFlyWeight implements ChessFlyWeight
{
	private String colour;

	public ConcreteChessFlyWeight(String colour)
	{
		super();
		this.colour = colour;
	}

	/*  
	 * <p>Title: setColour</p>  
	 * <p>Description: </p>  
	 * @param colour  
	 * @see com.pattern.flyweight.ChessFlyWeight#setColour(java.lang.String)  
	 */
	@Override
	public void setColour(String colour)
	{
		this.colour = colour;
	}

	/*  
	 * <p>Title: getColour</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.pattern.flyweight.ChessFlyWeight#getColour()  
	 */
	@Override
	public String getColour()
	{
		return colour;
	}

	/*  
	 * <p>Title: display</p>  
	 * <p>Description: </p>  
	 * @param coordinate  
	 * @see com.pattern.flyweight.ChessFlyWeight#display(com.pattern.flyweight.Coordinate)  
	 */
	@Override
	public void display(Coordinate coordinate)
	{
		System.out.println(colour + "棋子位置:" + coordinate.getX() + "------" + coordinate.getY());
	}
	
	
}
