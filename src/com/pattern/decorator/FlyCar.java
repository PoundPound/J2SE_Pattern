/**    
 * @Title: FlyCar.java  
 * @Package com.pattern.decorator  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:09:04 AM  
 * @version V1.0    
 */
package com.pattern.decorator;

/**  
 * @ClassName: FlyCar  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:09:04 AM  
 *    
 */
public class FlyCar extends SuperCar
{

	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>  
	 * @param iCar  
	 */
	public FlyCar(ICar iCar)
	{
		super(iCar);
	}

	@Override
	public void move()
	{
		super.move();
		fly();
	}
	
	public void fly()
	{
		System.out.println("我能飞...");
	}
}
