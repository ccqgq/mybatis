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
import com.qgq.po.UserCustom;
import com.qgq.po.UserQueryVo;

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
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setId(1);
		userQueryVo.setUserCustom(userCustom);
		User user=userMapper.findUserById(userQueryVo);
		System.out.println(user);
	}
	
	/*
	 * 根据username模糊查询
	 */
	@Test
	public void fingUserByUsername() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<User> list=userMapper.findUserByUsername("%g%");
		System.out.println(list);
	}
	
	@Test
	public void insert() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=new User();
		user.setUsername("张松");
		user.setBirthday(new Date());
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	/*
	 * 获得所有的数据个数
	 */
	@Test
	public void count() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int i=userMapper.count();
		sqlSession.close();
		System.out.println(i);
	}
}
