package com.example.demo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Description:
 *
 * @author: chengrongkai
 * Date: 2020-06-17
 * Time: 16:25
 */
public class StudentManage extends JFrame implements ActionListener {

    Font f1 = new Font("华文行楷", Font.PLAIN, 20);

    public StudentManage(){
        this.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0,50,650,400);
        Object[][] cellData = {{"row1-col1", "row1-col2"},{"row2-col1", "row2-col2"}};
        String[] columnNames = {"col1", "col2"};

        JTable table = new JTable(cellData, columnNames);
        table.setSize(300,300);
        panel.add(table);
//        panel.setSize(300,300);

        this.add(panel);

        this.setSize(400, 400);
        this.setFont(f1);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new StudentManage();
    }
}
