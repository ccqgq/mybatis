package com.fwpt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fwpt.mapper.StudentMapper;
import com.fwpt.po.Student;
import com.fwpt.service.StudentService;

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

}
