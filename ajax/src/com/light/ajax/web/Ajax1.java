package com.light.ajax.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ajax1")
public class Ajax1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("你好呀");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.print("用户名="+username+"<br>密码="+password);
    }
}
