package com.example.demo8.Dao;

import com.example.demo8.Connection;
import com.example.demo8.Model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao implements IUserDao{
    @Override
    public void addUser(User user) throws SQLException, ClassNotFoundException {
                String query="insert into users(fullName,userName,password,gender,birthdate,phoneNumber) values (?,?,?,?,?,?)";



        PreparedStatement preparedStatement = Connection.connection().prepareStatement(query);
        preparedStatement.setString(1,user.getFullName());
        preparedStatement.setString(2,user.getUserName());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setString(4,user.getGender());
        preparedStatement.setDate(5, new java.sql.Date(user.getBirthdate().getTime()));
        preparedStatement.setInt(6,user.getPhoneNumber());
        preparedStatement.executeUpdate();


    }
    }



