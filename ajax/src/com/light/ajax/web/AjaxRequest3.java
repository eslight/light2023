package com.light.ajax.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ajax3")
public class AjaxRequest3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        System.out.println(user);
        out.print(user);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        System.out.println(user);
        out.print(user);
    }
}
