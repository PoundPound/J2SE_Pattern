/**    
 * @Title: Client.java  
 * @Package com.pattern.bridge  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:39:59 AM  
 * @version V1.0    
 */
package com.pattern.bridge;

/**
 * @ClassName: Client
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 8:39:59 AM
 * 
 */
public class Client
{
	public static void main(String[] args)
	{
		Computer laptopLenovo = new Laptop(new Lenovo());
		Computer laptopDell = new Laptop(new Dell());
		Computer desktopLenovo = new Desktop(new Lenovo());
		Computer desktopDell = new Desktop(new Dell());
		laptopLenovo.sale();
		laptopDell.sale();
		desktopLenovo.sale();
		desktopDell.sale();
	}
}
