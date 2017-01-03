package com.fwpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fwpt.mapper.StudentMapper;
import com.fwpt.po.Bean;
import com.fwpt.po.Student;
import com.fwpt.service.StudentService;
import com.fwpt.utils.PageBean;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			readOnly = true, timeout = 5)
	public Student login(String number, String password) {
		Student student = new Student();
		student.setNumber(number);
		student.setPassword(password);
		return studentMapper.login(student);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public PageBean<Student> findStudent(String number, String name, Integer page) {
		Bean bean = new Bean();
		bean.setName(name);
		bean.setNumber(number);
		PageBean<Student> pageBean = new PageBean<>();
		if(page == null){
			page = 1;
		}
		pageBean.setPage(page);
		Integer limit = 1;
		Integer totalpage = 0;
		pageBean.setLimit(limit);
		Integer totalcount  = count(bean);
		int begin = (page-1)*limit;
		bean.setBegin(begin);
		bean.setLimit(limit);
		pageBean.setTotalCount(totalcount);
		//封装总页数
		if(totalcount % limit == 0){
			totalpage = totalcount/limit;
		}else {
			totalpage = totalcount / limit+1;
		}
		pageBean.setTotalPage(totalpage);
		List<Student> list = studentMapper.findStudent(bean);
		System.err.println("<============"+list.get(0).getName());
		pageBean.setList(list);
		return pageBean;
	}

	private Integer count(Bean bean) {
		int i = studentMapper.count(bean);
		System.out.println("============>"+i);
		return i;
	}

}
