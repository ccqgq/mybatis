package com.fwpt.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwpt.po.Admin;
import com.fwpt.po.Student;
import com.fwpt.po.Teacher;
import com.fwpt.service.AdminService;
import com.fwpt.service.StudentService;
import com.fwpt.service.TeacherService;
import com.fwpt.service.impl.AdminServiceImpl;
import com.fwpt.service.impl.StudentServiceImpl;
import com.fwpt.service.impl.TeacherServiceImpl;
import com.fwpt.utils.SessionUtils;


@Controller
public class UserController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	/**
	 * 跳转到登录页面
	 * @return：跳转的路径
	 */
	@RequestMapping(value="")
	public String index(){
		return "/web/index.html";
	}
	
	/**
	 * 用户登录
	 * @param number：帐号
	 * @param password：密码
	 * @param juese：角色
	 * @return：返回登陆的辨识
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Object login(String number,String password,String juese,
			HttpSession session){
		if(juese.equals("student")){
			Student student=studentServiceImpl.login(number,password);
			juese=SessionUtils.set(session,student,juese);
		}
		if(juese.equals("teacher")){
			Teacher teacher=teacherServiceImpl.login(number,password);
			juese=SessionUtils.set(session, teacher, juese);
		}
		if(juese.equals("admin")){
			Admin admin=adminServiceImpl.login(number,password);
			juese=SessionUtils.set(session, admin, juese);
		}
		return juese;
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET )
	public String logout(HttpSession session,String juese){
		session.removeAttribute(juese);
		System.out.println("11111111");
		return "/web/index.html";
	}
	
	@RequestMapping(value="getSession")
	@ResponseBody
	public Admin session(HttpSession session,String juese){
		System.out.println(juese);
		Admin admin=(Admin) session.getAttribute(juese);
		System.out.println(admin);
		return admin;
	}
	
}
