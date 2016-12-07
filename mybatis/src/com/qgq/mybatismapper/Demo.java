package com.qgq.mybatismapper;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.qgq.po.User;

public class Demo {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception{
		String path="SqlMapConfig.xml";
		//加载配置文件
		InputStream inputStream =Resources.getResourceAsStream(path);
		//获得sqlSessionFactory
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/*
	 * 根据id查询
	 */
	@Test
	public void findUserById() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=sqlSession.selectOne("com.qgq.mybatismapper.UserMapper.findUserById", 1);
		sqlSession.close();
		System.out.println(user);
	}
	
	/*
	 * 根据username模糊查询
	 */
	@Test
	public void fingUserByUsername() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<User> list=sqlSession.selectList("com.qgq.mybatismapper.UserMapper.findUserByUsername", "%啦%");
		sqlSession.close();
		System.out.println(list);
	}
	
	@Test
	public void insert() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=new User();
		user.setAddress("ccc");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setUsername("qgq");
		sqlSession.insert("com.qgq.mybatismapper.UserMapper.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	/*
	 * 获得所有的数据个数
	 */
	@Test
	public void count() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int i=sqlSession.selectOne("com.qgq.mybatismapper.UserMapper.count");
		sqlSession.close();
		System.out.println(i);
	}
}
