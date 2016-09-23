package com;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class com_parator {
	public static void main(String args[]) {
		TreeSet<Student> ts = new TreeSet<Student>(new StudentComparator());
		ts.add(new Student("AAA", 88));
		ts.add(new Student("AAA", 98));
		ts.add(new Student("AAA", 90));

		ts.add(new Student("BBB", 88));
		ts.add(new Student("BBB", 80));

		Iterator<Student> i = ts.iterator();
		while (i.hasNext())
			System.out.println(i.next());

	}
}

class StudentComparator implements Comparator {
	public int compare(Object o1, Object o2) {

		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		int flag = s1.getGrade() > s2.getGrade() ? 1 : (s1.getGrade() == s2
				.getGrade() ? 0 : -1);
		if (flag == 0)
			return s1.getName().compareTo(s2.getName());
		return flag;
	}

}
