package com.csulb.graphic;

import javax.swing.*;

import java.awt.*;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		
        JPanel panel = new JPanel();
        Image image = new ImageIcon("C:\\Users\\vishalvibhandik\\workspace\\CECS_BS\\src\\CSULBMap3.png").getImage();
         
        JLabel jl = new JLabel(new ImageIcon(image));
        JLabel label1 = new JLabel("Niru");
        label1.setForeground(Color.yellow);
        //label1.setSize(150, 150);
        //label1.setOpaque(false);
       // label1.setLocation(1200, 400);
        frame.add(jl);
        jl.add(panel);
        panel.setOpaque(false);
        panel.setBounds(0, 200, 500, 200);
        panel.add(label1);
        
        //Image image = new ImageIcon("C:\\Users\\vishalvibhandik\\workspace\\CECS_BS\\src\\CSULBMap3.png").getImage();
        
        
        
        
       
        JScrollPane scrollPane = new JScrollPane(jl);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1900, 720);
        
                
        
        
        
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1900, 1080));
        contentPane.add(scrollPane);
        
        
                       
        
        
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

	}

}
