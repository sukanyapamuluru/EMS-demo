package com.ciq.sms.dao;

import java.util.List;

import com.ciq.sms.model.Student;

public interface StuDao {
	
	void insert(Student student);
	
	void update(Student student);
	
	void delete (int SID);
	
	Student findById(int SID);
	
	List<Student> findAll();
	
	List<Student> findByName(String SNAME);	
	
}
