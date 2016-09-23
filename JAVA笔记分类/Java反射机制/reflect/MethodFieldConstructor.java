package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class MethodFieldConstructor {
	/**
	 * 打印类的信息，包括类的成员函数、成员变量(只获取成员函数)
	 * @param obj 该对象所属类的信息
	 */
	public static void printClassMethodMessage(Object obj)
	{
		//要获取类的信息  首先要获取类的类类型
		Class c = obj.getClass();//传递的是哪个子类的对象  c就是该子类的类类型
		
		//获取类的名称
		System.out.println("类的名称: "+c.getName());
		
		/*
		 * Method类，方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有的public的函数(公共 member方法)，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有 该类自己声明的方法，不问访问权限
		 */
		Method[] mt = c.getMethods();
		
		for(int i=0; i< mt.length; i++)
		{
			//得到方法的返回值类型的类类型
			Class ReturnType = mt[i].getReturnType();
			
			System.out.print(ReturnType.getName()+"  ");
			
			//得到方法的名称
			System.out.print(mt[i].getName()+"(");
			
			//获取参数类型--->得到的是参数列表的类型的类类型
			Class[] ParamTypes = mt[i].getParameterTypes();
		    for(Class cl : ParamTypes)
		    	System.out.print(cl.getName()+",");
		    System.out.println(")");
		}
	}
	
	public static void printFieldMessage(Object obj)
	{
		Class c = obj.getClass();
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息
		 * getDeclaredFields获取的是该类自己声明的成员变量的信息
		 */
		//Field[] fs = c.getFields();
		Field[] field = c.getDeclaredFields();
		for(Field f : field)
		{
			//得到成员变量的类型的类类型
			Class FieldType = f.getType();
			//得到成员变量的类型名称和成员变量的名称
			System.out.println(FieldType.getName()+"  "+f.getName());
			
		}
	}
	
	
	public static void printConstructorMessage(Object obj)
	{
		Class c = obj.getClass();
		/*
		 * 构造
		
		* 
		 * java.lang. Constructor中封装了构造函数的信息
		 * getConstructors获取所有的public的构造函数
		 * getDeclaredConstructors得到所有的构造函数
		 */
		Constructor[] constructor = c.getDeclaredConstructors();
	     for(Constructor con:constructor)
	     {
	    	 System.out.print(con.getName()+"(");
	    	
	    	 //获取构造函数的参数列表--->得到的是参数列表的类类型
	    	 Class[] ParamType = con.getParameterTypes();
	        
	    	 for(Class cl : ParamType)
	        	System.out.print(cl.getName()+",");
	    	 
	        System.out.println(")");
	     }
	
	}
	
	public static void main(String[] args)
	{
		String s = "hello";    Integer I = new Integer(2);
/*		MethodFieldConstructor.printClassMethodMessage(s);
		
		System.out.println("\n");
	
	    MethodFieldConstructor.printClassMethodMessage(I);
	*/
		
		MethodFieldConstructor.printFieldMessage(s);
		System.out.println("\n");
		MethodFieldConstructor.printFieldMessage(I);
/*		
        MethodFieldConstructor.printConstructorMessage(s);		
		System.out.println("\n");
		MethodFieldConstructor.printConstructorMessage(I)*/;
	}
	
}
