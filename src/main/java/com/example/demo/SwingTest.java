package com.example.demo;

import javax.swing.*;
import java.awt.*;

/**
 * Description:
 *
 * @author: chengrongkai
 * Date: 2020-06-17
 * Time: 9:45
 */
public class SwingTest {
    public static void main(String[] args) {
        // 面板组件
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);


        JPanel panel = new JPanel(new BorderLayout());
        Font f = new Font("华文行楷", Font.PLAIN, 28);
        Font f1 = new Font("宋体", Font.PLAIN, 18);
        JLabel title = new JLabel("学生信息管理系统");
        title.setFont(f);

        // 创建 5 个按钮
//        JButton btnN = new JButton("Button_North");
//        JButton btnS = new JButton("Button_South");
//        JButton btnW = new JButton("Button_West");
//        JButton btnE = new JButton("Button_East");
//        JButton btnC = new JButton("Button_Center");

        // 把 5 个按钮添加到容器中的 5 个方位
        panel.add(title, BorderLayout.NORTH);
//        panel.add(btnS, BorderLayout.SOUTH);
//        panel.add(btnW, BorderLayout.WEST);
//        panel.add(btnE, BorderLayout.EAST);
//        panel.add(btnC, BorderLayout.CENTER);


        jf.setContentPane(panel);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }


}
