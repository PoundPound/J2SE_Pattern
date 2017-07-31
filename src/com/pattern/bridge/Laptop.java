/**    
 * @Title: Laptop.java  
 * @Package com.pattern.bridge  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:35:45 AM  
 * @version V1.0    
 */
package com.pattern.bridge;

/**  
 * @ClassName: Laptop  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:35:45 AM  
 *    
 */
public class Laptop extends Computer
{

	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>  
	 * @param brand  
	 */
	public Laptop(Brand brand)
	{
		super(brand);
	}

	@Override
	public void sale()
	{
		super.sale();
		System.out.println("销售笔记本");
	}

}
