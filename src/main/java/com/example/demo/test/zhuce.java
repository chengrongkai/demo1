package com.example.demo.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class zhuce extends JFrame implements ActionListener {
JLabel lab1 = new JLabel("�û���:");
JLabel lab2 = new JLabel("���룺");
JLabel lab3 = new JLabel("�û�����:");
JTextField text = new JTextField(12);
JTextField text1 = new JTextField(12);
JButton bt1 = new JButton("ȷ��");
JButton bt2 = new JButton("����");
JRadioButton rd1 = new JRadioButton("ѧ��");
JRadioButton rd2 = new JRadioButton("��ʦ");
ButtonGroup group = new ButtonGroup();
Font f1 = new Font("����", Font.PLAIN,18);
	public zhuce(){
		this.setTitle("ע�����û�");
		this.setLayout(null);
		this.setFont(f1);
		lab1.setBounds(150, 75, 85, 30);lab1.setFont(f1);
		this.add(lab1);
		text.setBounds(230,75,150,30);
		this.add(text);
		lab2.setBounds(150,130,85,30);lab2.setFont(f1);
		this.add(lab2);
		text1.setBounds(230,130,150,30);
		this.add(text1);
		lab3.setBounds(150,190,85,30);lab3.setFont(f1);
		this.add(lab3);
		group.add(rd1);group.add(rd2);
		rd1.setBounds(230,190,85,30);rd1.setFont(f1);
		rd2.setBounds(320,190,85,30);rd2.setFont(f1);
		this.add(rd1);this.add(rd2);
		bt1.setBounds(150,250,85,30);bt1.addActionListener(this);
		bt2.setBounds(300,250,85,30);bt2.addActionListener(this);
		this.add(bt1);this.add(bt2);
		this.setSize(700,500);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1)
		{
            String type = "ѧ��";
			if(rd2.isSelected()){
				type = "��ʦ";
			}
			try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
				String login = "sa";
				String password = "941021";
				Connection conn =
				DriverManager.getConnection(url,login,password);
				java.sql.Statement statement = conn.createStatement();
				    String nametext = text.getText();
					String passtext = text1.getText();
					String sqlQuery ="insert into ѧ���� values('"+nametext+"','"+passtext+"','"+type+"')";
					statement.executeUpdate(sqlQuery);
					JOptionPane.showMessageDialog(null, "ע��ɹ�");
				
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
		else if(e.getSource()==bt2)
		{
			System.exit(1);
		}
		
	}
	
}
