/**    
 * @Title: HelloServerImpl.java  
 * @Package com.rpc  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:57:36 AM  
 * @version V1.0    
 */
package com.rpc;

/**  
 * @ClassName: HelloServerImpl  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:57:36 AM  
 *    
 */
public class HelloServiceImpl implements HelloService
{

	/*  
	 * <p>Title: sayHi</p>  
	 * <p>Description: </p>  
	 * @param name
	 * @return  
	 * @see com.rpc.HelloService#sayHi(java.lang.String)  
	 */
	@Override
	public String sayHi(String name)
	{
		return "Hi, " + name;
	}

}
