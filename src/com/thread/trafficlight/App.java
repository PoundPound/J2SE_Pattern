/**    
 * @Title: App.java  
 * @Package com.thread  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:25:36 AM  
 * @version V1.0    
 */
package com.thread.trafficlight;

/**  
 * @ClassName: App  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jun 27, 2017 11:25:36 AM  
 *    
 */
public class App
{
	public static void main(String[] args)
	{
		Road road = new Road();
		Person p = new Person(road);
		Car c = new Car(road);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}
