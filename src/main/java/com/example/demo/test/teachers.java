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
		JMenu select = new JMenu("ѡ��");
		select.setMnemonic('s');
		JMenuItem find = new JMenuItem("����");
		JMenuItem add = new JMenuItem("���");
		JMenuItem delete = new JMenuItem("ɾ��");
		JMenuItem alter = new JMenuItem("�޸�");
		select.add(find);
		select.add(alter);
		select.add(add);
		select.add(delete);
		bar.add(select);
		JMenu frame1 = new JMenu("����");
		JMenuItem exit = new JMenuItem("�ر�");
		frame1.add(exit);
		//���˵�����ӵ�������
		bar.add(frame1);
		frame.setSize(800, 450);
		frame.setLocation(173, 0);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("ѧ����Ϣ�������");
		frame.setResizable(false);
		try{
		JPanel panel = new ImagePanel();
		frame.setContentPane(panel);
		ImageIcon ii = new ImageIcon("C:\\Users\\Administrator\\Desktop\\1.jpg");
		JLabel lab1 = new JLabel(ii);
		// ���ͼƬ��frame�ڶ���,������ͼ��ǩ��ӵ�jframe��LayeredPane�����??
		frame.getLayeredPane().add(lab1, new Integer(Integer.MIN_VALUE));
		lab1.setBounds(0, -2, ii.getIconWidth(), ii.getIconHeight());
		JPanel jp = (JPanel)frame.getContentPane();
		jp.setOpaque(false);
		panel.setOpaque(false);
		panel.setLayout(null);
		bt1 = new JButton("�޸�ѧ���ɼ�");
		bt1.addActionListener(this);
		bt1.setBounds(600,30,120,30);
		bt2 = new JButton("����ѧ����¼");
		bt2.setBounds(600,80,120,30);
		bt2.addActionListener(this);
		bt3 = new JButton("ɾ��ѧ����¼");
		bt3.setBounds(600,130,120,30);
		bt3.addActionListener(this);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=kechengsheji";
			String login = "sa";
			String password = "941021";
			Connection conn =
			DriverManager.getConnection(url,login,password);
			java.sql.Statement statement = conn.createStatement();
			String sqlQuery ="select * from �ɼ��� where �γ�����=(select �γ��� from �γ̱� where ��ʦ���="+name+")";
			String sqlQuery1 ="select �γ��� from �γ̱� where ��ʦ���='"+name+"'";
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
