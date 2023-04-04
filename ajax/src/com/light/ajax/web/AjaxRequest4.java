package com.light.ajax.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet("/ajax4")
public class AjaxRequest4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("name");
        out.print("{\"uname\":\""+uname.toUpperCase(Locale.ROOT)+"\"}");
    }
}
