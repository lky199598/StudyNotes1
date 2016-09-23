package bean;

import java.util.List;

public class User {
	
	private String username;
	private String password;
	private int age;
	
	private List<String> bookList;
	private List<User> userBookList;
	
	public User(){}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getBookList() {
		return bookList;
	}

	public void setBookList(List<String> bookList) {
		this.bookList = bookList;
	}

	public List<User> getUserBookList() {
		return userBookList;
	}

	public void setUserBookList(List<User> userBookList) {
		this.userBookList = userBookList;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
}
