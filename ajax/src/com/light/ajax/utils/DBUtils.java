package com.light.ajax.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private  static  ResourceBundle bundle = ResourceBundle.getBundle("/resources/jdbc");
    private static String driver=bundle.getString("driver");
    private static String url=bundle.getString("url");
    private static String user=bundle.getString("user");
    private static String password=bundle.getString("password");
    private static ThreadLocal<Connection> local=new ThreadLocal();
    static {
        //类加载时注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = local.get();
        if (conn==null) {
            conn= DriverManager.getConnection(url,user,password);
            local.set(conn);
        }
        return conn;
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
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
                local.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
