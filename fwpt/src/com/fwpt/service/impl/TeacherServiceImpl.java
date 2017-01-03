package com.fwpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fwpt.mapper.TeacherMapper;
import com.fwpt.po.Bean;
import com.fwpt.po.Teacher;
import com.fwpt.service.TeacherService;
import com.fwpt.utils.PageBean;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Transactional(propagation  = Propagation.REQUIRED, readOnly = true,timeout = 5)
	public Teacher login(String number, String password) {
		Teacher teacher = new Teacher();
		teacher.setNumber(number);
		teacher.setPassword(password);
		return teacherMapper.login(teacher);
	}

/*	page;// 当前页数.
	 limit;// 每页显示记录数
	totalCount;// 总记录数
	 totalPage;// 总页数.
	 list; // 显示到浏览器的数据.
*/	
	@Transactional(propagation = Propagation.REQUIRED)
	public PageBean<Teacher> findTeacher(String number, String name, Integer page) {
		Bean bean = new Bean();
		bean.setName(name);
		bean.setNumber(number);
		PageBean<Teacher> pageBean = new  PageBean<Teacher>();
		if(page == null){
			page = 1;
		}
		pageBean.setPage(page);
		Integer limit = 10;
		Integer totalpage = 0;
		pageBean.setLimit(limit);
		Integer totalcount = count(bean);

		int begin = (page-1)*limit;
		bean.setBegin(begin);
		bean.setLimit(limit);
		pageBean.setTotalCount(totalcount);
		//封装总页数
		if(totalcount % limit == 0){
			totalpage = totalcount/limit;
		}else {
			totalpage = totalcount / limit + 1;
		}
		pageBean.setTotalPage(totalpage);
		List<Teacher> list = teacherMapper.findTeacher(bean);
		pageBean.setList(list);
		return pageBean;
	}

	private Integer count(Bean bean) {
		int i= teacherMapper.count(bean);
		return i;
	}
	
	@Transactional
	public void del(Integer id) {
		
		teacherMapper.del(id);
		//还要删除关联教师的课程计划以及课程
	}
	
	@Transactional
	public void add(Teacher teacher) {
		teacher.setPassword(teacher.getNumber());
		teacherMapper.add(teacher);
	}



}
