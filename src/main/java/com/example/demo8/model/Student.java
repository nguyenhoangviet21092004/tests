package com.example.demo8.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

public class Student {
    private int id ;
    private String name;
    private String email;
    private String sex;

    public Student() {
    }

    public Student(int id, String name, String email, String sex) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public Student(String name, String email, String sex) {
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
