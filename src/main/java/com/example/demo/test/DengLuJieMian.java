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
    JLabel title = new JLabel("ѧ����Ϣ����ϵͳ");
    JLabel username = new JLabel("�û�����");//ʹ���ı�����һ���û�����ǩ
    JTextField t1 = new JTextField();//����һ���ı������
    JLabel password = new JLabel("���룺");//����һ�������ǩ
    JTextField t2 = new JTextField();
    JButton b1 = new JButton("��¼");//������½��ť
    JButton b2 = new JButton("�˳�");//����ȡ����ť
    JButton b3 = new JButton("ע��");//ע�����û�
    JLabel usertype = new JLabel("�û�����");
    JRadioButton user1 = new JRadioButton("ѧ��");//�����û����͵�ѡ��
    JRadioButton user2 = new JRadioButton("��ʦ");
    ButtonGroup radiogroup = new ButtonGroup();
    Font f = new Font("�����п�", Font.PLAIN, 28);
    Font f1 = new Font("����", Font.PLAIN, 18);

    public DengLuJieMian() {
        this.setTitle("ѧ����Ϣ����ϵͳ");//���ô��ڱ���
        this.setLayout(null);//���ô��ڲ��ֹ�����
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
        b3.setBounds(260, 220, 65, 25);
        this.add(b3);
        b1.addActionListener(this);//����½��ť��Ӽ�����
        b2.addActionListener(this);// ��ȡ����ť��Ӽ�����
        b3.addActionListener(this);
        this.setSize(400, 400);
        this.setLocation(173, 0);
        this.setVisible(true);//���ô��ڵĿɼ���
//���ô��ڵĴ�С
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });//ͨ���ڲ�����д�رմ���ķ���
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)//�����½�¼�
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
                String sqlQuery = "select * from �û���  where �û����� = 'ѧ��'";
                String sqlQuery1 = "select * from �û���  where �û����� = '��ʦ'";
                ResultSet rs = statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    if (check1 && rs.getString(1).equals(name) && rs.getString(2).equals(pass))//�ж����
                    {
                        new Students(name);
                    }
                }
                ResultSet rs1 = statement.executeQuery(sqlQuery1);
                while (rs1.next()) {
                    if (check2 && rs1.getString(1).equals(name) && rs1.getString(2).equals(pass))//�ж����
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

    public static void main(String args[])//������
    {
        new DengLuJieMian();
    }
}
