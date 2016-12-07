package com.qgq.mybatis2;

import com.qgq.po.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;
}
