/**    
 * @Title: Dell.java  
 * @Package com.pattern.bridge  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:33:39 AM  
 * @version V1.0    
 */
package com.pattern.bridge;

/**  
 * @ClassName: Dell  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:33:39 AM  
 *    
 */
public class Dell implements Brand
{

	/*  
	 * <p>Title: sale</p>  
	 * <p>Description: </p>    
	 * @see com.pattern.bridge.Brand#sale()  
	 */
	@Override
	public void sale()
	{
		System.out.println("戴尔品牌");
		
	}

}
