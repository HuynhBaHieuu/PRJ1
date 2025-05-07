/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author OS
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/process"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (username.isEmpty() || username.isBlank() || password.isEmpty() || password.isBlank()) {
            message = "Please enter all field of login form";
        } else if ("Admin".equals(username) && "123".equals(password)) {
            request.setAttribute("name", username);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            message = "<h2>Login Failed!!</h2>";
        }
        request.setAttribute("message_error", message); // tạo một cái thùng trước khi bắn sang trang jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
