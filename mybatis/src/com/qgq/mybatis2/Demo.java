package com.qgq.mybatis2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qgq.po.User;

public class Demo {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init ( ) throws Exception{
		//配置文件的路径
		String path="SqlMapConfig.xml";
		//加载配置文件
		InputStream inputStream=Resources.getResourceAsStream(path);
		//获得sqlSessionFactory
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findUserById() throws Exception{
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user=userDao.findUserById(1);
		System.out.println(user);
	}
}
