package com.example.demo8.Dao;

import com.example.demo8.Connection;
import com.example.demo8.Model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao implements IUserDao{
    @Override
    public void addUser(User user) throws SQLException, ClassNotFoundException {
                String query="insert into users(userName,password,gender,birthdate,phoneNumber) values (?,?,?,?,?)";

        PreparedStatement preparedStatement = Connection.connection().prepareStatement(query);
        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getGender());
        preparedStatement.setDate(4, new java.sql.Date(user.getBirthdate().getTime()));
        preparedStatement.setInt(5,user.getPhoneNumber());
        preparedStatement.executeUpdate();


    }
    }



