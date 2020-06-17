package com.example.demo.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChengJiStudent extends JFrame implements ActionListener {
	JLabel code = new JLabel("学号");
	JTextField text1 = new JTextField(12);
	JLabel name = new JLabel("姓名");
	JTextField text2 = new JTextField(12);
	JLabel class1 = new JLabel("班级");
	JTextField text3 = new JTextField(12);
	JLabel mark = new JLabel("成绩");
	JTextField text4 = new JTextField(12);
	JButton bt2 = new JButton("确定增加");
	String classname;
	Font f1 = new Font("宋体", Font.PLAIN,18);
public ChengJiStudent(String nameclass){
	this.setTitle("增加学生信息");
	this.setLayout(null);
	classname = nameclass;
	name.setBounds(50,70,70,35);name.setFont(f1);
	this.add(name);
	text1.setBounds(130,70,150,35);
	this.add(text1);
	class1.setBounds(50,140,70,35);class1.setFont(f1);
	this.add(class1);
	text2.setBounds(130,140,150,35);this.add(text2);
	code.setBounds(50,220,70,35);code.setFont(f1);
	this.add(code);
	text3.setBounds(130,220,150,35);this.add(text3);
	mark.setBounds(50,290,70,35);mark.setFont(f1);
	this.add(mark);
    text4.setBounds(130,290,150,35);this.add(text4);
    bt2.setBounds(300,70,100,35);
    bt2.addActionListener(this);
    this.add(bt2);
    this.setSize(800,400);
    this.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	   try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
			String login = "sa";
			String password = "941021";
			Connection conn =
			DriverManager.getConnection(url,login,password);
			java.sql.Statement statement = conn.createStatement();
			if(e.getSource()==bt2){
				String nametext = text1.getText();
				String classtext = text2.getText();
				String codetext = text3.getText();
				String marktext = text4.getText();
				String sqlQuery ="select * from 课程表 where 课程名 = '"+classname+"'";
				ResultSet rs = statement.executeQuery(sqlQuery);
				String coursecode=null,coursename=null,coursetype=null,coursecode1=null;
				if(rs.next())
				{ coursecode = rs.getString(1);
				 coursename = rs.getString(2);
				 coursetype = rs.getString(3);
				 coursecode1 = rs.getString(5);
				}
				String sqlQuery1 ="insert into 学生表 values('"+codetext+"','"+nametext+"','"+classtext+"')";
				statement.executeUpdate(sqlQuery1);
				String sqlQuery2 ="insert into 成绩表 values('"+codetext+"','"+coursecode+"','"+coursename
						+"','"+coursetype+"','"+marktext+"','"+coursecode1+"')";
				statement.executeUpdate(sqlQuery2);
				JOptionPane.showMessageDialog(null, "插入成功");
			}
		}
		catch(SQLException sqlException)
		{
			JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE );
			System.exit(1);
		}
		catch(ClassNotFoundException classnotfound)
		{
			JOptionPane.showMessageDialog(null,classnotfound.getMessage(),"driver not found", JOptionPane.ERROR_MESSAGE );
			System.exit(1);
		}
}
}
