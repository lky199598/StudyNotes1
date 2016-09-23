package com.reflect;

public class DynamicLoadingClass {

	public static void main(String[] args)
	{
/*int a, b,c;
		a=1;b=2;c=3;
		System.out.println(a);
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);*/
		
		
	try{ 		
		Class c = Class.forName(args[0]);
			Office o = (Office)c.newInstance();
			o.start();
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	}
}
