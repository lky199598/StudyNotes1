package JavaBean;

import java.sql.Blob;
import java.util.Date;

public class Student {

	private int id;
	private String name;
	private Date date;
	private Address addr;
	
	public Student(){}


	public Student(int id, String name, Date date, Address addr) {

		this.id = id;
		this.name = name;
		this.date = date;
		this.addr = addr;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", date=" + date
				+ ", addr=" + addr + "]";
	}


}
