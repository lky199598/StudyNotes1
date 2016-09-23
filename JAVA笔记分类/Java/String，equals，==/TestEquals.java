package com;

public class TestEquals {

	public static void main(String[] args)
	{
		String s1 = "aaa";
		String s2 = "aaa";
		String s3 = new String("aaa");
		
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1==s2);
		
		
		System.out.println(s1.equals(s3));
		
		System.out.println(s1==s3);
		
		System.out.println("\nint Integer: \n");
		int a = 3;
		int b = 3;
		Integer c = new Integer(3);
		Integer d = new Integer(3);
		
		System.out.println(a==b);		
		System.out.println(c==d);
		System.out.println(a==c.intValue());
		
		System.out.println(c.equals(d));
	
		
	}
}
