/**    
 * @Title: client.java  
 * @Package com.pattern.decorator  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:10:01 AM  
 * @version V1.0    
 */
package com.pattern.decorator;

/**
 * @ClassName: client
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 13, 2017 8:10:01 AM
 * 
 */
public class Client
{
	public static void main(String[] args)
	{
		RealCar car = new RealCar();
		ICar SuperCar = new SuperCar(car);
		SuperCar.move();
		System.out.println("-----------------------");
		
		ICar fly = new FlyCar(car);
		fly.move();
		System.out.println("-----------------------");
		
		ICar water = new WaterCar(car);
		water.move();
		System.out.println("-----------------------");
		
		ICar misc = new WaterCar(fly);
		misc.move();
		System.out.println("-----------------------");
	}
}
