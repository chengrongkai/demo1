package com.example.demo.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DengLuJieMian extends Frame implements ActionListener {
    JLabel title = new JLabel("学生信息管理系统");
    JLabel username = new JLabel("用户名：");//使用文本创建一个用户名标签
    JTextField t1 = new JTextField();//创建一个文本框对象
    JLabel password = new JLabel("密码：");//创建一个密码标签
    JTextField t2 = new JTextField();
    JButton b1 = new JButton("登录");//创建登陆按钮
    JButton b2 = new JButton("退出");//创建取消按钮
    JButton b3 = new JButton("注册");//注册新用户
    JLabel usertype = new JLabel("用户类型");
    JRadioButton user1 = new JRadioButton("学生");//创建用户类型单选框
    JRadioButton user2 = new JRadioButton("教师");
    ButtonGroup radiogroup = new ButtonGroup();
    Font f = new Font("华文行楷", Font.PLAIN, 28);
    Font f1 = new Font("宋体", Font.PLAIN, 18);

    public DengLuJieMian() {
        this.setTitle("学生信息管理系统");//设置窗口标题
        this.setLayout(null);//设置窗口布局管理器
        title.setBounds(100, 35, 250, 50);
        title.setFont(f);
        this.add(title);
        usertype.setBounds(100, 95, 150, 35);
        usertype.setFont(f1);
        this.add(usertype);
        user1.setBounds(175, 95, 65, 35);
        user1.setFont(f1);
        this.add(user1);
        user2.setBounds(237, 95, 65, 35);
        user2.setFont(f1);
        this.add(user2);
        radiogroup.add(user1);
        radiogroup.add(user2);
        username.setBounds(100, 130, 150, 35);
        username.setFont(f1);//设置姓名标签的初始位置
        this.add(username);// 将姓名标签组件添加到容器
        t1.setBounds(175, 135, 150, 25);// 设置文本框的初始位置
        this.add(t1);// 将文本框组件添加到容器
        password.setBounds(100, 165, 150, 35);
        password.setFont(f1);//密码标签的初始位置
        this.add(password);//将密码标签组件添加到容器
        t2.setBounds(175, 170, 150, 25);//设置密码标签的初始位置
        this.add(t2);//将密码标签组件添加到容器
        b1.setBounds(100, 220, 65, 25);//设置登陆按钮的初始位置
        this.add(b1);//将登陆按钮组件添加到容器
        b2.setBounds(180, 220, 65, 25);//设置取消按钮的初始位置
        this.add(b2);// 将取消按钮组件添加到容器
        b3.setBounds(260, 220, 65, 25);
        this.add(b3);
        b1.addActionListener(this);//给登陆按钮添加监听器
        b2.addActionListener(this);// 给取消按钮添加监听器
        b3.addActionListener(this);
        this.setSize(400, 400);
        this.setLocation(173, 0);
        this.setVisible(true);//设置窗口的可见性
//设置窗口的大小
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });//通过内部类重写关闭窗体的方法
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)//处理登陆事件
        {
            String name = t1.getText();
            String pass = t2.getText();
            boolean check1 = user1.isSelected();
            boolean check2 = user2.isSelected();
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
                String login = "sa";
                String password = "941021";
                Connection conn =
                        DriverManager.getConnection(url, login, password);
                java.sql.Statement statement = conn.createStatement();
                String sqlQuery = "select * from 用户表  where 用户类型 = '学生'";
                String sqlQuery1 = "select * from 用户表  where 用户类型 = '教师'";
                ResultSet rs = statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    if (check1 && rs.getString(1).equals(name) && rs.getString(2).equals(pass))//判断语句
                    {
                        new Students(name);
                    }
                }
                ResultSet rs1 = statement.executeQuery(sqlQuery1);
                while (rs1.next()) {
                    if (check2 && rs1.getString(1).equals(name) && rs1.getString(2).equals(pass))//判断语句
                    {
                        new teachers(name);
                    }
                }

            } catch (SQLException sqlException) {
                JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch (ClassNotFoundException classnotfound) {
                JOptionPane.showMessageDialog(null, classnotfound.getMessage(), "driver not found", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        if (e.getSource() == b2) {
            System.exit(0);
        } else if (e.getSource() == b3) {
            new zhuce();
        }
    }

    public static void main(String args[])//主函数
    {
        new DengLuJieMian();
    }
}
