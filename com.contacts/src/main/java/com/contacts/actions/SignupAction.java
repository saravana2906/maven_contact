package com.contacts.actions;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.contacts.beans.User;
import com.contacts.dao.UserDao;
import com.contacts.dao.UserDaoImpl;
import com.contacts.forms.SignupForm;
import com.opensymphony.xwork2.ActionSupport;


public class SignupAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession ;
	
	private SignupForm signup;
	
	 public SignupForm getSignup() {
		return signup;
	}

	public void setSignup(SignupForm signup) {
		this.signup = signup;
	}

	public String execute() throws Exception {
	        
		User user=new User(signup);
		 UserDao userdao=new UserDaoImpl();
		 System.out.println(userSession.get("login"));
		 
	        if(!userdao.addUser(user))
	        {
	        	return ERROR;
	        }
	        return SUCCESS;
	    }
	public void validate()
	{
		
		if(signup.getUsername().length()==0)
		{
			addFieldError("signup.username","User name is required");
		}
		if((signup.getEmailid().length()==0))
		{
			addFieldError("signup.emailid","Email ID is required");
		}
		 
		if(signup.getPassword().length()==0)
		{
			addFieldError("signup.password","Password is required");
		}
		if(signup.getConfirmpassword().length()==0)
		{
			addFieldError("signup.confirmpassword","Confirm Password is required");
		}

				if(!(signup.getPassword().equals(signup.getConfirmpassword())))
				{
					addFieldError("signup.confirmpassword","Password is not matcahed");
				}
	}

	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
		
	}
	
	
	

}
