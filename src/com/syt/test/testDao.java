package com.syt.test;

import com.sun.source.tree.YieldTree;
import com.syt.Dao.UserDao;
import com.syt.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag =0;
        String userRight,userName,userPassword;
        UserDao dao = new UserDao();

        //循环操作：推出条件（flag=5)
        while (true) {
            //操作界面
            System.out.println("*****1.用户注册*****");
            System.out.println("*****2.用户查询*****");
            System.out.println("*****3.用户删除*****");
            System.out.println("*****4.用户更新*****");
            System.out.println("*****5.推出操作*****");
            System.out.println("请选择");
            flag = sc.nextInt();
            if(flag ==1){
                System.out.println("请输入新用户身份");
                userRight = sc.next();
                System.out.println("请输入新用户名字");
                userName = sc.next();
                System.out.println("请输入新用户密码");
                userPassword = sc.next();
                User user = new User(userRight, userName, userPassword);
                flag = dao.insert(user);
                if(flag ==1){
                    System.out.println("新用户注册成功");
                }else{
                    System.out.println("新用户注册失败");
                }

            }
            else if(flag ==2){
                List list = new ArrayList();
                list = dao.findAll();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
            else if(flag ==3){
                System.out.println("输入要删除用户名称");
                userName = sc.next();
                flag = dao.delete(userName);
                System.out.println(flag);
                if(flag ==1){
                    System.out.println("新用户注册成功");
                }else{
                    System.out.println("新用户注册失败");
                }

            }
            else if(flag ==4){

            }
            else if (flag == 5) {
                break;
            }
        }
    }
}
