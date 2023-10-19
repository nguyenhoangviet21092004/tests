package com.example.demo8.Controler;


import com.example.demo8.Dao.UserDao;
import com.example.demo8.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name ="UserServlet" ,value = "/UserServlet")
public class UserServlet extends HttpServlet {
    public static UserDao userDao;

    @Override
    public  void init() throws ServletException {
        userDao=new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "addUser":
                try {
                    addUser(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
//vị trí màn hình thêm
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        allHome(req,resp);
    }
    public static void allHome(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("LoginUpdate.jsp").forward(request, response);
    }
    public static void addUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String fullName=request.getParameter("fullName");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String confirmPassword=request.getParameter("confirmPassword");
        if (password!=confirmPassword){
            System.out.println("mật khẩu sai ");
        }else {
            String gender=request.getParameter("gender");
            String birthdateString=request.getParameter("birthdate");
            int phoneNumber= Integer.parseInt(request.getParameter("phoneNumber"));
            System.out.println(userName+password+gender+birthdateString+phoneNumber);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdate = null;
            try {
                birthdate = sdf.parse(birthdateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            userDao.addUser(new User(fullName,userName,password,gender,birthdate,phoneNumber));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }}
}

