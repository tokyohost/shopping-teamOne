package com.scmpi.book.dao;
import com.scmpi.book.entity.*;
public interface UserDao {
	public User queryByName(String name)throws Exception;
    public void updateUser(User u) throws Exception;
    public void addUser(User u)throws Exception;
}
