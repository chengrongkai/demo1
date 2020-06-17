package com.example.demo;

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

public class DengLuJieMian extends JFrame implements ActionListener {
    JLabel title = new JLabel("学生社团管理系统");
    JLabel username = new JLabel("账号：");//使用文本创建一个用户名标签
    JTextField t1 = new JTextField();//创建一个文本框对象
    JLabel password = new JLabel("密码：");//创建一个密码标签
    JPasswordField t2 = new JPasswordField();
    JButton b1 = new JButton("登录");//创建登陆按钮
    JButton b2 = new JButton("退出");//创建取消按钮

    Font f = new Font("华文行楷", Font.PLAIN, 28);
    Font f1 = new Font("宋体", Font.PLAIN, 18);

    public DengLuJieMian() {
        this.setTitle("学生社团管理系统");//设置窗口标题
        this.setLayout(null);//设置窗口布局管理器
        title.setBounds(100, 35, 250, 50);
        title.setFont(f);
        this.add(title);

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

        b1.addActionListener(this);//给登陆按钮添加监听器
        b2.addActionListener(this);// 给取消按钮添加监听器
        this.setSize(400, 400);
//        this.setLocation(173, 0);
        this.setLocationRelativeTo(null);
        this.setVisible(true);//设置窗口的可见性
        this.setResizable(false);
        //设置窗口的大小
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });//通过内部类重写关闭窗体的方法
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)//处理登陆事件
        {
//            用户名
            String name = t1.getText();
//            密码
            String pass = new String(t2.getPassword());
            JFrame jFrame = new AuthSelect();
            this.dispose();
        }
        if (e.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args)//主函数
    {
        new DengLuJieMian();
    }
}
