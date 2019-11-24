package com.scmpi.book.service.impl;

import java.sql.ResultSet;

import com.scmpi.book.dao.*;
import com.scmpi.book.dao.impl.*;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.UserService;
import com.scmpi.book.util.DBUtil;
public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    /**
     * 登录
     */
	public User login(String name, String password) throws Exception{
		User u=dao.queryByName(name);
		if(u!=null){
			if(u.getUpasswd().equals(password)){
				return u;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	/**
	 * 添加用户信息
	 */
	public void addUser(User u) throws Exception {
		
		dao.addUser(u);
	}
	@Override
	public User getUser(int uid) throws Exception {
		// TODO 自动生成的方法存根
		//查询用户信息
		User u = null;
		String sql = "select * from `user` where `uid` = "+uid+";";
		ResultSet rs = DBUtil.queryData(sql);
		while(rs.next()){
			u = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("upasswd"), rs.getString("uemail"), rs.getString("usex"), rs.getString("birthday"), rs.getString("uphone"), rs.getString("uaddress"), rs.getFloat("balance"), rs.getInt("discount"), rs.getInt("integral"));
		}
		
		return u;
	}
	@Override
	public int getUserCount() throws Exception {
		// TODO 自动生成的方法存根
		//获取总用户数量
		int count =0;
		String sql = "select count(*)Alluser from `user`;";
		
		ResultSet rs = DBUtil.queryData(sql);
		
		while(rs.next()){
			count= rs.getInt("Alluser");
		}
		return count;
	}

}
