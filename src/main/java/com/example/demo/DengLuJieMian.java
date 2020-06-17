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
    JLabel title = new JLabel("ѧ�����Ź���ϵͳ");
    JLabel username = new JLabel("�˺ţ�");//ʹ���ı�����һ���û�����ǩ
    JTextField t1 = new JTextField();//����һ���ı������
    JLabel password = new JLabel("���룺");//����һ�������ǩ
    JPasswordField t2 = new JPasswordField();
    JButton b1 = new JButton("��¼");//������½��ť
    JButton b2 = new JButton("�˳�");//����ȡ����ť

    Font f = new Font("�����п�", Font.PLAIN, 28);
    Font f1 = new Font("����", Font.PLAIN, 18);

    public DengLuJieMian() {
        this.setTitle("ѧ�����Ź���ϵͳ");//���ô��ڱ���
        this.setLayout(null);//���ô��ڲ��ֹ�����
        title.setBounds(100, 35, 250, 50);
        title.setFont(f);
        this.add(title);

        username.setBounds(100, 130, 150, 35);
        username.setFont(f1);//����������ǩ�ĳ�ʼλ��
        this.add(username);// ��������ǩ�����ӵ�����
        t1.setBounds(175, 135, 150, 25);// �����ı���ĳ�ʼλ��
        this.add(t1);// ���ı��������ӵ�����
        password.setBounds(100, 165, 150, 35);
        password.setFont(f1);//�����ǩ�ĳ�ʼλ��
        this.add(password);//�������ǩ�����ӵ�����
        t2.setBounds(175, 170, 150, 25);//���������ǩ�ĳ�ʼλ��
        this.add(t2);//�������ǩ�����ӵ�����
        b1.setBounds(100, 220, 65, 25);//���õ�½��ť�ĳ�ʼλ��
        this.add(b1);//����½��ť�����ӵ�����
        b2.setBounds(180, 220, 65, 25);//����ȡ����ť�ĳ�ʼλ��
        this.add(b2);// ��ȡ����ť�����ӵ�����

        b1.addActionListener(this);//����½��ť��Ӽ�����
        b2.addActionListener(this);// ��ȡ����ť��Ӽ�����
        this.setSize(400, 400);
//        this.setLocation(173, 0);
        this.setLocationRelativeTo(null);
        this.setVisible(true);//���ô��ڵĿɼ���
        this.setResizable(false);
        //���ô��ڵĴ�С
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });//ͨ���ڲ�����д�رմ���ķ���
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)//�����½�¼�
        {
//            �û���
            String name = t1.getText();
//            ����
            String pass = new String(t2.getPassword());
            JFrame jFrame = new AuthSelect();
            this.dispose();
        }
        if (e.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args)//������
    {
        new DengLuJieMian();
    }
}
