package com.qgq.mybatis01;

import java.io.IOException;
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

import sun.misc.Resource;

public class Test1 {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		//配置文件的路径
		String path="SqlMapConfig.xml";
		//加载配置文件
		InputStream inputStream=Resources.getResourceAsStream(path);
		//创建回话工厂
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	/*
	 * 根据id查询
	 */
	@Test
	public void findUserById(){
		//通过sqlSessionFactory构建sqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=null;
		//selectOne的第一个参数：sql语句的位置,namespace+id的路径，第二个参数为传入的参数
		user=sqlSession.selectOne("test.findUserById", 2);
		sqlSession.close();
		System.out.println(user);
	}
	
	/*
	 * 通过username模糊查询
	 */
	@Test
	public void findUserByUsername(){
		//通过sqlSessionFactory创建sqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<User> list=null;
		try {
			list=sqlSession.selectList("test.findUserByUsername", "红");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(list);
	}
	
	/*
	 * 向数据库中添加一条数据
	 */
	@Test
	public void insertUser(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user =new User();
		user.setUsername("cc");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("商洛");
		
		try {
			sqlSession.insert("test.insertUser",user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
	/*
	 * 根据id删除一条数据
	 */
	@Test
	public void delUserById(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			sqlSession.delete("test.delUserByID", 2);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	/*
	 * 修改用户的信息
	 */
	@Test
	public void updataUser(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user =new User();
		//设置需要修改的user信息，包括id
		user.setId(4);
		user.setAddress("海南");
		user.setSex("女");
		user.setUsername("ggg");
		try {
			int x=sqlSession.update("test.updataUser",user);
			sqlSession.commit();
			System.out.println(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
