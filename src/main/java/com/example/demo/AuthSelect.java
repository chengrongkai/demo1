package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AuthSelect extends JFrame implements ActionListener {
    JButton b1 = new JButton("学生用户管理");
    JButton b2 = new JButton("社团管理");
    JButton b3 = new JButton("社团活动管理");
    JButton b4 = new JButton("社团公告管理");
    JButton b5 = new JButton("管理员管理");

    Font f1 = new Font("华文行楷", Font.PLAIN, 20);

    public AuthSelect() {
        this.setTitle("学生社团管理系统");
        //设置窗口布局管理器
        this.setLayout(null);
        b1.setFont(f1);
        b1.setBounds(100, 50, 200, 35);

        this.add(b1);

        b2.setFont(f1);
        b2.setBounds(100, 100, 200, 35);
        this.add(b2);

        b3.setFont(f1);
        b3.setBounds(100, 150, 200, 35);
        this.add(b3);

        b4.setFont(f1);
        b4.setBounds(100, 200, 200, 35);
        this.add(b4);

        b5.setFont(f1);
        b5.setBounds(100, 250, 200, 35);
        this.add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        this.setSize(400, 400);
        this.setFont(f1);

        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (b1.equals(e.getSource())){

        }else if (b2.equals(e.getSource())){

        }else if (b3.equals(e.getSource())){

        }else if (b4.equals(e.getSource())){

        }else if (b5.equals(e.getSource())){

        }
//        this.dispose();
    }

    public static void main(String[] args) {
        new AuthSelect();

    }
}
