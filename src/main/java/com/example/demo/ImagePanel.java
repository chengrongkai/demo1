package com.example.demo;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
	private String filePath;
	ImagePanel(String filePath){
		this.filePath = filePath;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon(filePath);
		g.drawImage(icon.getImage(), 0, 0, null);

	}
}