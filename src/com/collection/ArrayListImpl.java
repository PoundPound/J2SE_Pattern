package com.collection;

public class ArrayListImpl {
	
	private Object[] elementData;
	
	private int size;
	
	public ArrayListImpl(){
		this(10);
	}
	
	public ArrayListImpl(int initialCapacity) {
		elementData = new Object[initialCapacity];
	}
	
	public int size(){
		return size;
	}

	public void add(Object obj){
		if(size >= elementData.length){
			Object[] newElementData = new Object[size*2+1];
			System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
			elementData = newElementData;
		}
		
		elementData[size++] = obj;
	}
	
	public Object get(int index){
		return elementData[index];
	}
	
	public void remove(int index){
		
		
		System.arraycopy(elementData, index+1, elementData, index, size - index);
		elementData[--size] = null;
	}
	
	public static void main(String[] args) {
		/*ArrayListImpl list = new ArrayListImpl();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.remove(2);
		System.out.println(list.size());
		System.out.println(list.get(2));*/
		
		int a = 1;
		System.out.println(a);
		int b = 0;
		System.out.println(a);
		System.out.println(b);
		b = a++;
		System.out.println(a);
		System.out.println(b);
	}
}
