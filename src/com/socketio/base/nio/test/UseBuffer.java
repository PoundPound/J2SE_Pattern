/**    
 * @Title: UseBuffer.java  
 * @Package com.socketio.base.nio  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 4, 2017 11:36:40 PM  
 * @version V1.0    
 */
package com.socketio.base.nio.test;

import java.nio.IntBuffer;

import org.ietf.jgss.Oid;

/**  
 * @ClassName: UseBuffer  
 * @Description: TODO 
 * @author lewis lianfenxiang@163.com
 * @date Aug 4, 2017 11:36:40 PM  
 *    
 */
public class UseBuffer
{
	public static void main(String[] args)
	{
		//1.基本操作
		/*
		//创建指定长度的缓冲区
		IntBuffer buffer = IntBuffer.allocate(10);
		buffer.put(3);// position位置: 0 -> 1
		buffer.put(5);// position位置: 1 -> 2
		buffer.put(7);// position位置: 2 -> 3
		//把位置复位为0,也就是position位置: 3 -> 0
		//buffer.flip();
		//System.out.println("使用flip()复位: " + buffer);
		System.out.println("容量为: " + buffer.capacity());	//容量一旦初始化后不允许改变(warp()方法包裹数组除外)
		System.out.println("限制为: " + buffer.limit());		//由于只装载了3个元素,所以可读取或者操作的元素为3,则limit=3
		
		System.out.println("获取下标为1的元素: " + buffer.get(1));
		System.out.println("get(index)方法,position位置不发生改变: " + buffer);
		
		for (int i = 0; i < buffer.limit(); i++)
		{
			//调用get()方法会使其缓冲区位置position向后递增一位
			System.out.print(buffer.get() + "\t");
		}
		System.out.println("buffer对象遍历之后为: " + buffer);
		*/
		
		//2.warp方法使用
		/*
		// warp方法会包裹一个数组,一般这种用法不会先初始化缓存对象的长度,因为没有意义,最后还会被warp所包裹的数组覆盖掉.
		// 并且warp方法修改缓存区对象的时候,数组本身也会跟着发生变化
		int[] array = new int[]{ 1, 3, 5 };
		IntBuffer buffer1 = IntBuffer.wrap(array);
		System.out.println(buffer1);
		// 这样使用表示容量为数组array的长度,但是可操作的元素只有实际进入缓存区的元素长度
		IntBuffer buffer2 = IntBuffer.wrap(array, 0, 2);
		System.out.println(buffer2);
		*/
		
		//3.其他方法
		/*
		IntBuffer buffer1 = IntBuffer.allocate(10);
		int[] array1 = new int[]{ 1, 3, 5 };
		buffer1.put(array1);
		System.out.println(buffer1);
		//一种复制方法
		IntBuffer buffer2 = buffer1.duplicate();
		System.out.println(buffer2);
		
		//设置buffer1的位置属性
		buffer1.position(1);
//		buffer1.flip();
		System.out.println(buffer1);
		System.out.println("可读取数据为: " + buffer1.remaining());
		
		int[] array2 = new int[buffer1.remaining()];
		//将缓冲区数据放入array数组中
		buffer1.get(array2);
		for (int i : array2)
		{
			System.out.print(i + ",");
		}
		*/
	}
}
