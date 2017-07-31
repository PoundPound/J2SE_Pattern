/**    
 * @Title: Client.java  
 * @Package com.annotation  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 5, 2017 9:20:39 AM  
 * @version V1.0    
 */
package com.annotation;

/**  
 * @ClassName: Client  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 5, 2017 9:20:39 AM  
 *    
 */
public class Client
{
	@MethodAnnotationDemo("createThread")
	public void print(){
		System.out.println("print method");
	}
}
