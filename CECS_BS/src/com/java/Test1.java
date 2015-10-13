package com.java;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Test1  {
	public static void main(String[] args) {
		
		Test1 obj= new Test1();
	}
	
	private String selectedMove= "";
	private JLabel label1 = new JLabel("Niru");
	private JPanel panel1 = new JPanel();
	  
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
    
	private  JPanel upperPanel = new JPanel();
	private  JPanel bottomPanel = new JPanel();
    
	private   JPanel buttonPanel = new JPanel();
	private JPanel JListPanel = new JPanel();
	private List moveList = new List();
	private JFrame frame = new JFrame();
	private List movePlayedList = new List();
	
	private  JButton drawCardButton = new  JButton("Draw Card");
	private  JButton moveButton = new  JButton("    Move   ");
	private  JButton playCardButton = new  JButton("Play Card");
   
	private JTable table = new JTable(4, 5);
      
	private JLabel cardsInDeck = new JLabel("Cards in Deck: ");
	private JLabel cardsInDeckValue = new JLabel("43");
	private JLabel discardedCards = new JLabel("Discarded Cards: ");
	private JLabel discardedCardsValue = new JLabel("0");
	private JLabel currentState = new JLabel("You, Nirupama and Deeksha are in ECS 308.");
		public Test1(){
		
		
		
		//For the names
      
        moveList.add("South Hall");
    //    moveList.add("ECS 302");
        
       
        movePlayedList.add("AI Player is Kevin");
        movePlayedList.add("Human Player is Nirupama");
        movePlayedList.add("AI Player is Deeksha");
        
        
        JPanel cardPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        
        // Nirupama /c/Nirupama/SEproject/CECS543    SEproject\CECS543\CECS_BS\src
        Image image = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\CSULBMap3.png").getImage();
        Image card1 = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\Card1.png").getImage();
        
        //Kevin  
      //  Image image = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/CSULBMap3.png").getImage();
       // Image card1 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Card1.png").getImage();
       
      
        
        JLabel jl = new JLabel(new ImageIcon(image));
        JLabel card1Label = new JLabel(new ImageIcon(card1));
        
        Color customColor = new Color(125,125,235);
        
        label1.setFont (label1.getFont ().deriveFont (20.0f));
        label1.setForeground(customColor);
        
        customColor = new Color(51, 204, 51);
        JLabel label2 = new JLabel("Kevin");
        label2.setFont (label2.getFont ().deriveFont (20.0f));
        label2.setForeground(customColor);
        
        customColor = new Color(255,0,255);
        JLabel label3 = new JLabel("Deeksha");
        label3.setFont (label3.getFont ().deriveFont (20.0f));
        label3.setForeground(customColor);
        

       
        

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
		panel1.setBounds(200, 1370, 1750, 1420);
		panel1.add(label1);
		//kevin
		panel2.setOpaque(false);
		panel2.setBounds(200, 1420, 1750, 1420);
		panel2.add(label2);
		//Dee
       panel3.setOpaque(false);
       panel3.setBounds(200, 1470, 1750, 1420);
       panel3.add(label3);
        
       JScrollPane scrollPane = new JScrollPane(upperPanel);
       scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       scrollPane.setBounds(0, 0, 1440, 560);
      
     //  buttonPanel.setPreferredSize(new Dimension(22,22));
       buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
       moveButton.addActionListener(new MoveButtonClass());
       buttonPanel.add(drawCardButton);
       buttonPanel.add(moveButton);
       
       buttonPanel.add(playCardButton);
      
     //  JListPanel.setBounds(10, 200, 200, 200);
       moveList.addActionListener(new SelectedMoveClass());
       moveList.setBounds(0, 0, 100, 200);
       JListPanel.add(moveList);
      
   //    card1Label.setBounds(100, 500, 100, 100);
       cardPanel.add(card1Label);
      
       tablePanel.setBackground(Color.red);
    //   table.setIntercellSpacing(new Dimension(1,1));
       tablePanel.add(table);

       table.setBounds(400, 570, 1030, 200);
       JScrollPane buttonPane1 = new JScrollPane(buttonPanel);
       buttonPane1.setBounds(10, 565, 117, 97);
       buttonPane1.setBorder(null);
       
       JScrollPane buttonPane2 = new JScrollPane(moveList);
       buttonPane2.setBounds (8, 665, 160, 180);
       buttonPane2.setBorder(null);
       
       JScrollPane buttonPane3 = new JScrollPane(cardPanel);
       buttonPane3.setBounds (175, 565, 217, 300);
       buttonPane3.setBorder(null);
      
       JScrollPane buttonPane4 = new JScrollPane(table);
       buttonPane4.setBounds (400, 565, 1030, 100);
       buttonPane4.setBorder(null);

       JScrollPane buttonPane5 = new JScrollPane(cardsInDeck);
       buttonPane5.setBorder(null);
       buttonPane5.setBounds (400, 665, 100, 20);
       
       JScrollPane buttonPane6 = new JScrollPane(cardsInDeckValue);
       buttonPane6.setBorder(null);
       buttonPane6.setBounds (500, 665, 100, 20);
       
       JScrollPane buttonPane7 = new JScrollPane(discardedCards);
       buttonPane7.setBorder(null);
       buttonPane7.setBounds (600, 665, 111, 20);

       JScrollPane buttonPane8 = new JScrollPane(discardedCardsValue);
       buttonPane8.setBorder(null);
       buttonPane8.setBounds (711, 665, 719, 20);
       
       JScrollPane buttonPane9 = new JScrollPane(currentState);
       buttonPane9.setBorder(null);
       buttonPane9.setBounds (400, 685, 1030, 20);
       
       JScrollPane buttonPane10 = new JScrollPane(movePlayedList);
       buttonPane10.setBounds (400, 720, 1030, 130);
       buttonPane10.setBorder(null);
       
       
       
       JPanel contentPane = new JPanel(null);
       contentPane.setPreferredSize(new Dimension(1900, 1080));
       contentPane.add(scrollPane);
       contentPane.add(buttonPane3);
       contentPane.add(buttonPane1);
       contentPane.add(buttonPane2);
       contentPane.add(buttonPane4);
       contentPane.add(buttonPane5);
       contentPane.add(buttonPane6);
       contentPane.add(buttonPane7);
       contentPane.add(buttonPane8);
       contentPane.add(buttonPane9);
       contentPane.add(buttonPane10);
       
       frame.setContentPane(contentPane);
       frame.pack();
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setVisible(true);

	}
	
	 class MoveButtonClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String movePressed = e.getActionCommand().toString();
			System.out.println(movePressed);
			panel1.setBounds(200, 1200, 1750, 1420);
			moveList.removeAll();
			moveList.add("East Walkway");
			moveList.add("North Hall");
			moveList.add("ECS 302");
			moveList.add("ECS 308");
			moveList.add("Eat Club");
			moveList.add("Conference");
			moveList.add("Noisy Room");
			currentState.setText("Human Player Niru moved to South Hall.");
			 
		}	
	}
	 
	 
	 class SelectedMoveClass implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String movePressed = e.getActionCommand().toString();
				System.out.println(movePressed);
				selectedMove=movePressed;
			}	
		}	 
}
