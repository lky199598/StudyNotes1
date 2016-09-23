package Emp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class set {
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

	
	/*public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("\n1: " + this.getId() + this.getName().hashCode());
		System.out.println("2: " + (this.getId() + this.getName() ).hashCode());

		return this.getId().hashCode();
	}

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
		set e = (set) o;
		return (this.getId() == e.getId());
	}*/

	public static void main(String[] args) {
		set e1 = new set();
		set e2 = new set();
		set e3 = new set();
		
		e1.setId(100);
		e1.setName("aaa");
		
		e2.setId(100);
		e2.setName("bbb");
		
		e3.setId(200);
		e3.setName("bbb");
		
//Set集合是无序的、没有重复项目的集合;  List是位置性集合，加进清单的元素可以加在清单中特定位置或加到末尾，可以保存重复的元素
		Set<set> e = new HashSet<set>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e1);
		
		
		// Prints two objects
		System.out.println("e1.equals(e2): "+e1.equals(e2)+"\n");
		System.out.println(e+"\n");
		
		System.out.println("\nHashSet:");
		System.out.println("size: "+e.size());
		for(set i:e)
			System.out.print(i.getId()+"\t"+i.getName()+"\t");
		
		System.out.println("\n\nArrayList:");
		List<set> em = new ArrayList<set>();
		em.add(e1);
		em.add(e2);
		em.add(e3);
		em.add(e1);
		System.out.println("size: "+em.size());
		for(set i:em)
			System.out.print(i.getId()+"  "+i.getName()+"\t");
				
	}

}
