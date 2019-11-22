package com.scmpi.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.scmpi.book.dao.UserDao;
import com.scmpi.book.entity.User;
import com.scmpi.book.util.DBUtil;

public class UserDaoImpl implements UserDao {
	/**
	 * 按名称查询用户信息
	 */
	public User queryByName(String name) throws Exception {
		Connection con = null;
		Statement st = null;
		User u = new User();
		try {

			String sql = "select * from user where uname='" + name + "'";
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {
				u.setUid(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setUpasswd(rs.getString("upasswd"));
				u.setUemail(rs.getString("uemail"));
				u.setUsex(rs.getString("usex"));
				u.setBirthday(rs.getString("brithday"));
				u.setUphone(rs.getString("uphone"));
				u.setUaddress(rs.getString("uaddress"));
				u.setBalance(rs.getFloat("balance"));
				u.setDiscount(rs.getInt("discount"));
				u.setIntegral(rs.getInt("integral"));
				
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 更新用户信息
	 */
	public void updateUser(User u) throws Exception {

		try {

			String sql = "update user set uaddress='" + u.getUaddress()
					+ "',  uphone='" + u.getUphone()
					+ "' where id=" + u.getUid();
			System.out.println(sql);
			DBUtil.Update(sql);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * 添加用户信息
	 */
	public void addUser(User u) throws Exception {

		try {

			String sql = "insert into user(uname,upasswd,uemail,usex,uphone,uaddress,balance,discount,integral)values('"
					+ u.getUname()
					+ "','"
					+ u.getUpasswd()
					+ "','"
					+ u.getUemail()
					
					+ "','"
					+ u.getUsex()
					+ "','"
					+ u.getUphone()
					+ "','"
					+ u.getUaddress()
					+ "','" 
					+u.getBalance()
					+ "','"
					+u.getDiscount()
					+ "','"
					+ u.getIntegral()
					+ "')";
			DBUtil.Update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
