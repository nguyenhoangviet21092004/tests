package com.example.demo8.controller;

import com.example.demo8.model.Student;
import com.example.demo8.service.IStudentDAO;
import com.example.demo8.service.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    IStudentDAO iStudentDAO = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create" :
                    createStudent(request,response);
                    break;
                case "edit" :
                    editStudent(request,response);
                    break;
                case "delete" :
                 //   deleteStudent();
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String nameEdit = request.getParameter("nameEdit");
        String emailEdit = request.getParameter("emailEdit");
        String sexEdit = request.getParameter("sexEdit");
        int id = Integer.parseInt(request.getParameter("idEdit"));
        Student students = new Student(id,nameEdit,emailEdit,sexEdit);
        iStudentDAO.editStudent(students);
        RequestDispatcher dispatcher =  request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request,response);

    }

    private void createStudent(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Student students = null;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        students = new Student(name,email,sex);
        iStudentDAO.createStudent(students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
                default:
                    selectListStudent(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void selectListStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        List<Student> list = iStudentDAO.selectAllStudent();
        request.setAttribute("listStudent",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response){

    }
}
