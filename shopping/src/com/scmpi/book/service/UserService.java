package com.scmpi.book.service;
import java.util.List;

import com.scmpi.book.entity.*;
public interface UserService {
	public User login(String name,String password)throws Exception;
	public void addUser(User u)throws Exception;
	public User getUser(int uid) throws Exception;
	public int getUserCount() throws Exception;
	public List<User> queryAllUser()throws Exception;
}
