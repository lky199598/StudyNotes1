package Annotation;

import java.util.Date;

public class User {
	private byte a;
	private char b;
	private short c;
	
	private int d;
	private long e;
	private float f;
	private double g;
	private boolean h;

	
	
	public byte getA() {
		return a;
	}



	public void setA(byte a) {
		this.a = a;
	}



	public char getB() {
		return b;
	}



	public void setB(char b) {
		this.b = b;
	}



	public short getC() {
		return c;
	}



	public void setC(short c) {
		this.c = c;
	}



	public int getD() {
		return d;
	}



	public void setD(int d) {
		this.d = d;
	}



	public long getE() {
		return e;
	}



	public void setE(long e) {
		this.e = e;
	}



	public float getF() {
		return f;
	}



	public void setF(float f) {
		this.f = f;
	}



	public double getG() {
		return g;
	}



	public void setG(double g) {
		this.g = g;
	}



	public boolean isH() {
		return h;
	}



	public void setH(boolean h) {
		this.h = h;
	}



	public static void main(String[] args) {
		User user = new User();
		System.out.println("byte: "+user.getA());
		System.out.println("char: "+user.getB());
		System.out.println("short: "+user.getC());
		System.out.println("int: "+user.getD());
		System.out.println("long: "+user.getE());
		System.out.println("float: "+user.getF());
		System.out.println("double: "+user.getG());
		System.out.println("boolean: "+user.isH());
		
		if(user.getB() == '\0')
			System.out.println("\nchar默认初始化值: '\\0' ");
		
		if(user.getF() == 0)
			System.out.println("\nfloat默认初始化值: 0 ");
		
		if(user.getF() == 0.0)
			System.out.println("\nfloat默认初始化值: 0.0 ");
	}

}
