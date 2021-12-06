package com.syt.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {
    Connection con = null;
    PreparedStatement car = null;

    //获得连接通道
    public Connection getCon(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/syt", "root", "20001017");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    //获得交通工具
    public PreparedStatement getCar(String sql){
        try {
            car = getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    //销毁 Connection 和 PreparedStatement
    public void close(){
        if (car != null) {
            try {
                car.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
