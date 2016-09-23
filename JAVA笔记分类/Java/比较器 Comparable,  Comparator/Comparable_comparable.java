package com;

import java.util.Iterator;
import java.util.TreeSet;


public class Comparable_comparable {
	public static void main(String[] args) {
		 TreeSet<Point> ts = new TreeSet<Point>();
		 ts.add(new Point(1, 7));
		ts.add(new Point(2, 3));
		ts.add(new Point(1, 7));
		ts.add(new Point(8, 8));
		ts.add(new Point(1, 3));
		ts.add(new Point(0, 4));
		ts.add(new Point(8, 9));
		ts.add(new Point(2, 3));
		
		Iterator i = ts.iterator(); // µü´úÆ÷
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}

class Point implements Comparable
{
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point() {
		this.x = this.y = 0;
	}

public int compareTo(Object o)
{
	Point p = (Point)o;
	int num=x>p.x ? 1:(x==p.x ? 0:-1);
	
	if(num==0)
		return y>p.y ? 1:(y==p.y ? 0:-1);
	
		return num;
}

	public String toString() {
		return "x=" + x + ",y=" + y;
	}
}
