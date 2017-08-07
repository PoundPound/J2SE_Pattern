/**    
 * @Title: Server.java  
 * @Package com.rpc  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:33:27 AM  
 * @version V1.0    
 */
package com.rpc;

import java.io.IOException;

/**  
 * @ClassName: Server  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 7, 2017 9:33:27 AM  
 *    
 */
public interface Server
{
	public void stop();

	public void start() throws IOException;

	public void register(Class<?> serviceInterface, Class<?> impl);

	public boolean isRunning();

	public int getPort();
}
