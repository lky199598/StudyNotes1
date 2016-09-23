package com.imooc.reflect;

public class ClassDemo2 {
	public static void main(String[] args) {
		
		Class c1 = int.class;//int 的类类型
		Class c2 = String.class;//String类的类类型   String类字节码（自己发明的)
		
		//Double 类在对象中包装一个基本类型 double 的值。
		//每个 Double 类型的对象都包含一个 double 类型的字段。 
		Class c3 = double.class;//基本类型double的类类型
		Class c4 = Double.class;//Double类的类类型
		Class c5 = void.class;
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());//不包含包名的类的名称
		System.out.println(c5.getName());
	}

}
