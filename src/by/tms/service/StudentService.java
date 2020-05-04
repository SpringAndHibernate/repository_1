package by.tms.service;

import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

public class StudentService {
	private StudentStorage studentStorage = new StudentStorage();

	public boolean add(String name,
											String login,
											String password,
											String faculty,
											String group){
		Student student = new Student(name, login, password, faculty, group);
		student.setLogin(student.getLogin().toUpperCase());
		studentStorage.save(student);
		return false;
	}
}
