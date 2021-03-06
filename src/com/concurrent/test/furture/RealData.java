/**    
 * @Title: RealData.java  
 * @Package com.concurrent.test.furture  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:07:27 AM  
 * @version V1.0    
 */
package com.concurrent.test.furture;

/**  
 * @ClassName: RealData  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 6, 2017 8:07:27 AM  
 *    
 */
public class RealData implements Data
{
	private String result;
	
	public RealData(String req)
	{
		System.out.println("系统消息:根据请求->" + req + "<-进行查询,这是一个很耗时的操作...");
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("系统消息:操作完毕,获取结果...");
		result = "返回的结果集";
	}

	/*  
	 * <p>Title: response</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.concurrent.test.furture.Data#response()  
	 */
	@Override
	public String response()
	{
		return result;
	}

}
