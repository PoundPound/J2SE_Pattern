/**    
 * @Title: ChessFlyWeight.java  
 * @Package com.pattern.flyweight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:10:57 AM  
 * @version V1.0    
 */
package com.pattern.flyweight;

/**  
 * @ClassName: ChessFlyWeight  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 9:10:57 AM  
 *    
 */
public interface ChessFlyWeight
{
	public void setColour(String colour);
	public String getColour();
	public void display(Coordinate coordinate);
}
