package com.chelseaUniversity.ver1.service;

import com.chelseaUniversity.ver1.model.Student;
import com.chelseaUniversity.ver1.repository.StudentRepositoryImpl;
import com.chelseaUniversity.ver1.repository.interfaces.StudentRepository;

public class UserService {
	
	StudentRepository studentRepository = new StudentRepositoryImpl();
	
	/**
	 * 학생 조회
	 * 
	 * @param studentId
	 * @return studentEntity
	 */
	public Student readStudent(Integer studentId) {
		Student studentEntity = studentRepository.selectByStudentId(studentId);
		return studentEntity;
	}
	
}
