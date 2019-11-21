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

			String sql = "select * from cart_user where name='" + name + "'";
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {
				u.setUid(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setPostCode(rs.getString("postcode"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
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

			String sql = "update cart_user set address='" + u.getAddress()
					+ "',postcode='" + u.getPostCode() + "',email='"
					+ u.getEmail() + "',  phone='" + u.getPhone()
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

			String sql = "insert into cart_user(name,password,address,postcode,email,phone)values('"
					+ u.getName()
					+ "','"
					+ u.getPassword()
					+ "','"
					+ u.getAddress()
					+ "','"
					+ u.getPostCode()
					+ "','"
					+ u.getEmail() + "','" + u.getPhone() + "')";
			DBUtil.Update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
