package com.contacts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.contacts.beans.User;
import com.contacts.dao.UserDao;
import com.contacts.dao.UserDaoImpl;
import com.contacts.forms.LoginForm;
import com.contacts.util.MD5util;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession ;
	private LoginForm login;

	public String execute() throws Exception {
		
		UserDao userdao=new UserDaoImpl();
		User user=new User();
		user=userdao.getUser(login.getEmailid());
		if(user!=null)
		{
	if( MD5util.getMD5(login.getPassword()).equals(user.getPassword()))
	{
		userSession.put("login","true");
		userSession.put("name", user.getUsername());
		userSession.put("userid",Long.toString(user.getUserid()));
		System.out.println(userSession.get("login") + "  "+ userSession.get("name")+" "+userSession.get("userid"));
		return SUCCESS;
	}
	else
	{
		System.out.println("inside error 1");
		addActionError("Email Id or Password is in correct");
	}
		}
		else
		{
			System.out.println("inside error 2");
			addActionError("Email Id or Password is in correct");
		}
		
	return INPUT;
	}

	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession=session;
	}



	public LoginForm getLogin() {
		return login;
	}



	public void setLogin(LoginForm login) {
		this.login = login;
	}

}
