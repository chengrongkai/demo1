package com.example.demo.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectStudent extends JFrame implements ActionListener {
	JLabel lab1 = new JLabel("������Ҫɾ����ѧ����ѧ�ţ�");
	JTextField text = new JTextField(12);
	JButton bt1 = new JButton("ȷ��");
	JLabel code = new JLabel("ѧ��");
	JTextField text1 = new JTextField(12);
	JLabel name = new JLabel("����");
	JTextField text2 = new JTextField(12);
	JLabel class1 = new JLabel("�༶");
	JTextField text3 = new JTextField(12);
	JLabel mark = new JLabel("�ɼ�");
	JTextField text4 = new JTextField(12);
	JButton bt2 = new JButton("ȷ��ɾ��");
	String classname;
	Font f1 = new Font("����", Font.PLAIN,18);
public SelectStudent(String nameclass){
	this.setTitle("ɾ��ѧ����Ϣ");
	this.setLayout(null);
	classname = nameclass;
	lab1.setBounds(15,15,250,35);lab1.setFont(f1);
	this.add(lab1);
	text.setBounds(265,15,150,35);
	this.add(text);
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
    bt1.setBounds(450,15,75,35);
    bt1.addActionListener(this);
    bt2.setBounds(300,70,100,35);
    bt2.addActionListener(this);
    this.add(bt1);
    this.add(bt2);
    this.setSize(800,400);
    this.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	   try{
		   String code = text.getText();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
			String login = "sa";
			String password = "941021";
			Connection conn =
			DriverManager.getConnection(url,login,password);
			java.sql.Statement statement = conn.createStatement();
			if(e.getSource()==bt1){
			String sqlQuery ="select * from ѧ���� where ѧ��='"+code+"'";
			ResultSet rs = statement.executeQuery(sqlQuery);
			if(rs.next()){
			text1.setText(rs.getString(2));
			text2.setText(rs.getString(3));
			text3.setText(rs.getString(1));}
			else {
                JOptionPane.showMessageDialog(null, "ѧ�Ų�����");}
			String sqlQuery1 ="select * from �ɼ��� where (ѧ��='"+code+"'"+"and �γ����� ='"+classname+"')";
			ResultSet rs1 = statement.executeQuery(sqlQuery1);
			if(rs1.next())
			text4.setText(rs1.getString(5));}
			if(e.getSource()==bt2){
				String sqlQuery2 ="delete from �ɼ��� where ѧ��='"+code+"'";
				statement.executeUpdate(sqlQuery2);
				String sqlQuery3 ="delete from ѧ���� where ѧ��='"+code+"'";
				statement.executeUpdate(sqlQuery3);
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

