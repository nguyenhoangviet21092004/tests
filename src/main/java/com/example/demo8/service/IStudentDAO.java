package com.example.demo8.service;

import com.example.demo8.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    List<Student> selectAllStudent() throws SQLException, ClassNotFoundException;
    void createStudent(Student student) throws SQLException, ClassNotFoundException;
    void editStudent(Student student) throws SQLException, ClassNotFoundException;
}
