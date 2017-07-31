/**    
 * @Title: SuperCar.java  
 * @Package com.pattern.decorator  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:06:34 AM  
 * @version V1.0    
 */
package com.pattern.decorator;

/**
 * @ClassName: SuperCar
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:06:34 AM
 * 
 */
public class SuperCar implements ICar
{
	protected ICar iCar;

	public SuperCar(ICar iCar)
	{
		super();
		this.iCar = iCar;
	}

	/*  
	 * <p>Title: move</p>  
	 * <p>Description: </p>    
	 * @see com.pattern.decorator.ICar#move()  
	 */
	@Override
	public void move()
	{
		iCar.move();
	}
}
