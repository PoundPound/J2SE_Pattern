/**    
 * @Title: realCar.java  
 * @Package com.pattern.decorator  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:04:46 AM  
 * @version V1.0    
 */
package com.pattern.decorator;

/**  
 * @ClassName: realCar  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:04:46 AM  
 *    
 */
public class RealCar implements ICar
{

	/*  
	 * <p>Title: move</p>  
	 * <p>Description: </p>    
	 * @see com.pattern.decorator.Car#move()  
	 */
	@Override
	public void move()
	{
		System.out.println("路上跑...");
	}
}
