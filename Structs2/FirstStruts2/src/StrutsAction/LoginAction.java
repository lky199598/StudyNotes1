package StrutsAction;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public String loginSuccess() {
		 if(user.getUsername() == null ||"".equals(user.getUsername()))
		 {
	    	  this.addFieldError("username", "用户名不能为空");
		      return INPUT;
		 }
		
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("age: "+user.getAge());
		/*System.out.println("bookList[0]: "+user.getBookList().get(0));
		System.out.println("bookList[1]: "+user.getBookList().get(1));	
		
		System.out.println("userBookList[0].username: "+user.getUserBookList().get(0).getUsername());
		System.out.println("userBookList[1].username: "+user.getUserBookList().get(1).getUsername());	*/
		return "loginSuccess";
	}

	public String skipToLogin()
	{
		System.out.println("跳到登录页面");
		return "skipToLogin";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
/*	@Override
	public void validate() {
      if(user.getUsername() == null ||"".equals(user.getUsername()))
    	  this.addFieldError("username", "用户名不能为空");
	}*/
	
	
}
