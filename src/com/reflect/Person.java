/**    
 * @Title: Person.java  
 * @Package com.reflect  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Jul 6, 2017 10:07:10 AM  
 * @version V1.0    
 */
package com.reflect;

/**
 * @ClassName: Person
 * @Description: TODO
 * @author lewis lianfenxiang@163.com
 * @date Jul 6, 2017 10:07:10 AM
 * 
 */
public class Person
{
	private String name;
	private int age;

	public Person()
	{
	}

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
