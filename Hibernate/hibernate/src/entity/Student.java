package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Student implements Serializable {

	private int student_ID;
	
	private String name;
	private String sex;

	// 在多方定义一个一方的引用

	private Grade grade;

	public Student() {
		super();
	}

	public Student(int student_ID, String name, String sex, Grade grade) {
		super();
		this.student_ID = student_ID;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
	}

	public int getStudent_ID() {
		return student_ID;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [student_ID=" + student_ID + ", name=" + name
				+ ", sex=" + sex + ", grade=" + grade + "]";
	}

	
}
