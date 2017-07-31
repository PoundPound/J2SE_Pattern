/**    
 * @Title: VideoFile.java  
 * @Package com.pattern.composit  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:24:07 AM  
 * @version V1.0    
 */
package com.pattern.composite;

/**  
 * @ClassName: VideoFile  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:24:07 AM  
 *    
 */
public class VideoFile implements FileSystem
{
	private String name;
	
	public VideoFile(String name)
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
		System.out.println("打开视频文件:" + name);
	}

}
