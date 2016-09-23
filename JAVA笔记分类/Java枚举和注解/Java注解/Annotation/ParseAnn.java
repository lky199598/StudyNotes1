package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnn {

	public static void main(String[] args)
	{
//使用类加载器加载类
	
	Class c = Child.class;

	//2.找到类上面的注解
	boolean IsExist = c.isAnnotationPresent(Description.class);
	
	System.out.print("找到类"+c.getSimpleName()+"上面的注解:  ");
	if(IsExist)
	{
		//3.拿到注解实例
		Description d = (Description)c.getAnnotation(Description.class);
		System.out.println(d.value());
	}
	
	//4.找到方法上的注解
	Method[] mt  = c.getMethods();
	/*
	 * Method类，方法对象
	 * 一个成员方法就是一个Method对象
	 * getMethods()方法获取的是所有的public的函数(公共 member方法)，包括父类继承而来的
	 */ 
	
	System.out.println("\n\nMethod:\n\n");
	for(Method m : mt)
	{
		System.out.print(m.getName()+"注解:  ");
		boolean MethodIsExist = m.isAnnotationPresent(Description.class);
		if(MethodIsExist)
	    {
	       Description d = (Description)m.getAnnotation(Description.class);
	       System.out.print(d.value());
	    }
		System.out.println();
	}
	
	
	System.out.println("\n\nAnnotation[] at = m.getAnnotations():\n\n");
	for(Method m : mt)
	{
		System.out.print(m.getName()+"注解:  ");
		
		Annotation[] at = m.getAnnotations();
		
		for(Annotation a : at)
		{
			if(a instanceof Description)//A是Description的实例
			{
				Description d = (Description)a;
				System.out.print(d.value());
			}
		}
		System.out.println();
	}
	
	}
}
