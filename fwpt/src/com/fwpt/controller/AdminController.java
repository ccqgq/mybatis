package com.fwpt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwpt.po.Admin;
import com.fwpt.po.Teacher;
import com.fwpt.service.impl.TeacherServiceImpl;
import com.fwpt.utils.PageBean;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private TeacherServiceImpl TeacherServiceImpl;
	

	
	@RequestMapping(value= "tea")
	@ResponseBody
	public PageBean<Teacher> tea(String number , String name , Integer page) {
		System.out.println(number+name+page);
		PageBean<Teacher> pageBean = TeacherServiceImpl.findTeacher(number,name, page);
		return pageBean;
	}
}
