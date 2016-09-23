package Romberg;

import java.util.Scanner;


	public class Test
	{

	    public static void main(String[] args)
	    {
	        double a, b;
	        @SuppressWarnings("resource")
	        Scanner p=new Scanner(System.in);
	        System.out.println("Romberg积分,请输入积分范围a:");
	        a=p.nextDouble();
	        System.out.println("Romberg积分,请输入积分范围b:");
	        b=p.nextDouble();
	        System.out.println("积分结果:");
	        System.out.println(romberg.Romberg(a, b));
	    }

	}
