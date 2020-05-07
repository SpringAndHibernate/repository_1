package by.tms.service;

import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

public class StudentService {

	public static void main(String[] args) {

		StudentService studentService = new StudentService();
		//studentService.add("student12", "student12", "student12", "faculty12", "group12");

	}

		private StudentStorage studentStorage = new StudentStorage();

		/*public boolean add (String name, String login,
				String password, String faculty,
				String group){
			if (studentStorage.containsLogin(login)) {
				Student student = new Student(name, login, password, faculty, group);
				student.setLogin(student.getLogin().toUpperCase());
				studentStorage.save(student);
				return true;
			}return false;
		}*/
}
