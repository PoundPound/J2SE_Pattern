/**    
 * @Title: Folder.java  
 * @Package com.pattern.composit  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:26:40 AM  
 * @version V1.0    
 */
package com.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Folder
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 11, 2017 9:26:40 AM
 * 
 */
public class Folder implements FileSystem
{
	private String name;
	private List<FileSystem> child = new ArrayList<FileSystem>();

	public Folder(String name)
	{
		super();
		this.name = name;
	}

	public void add(FileSystem f)
	{
		child.add(f);
	}

	public void remove(FileSystem f)
	{
		child.remove(f);
	}

	public void remove(int index)
	{
		child.remove(index);
	}

	public FileSystem getChild(int index)
	{
		return child.get(index);
	}

	/*
	 * <p>Title: open</p> <p>Description: </p>
	 * 
	 * @see com.pattern.composit.FileSystem#open()
	 */
	@Override
	public void open()
	{
		System.out.println("打开文件夹:" + name);
		for (FileSystem fileSystem : child)
		{
			fileSystem.open();
		}
	}

}
