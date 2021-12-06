package com.syt.Dao;

import com.syt.Entity.User;
import com.syt.Util.JdbcUtil;

import javax.print.attribute.standard.DocumentName;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //插入操作
    public int insert(User user){
        String sql = "insert into user(userRight,userName,userPassword) values(?,?,?)";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement car = null;
        int flag = 0;

        car =  util.getCar(sql);
        try {
            car.setString(1, user.getUserRight());
            car.setString(2, user.getUserName());
            car.setString(3, user.getUserPassword());
            flag = car.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }

        return flag;
    }

    //删除操作
    public int delete(String userName){
        String sql = "delete from user where userName=?";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement car = null;
        int flag = 0;

        car =  util.getCar(sql);
        try {
            car.setString(1, userName);
            flag = car.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return flag;
    }

    //更新操作
    public int update(String userName,String userPassword){
        String sql = "update user set userPassword=? where userName=?";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement car = null;
        int flag = 0;

        car =  util.getCar(sql);
        try {
            car.setString(1, userPassword);
            car.setString(2, userName);
            flag = car.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return flag;
    }

    //查询操作（所有用户）
    public List findAll(){
        String sql = "select * from user";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement car = null;
        ResultSet table = null;
        List list = new ArrayList();

        car =  util.getCar(sql);
        try {
            table = car.executeQuery();
            //数据交接
            while (table.next()) {
                String userRight = table.getString("userRight");
                String userName = table.getString("userName");
                String userPassword = table.getString("userPassword");
                User user = new User(userRight, userName, userPassword);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            util.close();
        }
        return list;
    }
}
