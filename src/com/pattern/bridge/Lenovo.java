/**    
 * @Title: Lenovo.java  
 * @Package com.pattern.bridge  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:32:52 AM  
 * @version V1.0    
 */
package com.pattern.bridge;

/**  
 * @ClassName: Lenovo  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:32:52 AM  
 *    
 */
public class Lenovo implements Brand
{

	/*  
	 * <p>Title: sale</p>  
	 * <p>Description: </p>    
	 * @see com.pattern.bridge.Brand#sale()  
	 */
	@Override
	public void sale()
	{
		System.out.println("联想品牌");
	}

}
