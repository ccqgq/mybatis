package com.fwpt.mapper;

import java.util.List;

import com.fwpt.po.Bean;
import com.fwpt.po.Teacher;

public interface TeacherMapper {
	public Teacher login(Teacher teacher);

	public List<Teacher> findTeacher(Bean bean);

	public int count(Bean bean);

	public void del(Integer id);

	public void add(Teacher teacher);
}
