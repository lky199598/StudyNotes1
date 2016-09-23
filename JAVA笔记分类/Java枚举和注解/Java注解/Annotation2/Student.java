package Annotation2;

@Table("Student")
public class Student {
    
	@Column("userID")
	private String userID;
	
	@Column("email")
	private String email;//µÇÂ¼ÃÜÂë

	@Column("cla")
	private char cla;

	@Column("age")
	private int age;
	
	@Column("sex")
	private boolean sex;//true:ÄÐ£»false:Å®
    
	@Column("score")
	private double score;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public char getCla() {
		return cla;
	}

	public void setCla(char cla) {
		this.cla = cla;
	}
	
	public static void main(String[] args)
	{
		Student stu = new Student();

		System.out.println("int: "+stu.getAge());
		System.out.println("double: "+stu.getScore());
		System.out.println("boolean: "+stu.isSex());
	}
	
}
