/**    
 * @Title: Desktop.java  
 * @Package com.pattern.bridge  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:38:51 AM  
 * @version V1.0    
 */
package com.pattern.bridge;

/**
 * @ClassName: Desktop
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:38:51 AM
 * 
 */
public class Desktop extends Computer
{

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param brand
	 */
	public Desktop(Brand brand)
	{
		super(brand);
	}

	@Override
	public void sale()
	{
		super.sale();
		System.out.println("销售台式机");
	}

}
