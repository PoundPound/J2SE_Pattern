/**    
 * @Title: Client.java  
 * @Package com.pattern.composit  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:31:40 AM  
 * @version V1.0    
 */
package com.pattern.composite;

/**
 * @ClassName: Client
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:31:40 AM
 * 
 */
public class Client
{
	public static void main(String[] args)
	{
		FileSystem f1, f2, f3, f4, f5;
		f1 = new ImageFile("手绘");
		f2 = new VideoFile("海贼王");
		f3 = new TextFile("小说");
		f4 = new ImageFile("素描");
		f5 = new VideoFile("火影忍者");
		Folder folder1 = new Folder("迅雷下载");
		folder1.add(f2);
		folder1.add(f5);
		Folder folder2 = new Folder("我的文件夹");
		folder2.add(f1);
		folder2.add(f3);
		folder2.add(f4);
		folder2.add(folder1);
		folder2.open();
	}
}
