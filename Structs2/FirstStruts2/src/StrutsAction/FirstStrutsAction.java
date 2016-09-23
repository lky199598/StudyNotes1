package StrutsAction;

import com.opensymphony.xwork2.ActionSupport;

public class FirstStrutsAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("FirstStrutsAction");
		return SUCCESS;		
	}
	
	public String add() {
		System.out.println("add");
		return "add";
	}
	
	public String update() {
		System.out.println("update");
		return "update";
		
	}
	
	public String error() {
		System.out.println("error");
		return "error";
		
	}
}
