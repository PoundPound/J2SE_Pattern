/**    
 * @Title: WaterCar.java  
 * @Package com.pattern.decorator  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:09:37 AM  
 * @version V1.0    
 */
package com.pattern.decorator;

/**  
 * @ClassName: WaterCar  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:09:37 AM  
 *    
 */
public class WaterCar extends SuperCar
{

	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>  
	 * @param iCar  
	 */
	public WaterCar(ICar iCar)
	{
		super(iCar);
	}
	
	@Override
	public void move()
	{
		super.move();
		swim();
	}

	public void swim()
	{
		System.out.println("我能在水里游...");
	}
}
