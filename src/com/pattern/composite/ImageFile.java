/**    
 * @Title: ImageFile.java  
 * @Package com.pattern.composit  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:21:38 AM  
 * @version V1.0    
 */
package com.pattern.composite;

/**  
 * @ClassName: ImageFile  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:21:38 AM  
 *    
 */
public class ImageFile implements FileSystem
{
	private String name;
	
	public ImageFile(String name)
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
		System.out.println("打开图像文件:" + name);
	}

}
