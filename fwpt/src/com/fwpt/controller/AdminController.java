package com.fwpt.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwpt.po.Student;
import com.fwpt.po.Teacher;
import com.fwpt.service.impl.StudentServiceImpl;
import com.fwpt.service.impl.TeacherServiceImpl;
import com.fwpt.utils.PageBean;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private TeacherServiceImpl TeacherServiceImpl;
	
	@Autowired
	private StudentServiceImpl StudentServiceImpl;
	

	
	@RequestMapping(value= "tea")
	@ResponseBody
	public PageBean<Teacher> tea(String number , String name , Integer page) {
		System.out.println(number+name+page);
		PageBean<Teacher> pageBean = TeacherServiceImpl.findTeacher(number,name, page);
		return pageBean;
	}
	
	@RequestMapping(value="delTea")
	public String delTea(Integer id){
		TeacherServiceImpl.del(id);
		return "/web/admin/tea.html";
	}
	
	@RequestMapping(value="addTea",method=RequestMethod.POST)
	public String addTea(Teacher teacher) {
		TeacherServiceImpl.add(teacher);
		return "redirect:/web/admin/tea.html";
	}
	
	
	
	@RequestMapping(value="stu")
	@ResponseBody
	public PageBean<Student> stu(String number, String name, Integer page) {
		PageBean<Student> pageBean = StudentServiceImpl.findStudent(number,name,page);
		return pageBean;
	}
}
