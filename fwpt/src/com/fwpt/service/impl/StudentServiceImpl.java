package com.fwpt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fwpt.mapper.StudentMapper;
import com.fwpt.po.Student;
import com.fwpt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	public Student login(String number, String password) {
		
		return null;
	}

}
