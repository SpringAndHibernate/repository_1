package by.tms.domain;

import java.util.Objects;

public class Student {
	private long id;
	private String name;
	private String login;
	private String password;
	private String faculty;
	private String group;

	public Student() {
	}

	public Student(String name, String login, String password, String faculty, String group) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.faculty = faculty;
		this.group = group;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(login, student.login) &&
				Objects.equals(faculty, student.faculty) &&
				Objects.equals(group, student.group);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, faculty, group);
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", faculty='" + faculty + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}
