/**    
 * @Title: Computer.java  
 * @Package com.pattern.bridge  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:34:52 AM  
 * @version V1.0    
 */
package com.pattern.bridge;

/**
 * @ClassName: Computer
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:34:52 AM
 * 
 */
public class Computer
{
	protected Brand brand;

	public Computer(Brand brand)
	{
		super();
		this.brand = brand;
	}

	public void sale()
	{
		brand.sale();
	}
}
