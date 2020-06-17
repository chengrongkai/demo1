package com.example.demo.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class teachers extends JFrame implements ActionListener {
	JTextArea text = new JTextArea();
	JButton bt1,bt2,bt3,bt4,bt5;
	JLabel lab1;
	JTextField lab2;
	String classname =null;
	public teachers(String name) {
		JFrame frame = new JFrame();
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		JMenu select = new JMenu("选项");
		select.setMnemonic('s');
		JMenuItem find = new JMenuItem("查找");
		JMenuItem add = new JMenuItem("添加");
		JMenuItem delete = new JMenuItem("删除");
		JMenuItem alter = new JMenuItem("修改");
		select.add(find);
		select.add(alter);
		select.add(add);
		select.add(delete);
		bar.add(select);
		JMenu frame1 = new JMenu("窗体");
		JMenuItem exit = new JMenuItem("关闭");
		frame1.add(exit);
		//将菜单栏添加到窗体上
		bar.add(frame1);
		frame.setSize(800, 450);
		frame.setLocation(173, 0);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("学生信息管理界面");
		frame.setResizable(false);
		try{
		JPanel panel = new ImagePanel();
		frame.setContentPane(panel);
		ImageIcon ii = new ImageIcon("C:\\Users\\Administrator\\Desktop\\1.jpg");
		JLabel lab1 = new JLabel(ii);
		// 添加图片到frame第二层,将背景图标签添加到jframe的LayeredPane面板里??
		frame.getLayeredPane().add(lab1, new Integer(Integer.MIN_VALUE));
		lab1.setBounds(0, -2, ii.getIconWidth(), ii.getIconHeight());
		JPanel jp = (JPanel)frame.getContentPane();
		jp.setOpaque(false);
		panel.setOpaque(false);
		panel.setLayout(null);
		bt1 = new JButton("修改学生成绩");
		bt1.addActionListener(this);
		bt1.setBounds(600,30,120,30);
		bt2 = new JButton("增加学生记录");
		bt2.setBounds(600,80,120,30);
		bt2.addActionListener(this);
		bt3 = new JButton("删除学生记录");
		bt3.setBounds(600,130,120,30);
		bt3.addActionListener(this);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
			String login = "sa";
			String password = "941021";
			Connection conn =
			DriverManager.getConnection(url,login,password);
			java.sql.Statement statement = conn.createStatement();
			String sqlQuery ="select * from 成绩表 where 课程名称=(select 课程名 from 课程表 where 教师编号="+name+")";
			String sqlQuery1 ="select 课程名 from 课程表 where 教师编号='"+name+"'";
			ResultSet rs1 = statement.executeQuery(sqlQuery1);
			if(rs1.next()){classname = rs1.getString(1);}
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
			text = new JTextArea(results.toString());
			text.setBounds(15, 15, 500, 400);
			panel.add(bt1);
			panel.add(bt2);
			panel.add(bt3);
			panel.add(text);
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
		if(e.getSource()==bt1)	
		{
			new AddStudent(classname);
		}
		if(e.getSource()==bt2)
		{
			new ChengJiStudent(classname);
		}
		if(e.getSource()==bt3)
		{
			new SelectStudent(classname);
		}
	}
	
}
