/**    
 * @Title: TextFile.java  
 * @Package com.pattern.composit  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:25:25 AM  
 * @version V1.0    
 */
package com.pattern.composite;

/**  
 * @ClassName: TextFile  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:25:25 AM  
 *    
 */
public class TextFile implements FileSystem
{
	private String name;
	
	public TextFile(String name)
	{
		super();
		this.name = name;
	}
	
	/*  
	 * <p>Title: open</p>  
	 * <p>Description: </p>    
	 * @see com.pattern.composit.FileSystem#open()  
	 */
	@Override
	public void open()
	{
		System.out.println("打开文本文件:" + name);
	}

}
