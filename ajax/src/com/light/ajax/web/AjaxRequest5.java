package com.light.ajax.web;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet("/ajax5")
public class AjaxRequest5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        String code1 = request.getParameter("code");
        PrintWriter out = response.getWriter();
        Connection conn=null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        List<Area> list =new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");
            if (code1==null) {
                String sql="select  code,name from t_area where pcode is null";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
            }else {
                String sql="select code,name from t_area where pcode =?";
                ps=conn.prepareStatement(sql);
                ps.setString(1,code1);
                rs=ps.executeQuery();
            }

            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area area = new Area(code,name);
                list.add(area);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps!=null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        String json = JSON.toJSONString(list);
        out.print(json);
    }
}
