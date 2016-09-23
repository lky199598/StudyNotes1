package com.tiantian.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class logAction extends ActionSupport {
	private String account_name;
	private String password;
	private String identity;

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String log() {
		// System.out.println(account_name);
		// System.out.println(password);
		// System.out.println(identity);
		jdbcDao dao = new jdbcDao("tiantian");
		if (identity.equals("user")) {
			if (dao.Logging_User_or_Admin("user", account_name, password)) {
				System.out.println("账号密码已经匹配上了");
				ActionContext actionContext = ActionContext.getContext();
				Map session = actionContext.getSession();
				session.put("current_id", account_name);
				if(dao.User_information_null(account_name)){
					System.out.println("信息是空的，需要添加");
					return "user_success_nullInformation";
				}
				else{
					System.out.println("信息是好的，可以直接登录");
					return "user_success";
				}
			}
			else{
				System.out.println("用户名和密码没有匹配上");
				return "fail_log";
			}
		} else if (identity.equals("admin")) {
			if (dao.Logging_User_or_Admin("admin", account_name, password)) {
				ActionContext actionContext = ActionContext.getContext();
				Map session = actionContext.getSession();
				session.put("current_id", account_name);
				return "admin_success";
			}
		}
		return "fail_log";
	}
}
