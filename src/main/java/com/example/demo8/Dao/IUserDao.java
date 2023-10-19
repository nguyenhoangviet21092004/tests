package com.example.demo8.Dao;

import com.example.demo8.Model.User;

import java.sql.SQLException;

public interface IUserDao {

    void addUser(User user) throws SQLException, ClassNotFoundException;
}