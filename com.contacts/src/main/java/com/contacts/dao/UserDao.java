package com.contacts.dao;

import com.contacts.beans.User;

public interface UserDao {
	boolean addUser(User user);
	boolean updateUser(User user);
	User getUser(String emailid);

}
