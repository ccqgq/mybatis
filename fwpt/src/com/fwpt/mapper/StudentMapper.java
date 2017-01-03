package com.fwpt.mapper;

import java.util.List;

import com.fwpt.po.Bean;
import com.fwpt.po.Student;

public interface StudentMapper {
	public Student login(Student student);

	public List<Student> findStudent(Bean bean);

	public int count(Bean bean);
}
