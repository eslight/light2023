package com.light.ajax.web;

import com.light.ajax.utils.DBUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/ajax2")
public class AjaxRequest2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();
        String actno = request.getParameter("actno");
        if (actno!=null){
            PreparedStatement ps=null;
            ResultSet rs=null;
            try {
                Connection connection = DBUtils.getConnection();
                //获取数据库操作对象
                String sql="select actno from t_act where actno=?";

                ps = connection.prepareStatement(sql);
                ps.setString(1,actno);
                rs= ps.executeQuery();
                if (rs.next()){
                    out.print("用户名重复，请重新输入");

                    }else {
                    out.print("合法用户名");
                }



            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                DBUtils.close(null,ps,rs);
            }
        }else {
            out.print("用户名为空，请输入");
        }

    }
}
