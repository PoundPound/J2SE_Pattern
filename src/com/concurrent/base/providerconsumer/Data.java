/**    
 * @Title: Data.java  
 * @Package com.concurrent.base.providerconsumer  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 8:25:32 AM  
 * @version V1.0    
 */
package com.concurrent.base.providerconsumer;

/**  
 * @ClassName: Data  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 31, 2017 8:25:32 AM  
 *    
 */
public class Data
{
	private int id;
	private String name;
	/**  
	 * <p>Title: </p>  
	 * <p>Description: </p>  
	 * @param id2
	 * @param string  
	 */
	public Data(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
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
	
}
