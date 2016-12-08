package com.qgq.mybatismapper;

import java.util.List;

import com.qgq.po.User;
import com.qgq.po.UserQueryVo;

public interface UserMapper {
	//根据用户的id查询用户
	public User findUserById(UserQueryVo userQueryVo) throws Exception;
	
	//根据username进行模糊查询
	public List<User> findUserByUsername(String username) throws Exception;

	//插入一个用户
	public void insertUser (User user) throws Exception; 
	
	//查询有多少用户
	public int count() throws Exception;
}
