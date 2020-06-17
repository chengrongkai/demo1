package com.example.demo.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Students extends JFrame implements ActionListener {
	JButton bt1,bt2,bt3;
	public Students(String name1){
		Font f1 = new Font("宋体", Font.PLAIN,18);
		try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
				String login = "sa";
				String password = "941021";
				Connection conn =
				DriverManager.getConnection(url,login,password);
				java.sql.Statement statement = conn.createStatement();
				String sqlQuery ="select * from 成绩表"+" where 学号='"+name1+"'";
				ResultSet rs = statement.executeQuery(sqlQuery);
				StringBuffer results = new StringBuffer();
				ResultSetMetaData metaData = rs.getMetaData();
				int numberOfColumns = metaData.getColumnCount();
				for(int i = 1;i<=numberOfColumns;i++)
				results.append(metaData.getColumnName(i)+"\t");
				results.append("\n");
				while(rs.next()){
					for(int i=1;i<=numberOfColumns;i++)
						results.append(rs.getObject(i)+"\t");
						results.append("\n");
						}
		JTextArea lab8 = new JTextArea(results.toString());
		lab8.setBounds(0,50,650,400);lab8.setFont(f1);
		JFrame frame = new JFrame();
		frame.setSize(800, 450);
		frame.setLocation(173, 0);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("学生信息");
		frame.setResizable(false);
		JPanel panel = new ImagePanel();
		frame.setContentPane(panel);
		ImageIcon ii = new ImageIcon("src\\main\\1.jpg");
		JLabel lab1 = new JLabel(ii);
		// 添加图片到frame第二层,将背景图标签添加到jframe的LayeredPane面板里??
		frame.getLayeredPane().add(lab1, new Integer(Integer.MIN_VALUE));
		lab1.setBounds(0, -2, ii.getIconWidth(), ii.getIconHeight());
		JPanel jp = (JPanel)frame.getContentPane();
		jp.setOpaque(false);
		panel.setOpaque(false);
		panel.setLayout(null);
		String sqlQuery1 ="select * from 学生表 where 学号 = '"+name1+"'";
		ResultSet rs1 = statement.executeQuery(sqlQuery1);
		String name = null,class1 = null,code =name1;
		if(rs1.next()){
			name = rs1.getString(2);class1 =rs1.getString(3);
		}
		JLabel lab2 = new JLabel("姓名:");lab2.setBounds(10,10,50,25);
		lab2.setFont(f1);
		JLabel lab3 = new JLabel(name);lab3.setBounds(65,10,90,25);
		lab3.setFont(f1);
		JLabel lab4 = new JLabel("班级:");lab4.setBounds(150,10,50,25);
		lab4.setFont(f1);
		JLabel lab5 = new JLabel(class1);lab5.setBounds(210,10,120,25);
		lab5.setFont(f1);
		JLabel lab6 = new JLabel("学号:");lab6.setBounds(340,10,50,25);
		lab6.setFont(f1);
		JLabel lab7 = new JLabel(code);lab7.setBounds(400,10,100,25);
		lab7.setFont(f1);
		bt2 = new JButton("注销账号");
		bt2.setBounds(675,130,110,35);
		bt2.addActionListener(this);
		panel.add(lab7);
		panel.add(lab6);
		panel.add(lab5);
		panel.add(lab4);
		panel.add(lab3);
		panel.add(lab2);
		panel.add(lab8);
		panel.add(bt2);
		frame.setVisible(true);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt2){
			System.exit(1);
		}
		
	}

}

class ImagePanel extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\1.jpg");
		g.drawImage(icon.getImage(), 0, 0, null);

	}
}

