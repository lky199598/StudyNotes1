package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Grade implements Serializable {

	private int grade_ID;
	
	private String name;
	private int number;
	// 在一方定义一个多方的集合
	
	private Set<Student> student=new HashSet<Student>();

	public Grade() {
		super();
	}
	
	public Grade(int grade_ID, String name, int number, Set<Student> student) {
		super();
		this.grade_ID = grade_ID;
		this.name = name;
		this.number = number;
		this.student = student;
	}

	public int getGrade_ID() {
		return grade_ID;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setGrade_ID(int grade_ID) {
		this.grade_ID = grade_ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Grade [grade_ID=" + grade_ID + ", name=" + name + ", number="
				+ number + ", student=" + student + "]";
	}

}
