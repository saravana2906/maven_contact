package com.contacts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.contacts.beans.User;
import com.contacts.util.DatabaseUtil;

public class UserDaoImpl implements UserDao {


	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		String addUserQuery="insert into users values(null,?,?,?,?,now(),now());";
		try
		{
		PreparedStatement statement = con.prepareStatement(addUserQuery);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getEmailid());
		statement.setString(4, user.getPhoneno());
		int rows=statement.executeUpdate();
		
	System.out.println("Rows inserted sars "+ rows);
		}
		catch(Exception e){
			
			e.printStackTrace();
			return false;
			
		}
		
		
		return true;
	}


	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	public User getUser(String emailid) {
		// TODO Auto-generated method stub
		Connection con=DatabaseUtil.getConnection();
		String getUserQuery="select * from users where email_id=?";
		ResultSet rs;
		User user=new User();
try
{
	PreparedStatement statement = con.prepareStatement(getUserQuery);
	statement.setString(1,emailid);
	rs=statement.executeQuery();
	rs.next();
	user.setUserid(rs.getLong(1));
	user.setUsername(rs.getString(2));
	user.setPassword(rs.getString(3));
	user.setEmailid(rs.getString(4));
	user.setPhoneno(rs.getString(5));
	
}
catch(Exception e)
{
	e.printStackTrace();
	return null;
}
		
		return user;
	}
	
}
