package com.contacts.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//preprocessing
	System.out.println("Pre-processing");
	Map<String, Object> session = ActionContext.getContext().getSession();
	if(session.get("login")==null)
	{
		session.put("login", "false");
	}
	System.out.println(session.get("login").toString()+"  "+ActionContext.getContext().getName());
	if(session.get("login").equals("false") && (ActionContext.getContext().getName().contains("login") || ActionContext.getContext().getName().contains("signup") || ActionContext.getContext().getName().isEmpty()))
	{
		System.out.println(arg0.invoke());
	}
	else if(session.get("login").equals("true"))
	{
	arg0.invoke();
	}
	else
	{
		System.out.println("Invalid session");
		return "login";
	}
			System.out.println("Post-Processing");
		return "SUCCESS";
	}



}
