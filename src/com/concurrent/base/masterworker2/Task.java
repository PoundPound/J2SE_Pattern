/**    
 * @Title: Task.java  
 * @Package com.concurrent.base.masterworker  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 10:44:58 AM  
 * @version V1.0    
 */
package com.concurrent.base.masterworker2;

/**  
 * @ClassName: Task  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 17, 2017 10:44:58 AM  
 *    
 */
public class Task
{
	private int id;
	private String name;
	private int num;

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
}
