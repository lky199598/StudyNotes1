package com.reflect;

import java.util.ArrayList;

public class ClassDemo1 {

	private Class c1;
	private Class c2;
	private Class c3;

	public void GetClass() {
		// Foo的实例对象
		Foo foo1 = new Foo();

		// Foo这个类 也是一个实例对象，Class类的实例对象,
		// 任何一个类都是Class的实例对象，这个实例对象有三种表示方式

		// 第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量class
		c1 = Foo.class;

		// 第二种表达方式 已经知道该类的对象通过getClass方法
		c2 = foo1.getClass();

		/*
		 * 官网 c1 ,c2 表示了Foo类的类类型(class type) 万事万物皆对象， 类也是对象，是Class类的实例对象
		 * 这个对象我们称为该类的类类型
		 */
		// 不管c1 or c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
		System.out.println(c1 == c2);

		// 第三种表达方式
		c3 = null;
		try {
			c3 = Class.forName("com.reflect.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c2 == c3);

		System.out.println("Foo.class: " + c1 + "\nfoo1.getClass: " + c2
				+ "\nClass.forName('com.reflect.Foo'): " + c3);
	}

	public ArrayList<Object> GetNewInstance(Object obj)
	{
		ArrayList<Object> list = new ArrayList<Object>();
		
		Class c = obj.getClass();
		 System.out.println(c.getName() + "\n" + c.getSimpleName()+"\n");
		 
		 try {
			// 通过类的类类型创建该类的对象实例，得到不同的对象---->通过c1 or c2 or c3创建Foo的实例对象
			Object o1 = c.newInstance();
			Object o2 = c.newInstance();
			Object o3 = c.newInstance();
			System.out.println((o1==o2)+"\n"+(o2==o3));
			list.add(o1);
			list.add(o2);
			list.add(o3);
			
			return list;
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	
	public static void main(String[] args) {
       
		Foo foo = new Foo();
		ClassDemo1 CD = new ClassDemo1();
		ArrayList<Object> list = CD.GetNewInstance(foo);
		
		for(Object obj : list)
		{
			Foo f = (Foo)obj;
			f.print();
		}
		
	}

}

class Foo{

	void print() {
		System.out.println("打印出结果");
	}
}
