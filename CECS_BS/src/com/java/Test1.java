package com.java;
import javax.swing.*;

import java.awt.*;


public class Test1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		//For the names
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        JPanel upperPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        JPanel drawCardPanel = new JPanel();
        JPanel moveCardPanel = new JPanel();
        JPanel playCardPanel = new JPanel();
        
        
        // Nirupama /c/Nirupama/SEproject/CECS543    SEproject\CECS543\CECS_BS\src
        //Image image = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\CSULBMap3.png").getImage();
        //Kevin  
        Image image = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/CSULBMap3.png").getImage();
        
        JButton drawCardButton = new  JButton("Draw Card");
        JButton moveButton = new  JButton("    Move   ");
        JButton playCardButton = new  JButton("Play Card");
     
        JTable table = new JTable(4, 5);
        
        
        JLabel jl = new JLabel(new ImageIcon(image));
        
        JLabel label1 = new JLabel("Niru");
        label1.setForeground(Color.blue);
        
        JLabel label2 = new JLabel("Kevin");
        label2.setForeground(Color.blue);
        
        JLabel label3 = new JLabel("Deeksha");
        label3.setForeground(Color.blue);

       //names
        frame.add(upperPanel);
        //DrawCard, Move, PlayCard buttons
        frame.add(bottomPanel);
        upperPanel.add(jl);
       
        jl.add(panel1);
        jl.add(panel2);
        jl.add(panel3);
        //Niru
        panel1.setOpaque(false);
        panel1.setBounds(0, 1370, 1750, 1420);
        panel1.add(label1);
        //kevin
        panel2.setOpaque(false);
        panel2.setBounds(0, 1420, 1750, 1420);
        panel2.add(label2);
        //Dee
       panel3.setOpaque(false);
       panel3.setBounds(0, 1470, 1750, 1420);
       panel3.add(label3);
        
       JScrollPane scrollPane = new JScrollPane(upperPanel);
       scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       scrollPane.setBounds(0, 0, 1280, 500);
      
       drawCardPanel.setPreferredSize(new Dimension(10,10));
       drawCardPanel.setBackground(Color.black);
       drawCardPanel.add(drawCardButton);
       bottomPanel.add(drawCardPanel);

       moveCardPanel.add(moveButton);
       bottomPanel.add(moveCardPanel);
       
       playCardPanel.add(playCardButton);
       bottomPanel.add(playCardPanel);
       
      // bottomPanel.add(table);
       
       JScrollPane buttonPane1 = new JScrollPane(drawCardPanel);
       buttonPane1.setBounds(10, 500, 150, 45);
       buttonPane1.setBorder(null);
     
       JScrollPane buttonPane2 = new JScrollPane(moveCardPanel);
       buttonPane2.setBounds(10, 537, 150, 45);
       buttonPane2.setBorder(null);
       
       JScrollPane buttonPane3 = new JScrollPane(playCardPanel);
       buttonPane3.setBounds(10, 573, 150, 45);
       buttonPane3.setBorder(null);
       
       JPanel contentPane = new JPanel(null);
       contentPane.setPreferredSize(new Dimension(1900, 1080));
       contentPane.add(scrollPane);
       contentPane.add(buttonPane1);
       contentPane.add(buttonPane2);
       contentPane.add(buttonPane3);
       
       frame.setContentPane(contentPane);
       frame.pack();
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setVisible(true);

	}

}
