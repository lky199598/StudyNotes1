package Emp;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {
	private Integer id;
	private String name;
	private String department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	public int hashCode() {
		// TODO Auto-generated method stub
		/*System.out.println("\n1: " + this.getId() + this.getName().hashCode());
		System.out.println("2: " + (this.getId() + this.getName()).hashCode());*/

		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Employee e = (Employee) o;
		return (this.getId() == e.getId());
	}

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e11=e1;
		
		System.out.println("e1==e2: "+(e1==e2));
		
		System.out.println("e1.equals(e2): "+e1.equals(e2)+"\n");
		
		System.out.println("e1.getClass(): "+e1.getClass()+"\te2.getClass(): "+e2.getClass()+"\n");
		
		e1.setId(100);
		e1.setName("aaa");
		
		e2.setId(100);
		e2.setName("bbb");
		
		System.out.println("e1==e2: "+(e1==e2));
		
		e3.setId(200);
		e3.setName("bbb");
		
		// Prints 'true'
//Set集合是无序的、没有重复项目的集合;  List是位置性集合，加进清单的元素可以加在清单中特定位置或加到末尾，可以保存重复的元素
		Set<Employee> e = new HashSet<Employee>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		// Prints two objects
		System.out.println("e1.equals(e2): "+e1.equals(e2)+"\n");
		System.out.println(e+"\n");
		
		System.out.println("\nHashSet:");
		System.out.println("size: "+e.size());
		for(Employee i:e)
			System.out.print(i.getId()+"\t"+i.getName()+"\t");
		
		System.out.println("\n\nArrayList:");
		List<Employee> em = new ArrayList<Employee>();
		em.add(e1);
		em.add(e2);
		em.add(e3);
		
		System.out.println("size: "+em.size());
		for(Employee i:em)
			System.out.print(i.getId()+"  "+i.getName()+"\t");
				
	}

}