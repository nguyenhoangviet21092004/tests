package com.example.demo8.service;

import com.example.demo8.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private String URL = "jdbc:mysql://localhost:3306/demoStudent";
    private String userName = "root";
    private String passWord = "l";
    private final String SELECT_ALL_STUDENT = "SELECT * FROM student";
    private final String INSERT_INTO_STUDENT = "INSERT INTO student(name,email,sex) VALUES(?,?,?)";
    private final String UPDATE_VALUE_STUDENT = "UPDATE student SET name = ? , email = ?, sex = ?";

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, userName, passWord);
        return connection;
    }

    @Override
    public List<Student> selectAllStudent() throws SQLException, ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENT);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String sex = resultSet.getString("sex");
            studentList.add(new Student(id,name,email,sex));
        }
        return studentList;
    }

    @Override
    public void createStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENT);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getEmail());
        preparedStatement.setString(3,student.getSex());
        preparedStatement.executeUpdate();
    }

    @Override
    public void editStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VALUE_STUDENT);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getEmail());
        preparedStatement.setString(3,student.getSex());
        preparedStatement.executeUpdate();
    }
}
