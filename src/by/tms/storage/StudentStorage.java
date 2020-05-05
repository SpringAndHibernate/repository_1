package by.tms.storage;

import by.tms.domain.Student;
import by.tms.util.Reader;
import by.tms.util.Writer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentStorage {

	public static void main(String[] args) {
		StudentStorage studentStorage = new StudentStorage();

		//studentStorage.save(new Student("Pavel","pavvel","qwerty","faculty1","group1"));
		//studentStorage.save(new Student("test","tesst","zxcvb","faculty5","group206"));
		//studentStorage.save(new Student("student1","student","belarus","faculty11","group4"));

		//studentStorage.getStudentByLogin("pavvel");
		//studentStorage.getStudentByLogin("tesst");
		//studentStorage.getStudentByLogin("student");

		//studentStorage.updateLogin("tesst",19);
		//studentStorage.updatePassword("zxcvb",19);

		//studentStorage.remove(21);

		//studentStorage.getAll();
	}

	public boolean save(Student student){

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into students values (default ,?,?,?,?,?)");

			preparedStatement.setString(1,student.getName());
			preparedStatement.setString(2,student.getLogin());
			preparedStatement.setString(3,student.getPassword());
			preparedStatement.setString(4,student.getFaculty());
			preparedStatement.setString(5,student.getGroup());
			preparedStatement.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Student getStudentByLogin(String login){
		String student_name = null;
		String student_login = null;
		String student_password = "secret password";
		String student_faculty = null;
		String student_group = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select *from students where login = ?");
			preparedStatement.setString(1,login);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				student_name = resultSet.getString(2);
				student_login = resultSet.getString(3);
				student_faculty = resultSet.getString(5);
				student_group = resultSet.getString(6);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Student student = new Student(student_name, student_login,student_password,student_faculty, student_group);
		System.out.println(student);
		return student;
	}

	public Student updateLogin(String login,int id){

		String newStudentLogin = null;

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("update students set login = ? where id = ?");
			preparedStatement.setString(1,login);
			preparedStatement.setInt(2,id);

			preparedStatement.executeUpdate();
			if (containsId(id)){
				Writer.write("Введите новый login ");
				newStudentLogin = Reader.readString();
				preparedStatement.setString(1,newStudentLogin);
				System.out.println("Новый login: " + newStudentLogin);
				preparedStatement.execute();

			} else {
				System.out.println("Такого id не существует ");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Student();
	}

	public boolean containsId(int id){
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("select *from students where id = ?");
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void remove(int id){

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from students st where st.id = ?");
			preparedStatement.setInt(1,id);
			boolean resultSet = preparedStatement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student updatePassword(String password,int id){

		String newStudentPassword = null;

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			PreparedStatement preparedStatement = connection.prepareStatement("update students set password = ? where id = ?");
			preparedStatement.setString(1,password);
			preparedStatement.setInt(2,id);

			preparedStatement.executeUpdate();
			if (containsId(id)){
				Writer.write("Введите новый password ");
				newStudentPassword = Reader.readString();
				preparedStatement.setString(1,newStudentPassword);
				System.out.println("Новый password: " + newStudentPassword);
				preparedStatement.execute();

			} else {
				System.out.println("Такого id не существует ");
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Student();
	}

	public List<Student> getAll(){

		List<Student> students = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_base");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select *from students");
			while (resultSet.next()){
				String name = resultSet.getString(2);
				String login = resultSet.getString(3);
				String password = resultSet.getString(4);
				String faculty = resultSet.getString(5);
				String group = resultSet.getString(6);
				Student student = new Student(name, login, password, faculty, group);
				students.add(student);
			}


			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(students);
		return students;
	}
}
