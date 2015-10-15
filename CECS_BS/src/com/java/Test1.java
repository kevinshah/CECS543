package com.java;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


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
	private List movesList = new List();
	private List movesList2 = new List();
	private List movesList3 = new List();
	private JFrame frame = new JFrame();
	private List movePlayedList = new List();
	
	private  JButton drawCardButton = new  JButton("Draw Card");
	private  JButton moveButton = new  JButton("    Move   ");
	private  JButton playCardButton = new  JButton("Play Card");
   private List playersList= new List(); 

   String data[][]={ 
                     {"Niru","6","6","6","0"}, {"Kevin","6","6","6","0"}, {"Dee","6","6","6","0"},
                     };  
String column[]={" ","Learning","Craft","Integrity","Quality Points"}; 
	private JTable table = new JTable(data, column);
      
	private JLabel cardsInDeck = new JLabel("Cards in Deck: ");
	private JLabel cardsInDeckValue = new JLabel("43");
	private JLabel discardedCards = new JLabel("Discarded Cards: ");
	private JLabel discardedCardsValue = new JLabel("0");
	private JLabel currentState = new JLabel("You, Nirupama and Deeksha are in ECS 308.");
	/*****************************************************************************************/
	 String currentPlayer;
	 
	 private String globalSelectedRoom= "";
     private String globalSelectedRoom2= "South Hall"; // Because the first move of all the players is South Hall
     private String globalSelectedRoom3= "South Hall";
	/******************************************************************************************/
	
	
	public Test1(){
		
		
		
		//For the names
      playersList.add("Nirupama");
      playersList.add("Kevin");
      playersList.add("Deeksha");
        movesList.add("South Hall");
    //    movesList.add("ECS 302");
        int tempInt=0;
        String tempStr="";
        RandomNumberGenerator obj = new RandomNumberGenerator();
        tempInt = obj.numGenerator();	
       
        //movePlayedList.add("AI Player is Kevin");
        movePlayedList.add("Human Player is "+playersList.getItem(tempInt));
        tempStr=playersList.getItem(tempInt);
        //movePlayedList.add("AI Player is Deeksha");
       currentPlayer=tempStr; 
        
        JPanel cardPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        
        // Nirupama /c/Nirupama/SEproject/CECS543    SEproject\CECS543\CECS_BS\src
      //  Image image = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\CSULBMap3.png").getImage();
      //  Image card1 = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\Card1.png").getImage();
        
        //Kevin  
        Image image = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/CSULBMap3.png").getImage();
        Image card1 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Card1.png").getImage();
       
        //Deeksha
       // Image image = new ImageIcon("C:\\Users\\DEEKSHA\\Desktop\\CSULB\\CECS543\\CECS543\\CECS_BS\\src\\com\\drawable\\CSULBMap3.png").getImage();
      //  Image card1 = new ImageIcon("C:\\Users\\DEEKSHA\\Desktop\\CSULB\\CECS543\\CECS543\\CECS_BS\\src\\com\\drawable\\Card1.png").getImage();
      
        
        JLabel jl = new JLabel(new ImageIcon(image));
        JLabel card1Label = new JLabel(new ImageIcon(card1));
        
        Color customColor = new Color(125,125,235);
        
        label1.setText(tempStr);
        label1.setFont (label1.getFont ().deriveFont (20.0f));
        label1.setForeground(customColor);
        
        customColor = new Color(51, 204, 51);
        JLabel label2 = new JLabel("Kevin");
        if(tempStr.equalsIgnoreCase("Kevin")){
        	label2.setText("Niru");
        }
        label2.setFont (label2.getFont ().deriveFont (20.0f));
        label2.setForeground(customColor);
        
        customColor = new Color(255,0,255);
        JLabel label3 = new JLabel("Deeksha");
        if(tempStr.equalsIgnoreCase("Deeksha")){
        	label3.setText("Niru");
        }
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
       
       playCardButton.addActionListener(new PlayCardListner()); 
       buttonPanel.add(playCardButton);
      
     //  JListPanel.setBounds(10, 200, 200, 200);
       movesList.addActionListener(new SelectedMoveClass());
       movesList.setBounds(0, 0, 100, 200);
       JListPanel.add(movesList);
      
       movesList2.add("south hall");
       movesList3.add("south hall");
   //    card1Label.setBounds(100, 500, 100, 100);
       cardPanel.add(card1Label);
      
       tablePanel.setBackground(Color.red);
    //   table.setIntercellSpacing(new Dimension(1,1));
       tablePanel.add(table);

       table.setBounds(400, 570, 1030, 200);
       JScrollPane buttonPane1 = new JScrollPane(buttonPanel);
       buttonPane1.setBounds(10, 565, 117, 97);
       buttonPane1.setBorder(null);
       
       JScrollPane buttonPane2 = new JScrollPane(movesList);
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
	         
	         
	         //if(currentPlayer = PlayerName[0].toString())
	     
	        if(globalSelectedRoom.equalsIgnoreCase("South Hall")){
	         System.out.println("Inside South Hall");
	            panel1.setBounds(200,1200,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	            movesList.add("North Hall");
	            movesList.add("ECS 302");
	            movesList.add("Eat Club");
	            movesList.add("CECS Conference Room");
	            movesList.add("Lactation Lounge");
	            movesList.add("East Walkway");
	            movesList.add("ECS 308");
	            
	            currentState.setText("You are " + currentPlayer +" and You are in South Hall");
	        }
	        
	         
	        if(globalSelectedRoom.equalsIgnoreCase("ECS 302")){
	         System.out.println("Inside ECS 302 room");
	            panel1.setBounds(0,1000,1750,1000);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("North Hall");
	        movesList.add("South Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in ECS 302");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Eat Club")){
	         System.out.println("Inside Eat Club");
	            panel1.setBounds(200,900,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Eat Club");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("CECS Conference Room")){
	         System.out.println("Inside CECS Conference Room");
	            panel1.setBounds(350,900,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in CECS Conference Room");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Lactation Lounge")){
	         System.out.println("Inside Lactation Lounge");
	            panel1.setBounds(400,1400,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Lactation Lounge");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("ECS 308")){
	         System.out.println("Inside ECS 308");
	            panel1.setBounds(0,1320,1750, 1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in ECS 308");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("East Walkway")){
	         System.out.println("Inside East Walkway");
	            panel1.setBounds(580,1100,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        movesList.add("Bratwrust Hall");
	        movesList.add("Forbidden Parking");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in East Walkway");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Bratwrust Hall")){
	         System.out.println("Inside Bratwrust Hall");
	            panel1.setBounds(300,1800,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("East Walkway");
	        movesList.add("LA5");
	        
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Bratwrust Hall");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Forbidden Parking")){
	         System.out.println("Inside Forbidden Parking");
	            panel1.setBounds(350,700,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        movesList.add("Rec Center");
	        movesList.add("Student Parking");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Forbidden Parking");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Rec Center")){
	         System.out.println("Inside Rec Center");
	            panel1.setBounds(-150,700,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        
	        movesList.add("Student Parking");
	        movesList.add("George Allen Field");
	        movesList.add("Walter Pyramid");
	        movesList.add("Student Parking");
	        movesList.add("West Walkway");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Rec Center");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Student Parking")){
	         System.out.println("Inside Student Parking");
	            panel1.setBounds(350,350,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	            
	        movesList.add("Walter Pyramid");
	        movesList.add("Rec Center");
	        movesList.add("Japanese Garden ");
	        movesList.add("Forbidden Parking");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Student Parking");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Walter Pyramid")){
	         System.out.println("Inside Walter Pyramid");
	            panel1.setBounds(-350,350,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	            
	        movesList.add("Walter Pyramid");
	        movesList.add("Rec Center");
	        movesList.add("Japanese Garden ");
	        movesList.add("Student Parking");
	        movesList.add("George Allen Field");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Walter Pyramid");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Japanese Garden")){
	         System.out.println("Inside Japanese Garden");
	            panel1.setBounds(-350,150,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	            
	        movesList.add("Walter Pyramid");
	        movesList.add("Student Parking");
	        movesList.add("George Allen Field");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Japanese Garden");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("George Allen Field")){
	         System.out.println("Inside George Allen Field");
	            panel1.setBounds(-750,70,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	            
	        movesList.add("Walter Pyramid");
	        movesList.add("Japanese Garden");
	        movesList.add("West Walkway");
	        movesList.add("Rec Center");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in George Allen Field");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("West Walkway")){
	         System.out.println("Inside West Walkway");
	            panel1.setBounds(-850,1200,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	            
	        movesList.add("George Allen Field");
	        movesList.add("North Hall");
	        movesList.add("Library");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in West Walkway");
	        }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("North Hall")){
	         System.out.println("Inside North Hall");
	            panel1.setBounds(-500,1200,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("South Hall");
	        movesList.add("ECS 302");
	        movesList.add("Computer Lab");
	        movesList.add("West Walkway");
	        movesList.add("Elevators");
	        movesList.add("Room of Retirement");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in North Hall");

	        moveButton.setEnabled(false);
	     }
	        
	        if(globalSelectedRoom.equalsIgnoreCase("Library")){
	         System.out.println("Inside Library");
	            panel1.setBounds(-700,1800,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("West Walkway");
	        movesList.add("LA5");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Library");
	      
	     }
	        
	          if(globalSelectedRoom.equalsIgnoreCase("Room of Retirement")){
	         System.out.println("Inside Room of Retirement");
	            panel1.setBounds(-700,1400,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("North Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Room of Retirement");
	      
	     }
	          
	           if(globalSelectedRoom.equalsIgnoreCase("Computer Lab")){
	         System.out.println("Inside Computer Lab");
	            panel1.setBounds(-700,950,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("North Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Computer Lab");
	      
	     }
	        
	        
	          if(globalSelectedRoom.equalsIgnoreCase("LA5")){
	         System.out.println("Inside LA5");
	            panel1.setBounds(-100,1800,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("Library");
	        movesList.add("Elevators");
	        movesList.add("Bratwrust Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in LA5");
	      
	     }
	          
	          if(globalSelectedRoom.equalsIgnoreCase("Elevators")){
	         System.out.println("Inside Elevators");
	            panel1.setBounds(-300,1400,1900,1320);
	            panel1.repaint();
	            
	            movesList.removeAll();
	        movesList.add("LA5");
	        movesList.add("North Hall");
	        
	        currentState.setText("You are " + currentPlayer + " and You are in Elevators");
	      
	     }
	          
	          
	      
	          
	          
	     }
	     
	     
	}
	 
	 
	 class SelectedMoveClass implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String SelectedMoveClass = e.getActionCommand().toString();
				System.out.println("---"+SelectedMoveClass);
				selectedMove=SelectedMoveClass;
			   globalSelectedRoom=selectedMove;
				moveButton.setEnabled(true);
			}	
		}	 
	 


     class PlayCardListner implements ActionListener{

     @Override
     public void actionPerformed(ActionEvent e) {
        //globalSelectedRoom=e.getActionCommand().toString();
        System.out.println("played");
        System.out.println("Selcted room: "+globalSelectedRoom); 
        
         moveButton.setEnabled(true);
    
         int tempMove = 1;
         tempMove = numGen(movesList3.getItemCount());
         tempMove--;
         globalSelectedRoom3=movesList3.getItem(tempMove);
     aI3Move();
         tempMove = numGen(movesList2.getItemCount());
         tempMove--;
         globalSelectedRoom2=movesList2.getItem(tempMove);
     aI2Move();
         
     }
     
	 public void aI2Move(){
         if(globalSelectedRoom2.equalsIgnoreCase("South Hall")){
         System.out.println("Inside South Hall");
            panel2.setBounds(200,1150,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
            movesList2.add("North Hall");
            movesList2.add("ECS 302");
            movesList2.add("Eat Club");
            movesList2.add("CECS Conference Room");
            movesList2.add("Lactation Lounge");
            movesList2.add("East Walkway");
            movesList2.add("ECS 308");
            
            //currentState.setText("You are " + currentPlayer +" and You are in South Hall");
        }
        
         
        if(globalSelectedRoom2.equalsIgnoreCase("ECS 302")){
         System.out.println("Inside ECS 302 room");
            panel2.setBounds(0,1050,1750,1000);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("North Hall");
        movesList2.add("South Hall");
        
       // currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Eat Club")){
         System.out.println("Inside Eat Club");
            panel2.setBounds(200,950,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        
      //  currentState.setText("You are" + currentPlayer + " and You are in Eat Club");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("CECS Conference Room")){
         System.out.println("Inside CECS Conference Room");
            panel2.setBounds(370,950,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in CECS Conference Room");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Lactation Lounge")){
         System.out.println("Inside Lactation Lounge");
            panel2.setBounds(400,1450,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Lactation Lounge");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("ECS 308")){
         System.out.println("Inside ECS 308");
            panel2.setBounds(0,1370,1750, 13270);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in ECS 308");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("East Walkway")){
         System.out.println("Inside East Walkway");
            panel2.setBounds(580,1150,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        movesList2.add("Bratwrust Hall");
        movesList2.add("Forbidden Parking");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in East Walkway");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Bratwrust Hall")){
         System.out.println("Inside Bratwrust Hall");
            panel2.setBounds(300,1850,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("East Walkway");
        movesList2.add("LA5");
        
        
    //    currentState.setText("You are" + currentPlayer + " and You are in Bratwrust Hall");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Forbidden Parking")){
         System.out.println("Inside Forbidden Parking");
            panel2.setBounds(350,750,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        movesList2.add("Rec Center");
        movesList2.add("Student Parking");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Forbidden Parking");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Rec Center")){
         System.out.println("Inside Rec Center");
            panel2.setBounds(-150,750,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        
        movesList2.add("Student Parking");
        movesList2.add("George Allen Field");
        movesList2.add("Walter Pyramid");
        movesList2.add("Student Parking");
        movesList2.add("West Walkway");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Rec Center");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Student Parking")){
         System.out.println("Inside Student Parking");
            panel2.setBounds(350,300,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
            
        movesList2.add("Walter Pyramid");
        movesList2.add("Rec Center");
        movesList2.add("Japanese Garden ");
        movesList2.add("Forbidden Parking");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Student Parking");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Walter Pyramid")){
         System.out.println("Inside Walter Pyramid");
            panel2.setBounds(-350,300,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
            
        movesList2.add("Walter Pyramid");
        movesList2.add("Rec Center");
        movesList2.add("Japanese Garden ");
        movesList2.add("Student Parking");
        movesList2.add("George Allen Field");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Walter Pyramid");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Japanese Garden")){
         System.out.println("Inside Japanese Garden");
            panel2.setBounds(-350,100,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
            
        movesList2.add("Walter Pyramid");
        movesList2.add("Student Parking");
        movesList2.add("George Allen Field");
        
      //  currentState.setText("You are" + currentPlayer + " and You are in Japanese Garden");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("George Allen Field")){
         System.out.println("Inside George Allen Field");
            panel2.setBounds(-750,100,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
            
        movesList2.add("Walter Pyramid");
        movesList2.add("Japanese Garden");
        movesList2.add("West Walkway");
        movesList2.add("Rec Center");
        
      //  currentState.setText("You are" + currentPlayer + " and You are in George Allen Field");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("West Walkway")){
         System.out.println("Inside West Walkway");
            panel2.setBounds(-850,1150,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
            
        movesList2.add("George Allen Field");
        movesList2.add("North Hall");
        movesList2.add("Library");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in West Walkway");
        }
        
        if(globalSelectedRoom2.equalsIgnoreCase("North Hall")){
         System.out.println("Inside North Hall");
            panel2.setBounds(-400,1200,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("South Hall");
        movesList2.add("ECS 302");
        movesList2.add("Computer Lab");
        movesList2.add("West Walkway");
        movesList2.add("Elevators");
        movesList2.add("Room of Retirement");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in North Hall");

        moveButton.setEnabled(false);
     }
        
        if(globalSelectedRoom2.equalsIgnoreCase("Library")){
         System.out.println("Inside Library");
            panel2.setBounds(-700,1850,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("West Walkway");
        movesList2.add("LA5");
        
    //    currentState.setText("You are" + currentPlayer + " and You are in Library");
      
     }
        
          if(globalSelectedRoom2.equalsIgnoreCase("Room of Retirement")){
         System.out.println("Inside Room of Retirement");
            panel2.setBounds(-700,1450,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("North Hall");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Room of Retirement");
      
     }
          
           if(globalSelectedRoom2.equalsIgnoreCase("Computer Lab")){
         System.out.println("Inside Computer Lab");
            panel2.setBounds(-700,1000,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("North Hall");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Computer Lab");
      
     }
        
        
          if(globalSelectedRoom2.equalsIgnoreCase("LA5")){
         System.out.println("Inside LA5");
            panel2.setBounds(-100,1850,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("Library");
        movesList2.add("Elevators");
        movesList2.add("Bratwrust Hall");
        
    //    currentState.setText("You are" + currentPlayer + " and You are in LA5");
      
     }
      
          if(globalSelectedRoom2.equalsIgnoreCase("Elevators")){
         System.out.println("Inside Elevators");
            panel2.setBounds(-290,1450,1900,1320);
            panel2.repaint();
            
            movesList2.removeAll();
        movesList2.add("LA5");
        movesList2.add("North Hall");
        
     //   currentState.setText("You are" + currentPlayer + " and You are in Elevators");
      
     }
         
     }
     
     public void aI3Move(){
         
         
         if(globalSelectedRoom3.equalsIgnoreCase("South Hall")){
        System.out.println("Inside South Hall");
           panel3.setBounds(60,1200,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
           movesList3.add("North Hall");
           movesList3.add("ECS 302");
           movesList3.add("Eat Club");
           movesList3.add("CECS Conference Room");
           movesList3.add("Lactation Lounge");
           movesList3.add("East Walkway");
           movesList3.add("ECS 308");
           
      //     currentState.setText("You are " + currentPlayer +" and You are in South Hall");
       }
       
        
       if(globalSelectedRoom3.equalsIgnoreCase("ECS 302")){
        System.out.println("Inside ECS 302 room");
           panel3.setBounds(0,950,1750,1000);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("North Hall");
       movesList3.add("South Hall");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Eat Club")){
        System.out.println("Inside Eat Club");
           panel3.setBounds(200,1000,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       
     //  currentState.setText("You are" + currentPlayer + " and You are in Eat Club");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("CECS Conference Room")){
        System.out.println("Inside CECS Conference Room");
           panel3.setBounds(370,1000,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in CECS Conference Room");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Lactation Lounge")){
        System.out.println("Inside Lactation Lounge");
           panel3.setBounds(400,1500,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in Lactation Lounge");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("ECS 308")){
        System.out.println("Inside ECS 308");
           panel3.setBounds(0,1420,1750, 1420);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in ECS 308");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("East Walkway")){
        System.out.println("Inside East Walkway");
           panel3.setBounds(580,1200,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       movesList3.add("Bratwrust Hall");
       movesList3.add("Forbidden Parking");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in East Walkway");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Bratwrust Hall")){
        System.out.println("Inside Bratwrust Hall");
           panel3.setBounds(300,1900,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("East Walkway");
       movesList3.add("LA5");
       
       
    //   currentState.setText("You are" + currentPlayer + " and You are in Bratwrust Hall");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Forbidden Parking")){
        System.out.println("Inside Forbidden Parking");
           panel3.setBounds(500,750,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       movesList3.add("Rec Center");
       movesList3.add("Student Parking");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in Forbidden Parking");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Rec Center")){
        System.out.println("Inside Rec Center");
           panel3.setBounds(-150,650,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       
       movesList3.add("Student Parking");
       movesList3.add("George Allen Field");
       movesList3.add("Walter Pyramid");
       movesList3.add("Student Parking");
       movesList3.add("West Walkway");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in Rec Center");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Student Parking")){
        System.out.println("Inside Student Parking");
           panel3.setBounds(350,400,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
           
       movesList3.add("Walter Pyramid");
       movesList3.add("Rec Center");
       movesList3.add("Japanese Garden ");
       movesList3.add("Forbidden Parking");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in Student Parking");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Walter Pyramid")){
        System.out.println("Inside Walter Pyramid");
           panel3.setBounds(-350,400,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
           
       movesList3.add("Walter Pyramid");
       movesList3.add("Rec Center");
       movesList3.add("Japanese Garden ");
       movesList3.add("Student Parking");
       movesList3.add("George Allen Field");
       
     //  currentState.setText("You are" + currentPlayer + " and You are in Walter Pyramid");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Japanese Garden")){
        System.out.println("Inside Japanese Garden");
           panel3.setBounds(-350,50,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
           
       movesList3.add("Walter Pyramid");
       movesList3.add("Student Parking");
       movesList3.add("George Allen Field");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in Japanese Garden");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("George Allen Field")){
        System.out.println("Inside George Allen Field");
           panel3.setBounds(-750,150,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
           
       movesList3.add("Walter Pyramid");
       movesList3.add("Japanese Garden");
       movesList3.add("West Walkway");
       movesList3.add("Rec Center");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in George Allen Field");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("West Walkway")){
        System.out.println("Inside West Walkway");
           panel3.setBounds(-850,1100,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
           
       movesList3.add("George Allen Field");
       movesList3.add("North Hall");
       movesList3.add("Library");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in West Walkway");
       }
       
       if(globalSelectedRoom3.equalsIgnoreCase("North Hall")){
        System.out.println("Inside North Hall");
           panel3.setBounds(-300,1200,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("South Hall");
       movesList3.add("ECS 302");
       movesList3.add("Computer Lab");
       movesList3.add("West Walkway");
       movesList3.add("Elevators");
       movesList3.add("Room of Retirement");
       
  //     currentState.setText("You are" + currentPlayer + " and You are in North Hall");

       moveButton.setEnabled(false);
    }
       
       if(globalSelectedRoom3.equalsIgnoreCase("Library")){
        System.out.println("Inside Library");
           panel3.setBounds(-700,1900,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("West Walkway");
       movesList3.add("LA5");
       
    //   currentState.setText("You are" + currentPlayer + " and You are in Library");
     
    }
       
         if(globalSelectedRoom3.equalsIgnoreCase("Room of Retirement")){
        System.out.println("Inside Room of Retirement");
           panel3.setBounds(-550,1450,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("North Hall");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in Room of Retirement");
     
    }
         
          if(globalSelectedRoom3.equalsIgnoreCase("Computer Lab")){
        System.out.println("Inside Computer Lab");
           panel3.setBounds(-700,900,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("North Hall");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in Computer Lab");
     
    }
       
       
         if(globalSelectedRoom3.equalsIgnoreCase("LA5")){
        System.out.println("Inside LA5");
           panel3.setBounds(-100,1900,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("Library");
       movesList3.add("Elevators");
       movesList3.add("Bratwrust Hall");
       
   //    currentState.setText("You are" + currentPlayer + " and You are in LA5");
     
    }
     
         if(globalSelectedRoom3.equalsIgnoreCase("Elevators")){
        System.out.println("Inside Elevators");
           panel3.setBounds(-280,1500,1900,1320);
           panel3.repaint();
           
           movesList3.removeAll();
       movesList3.add("LA5");
       movesList3.add("North Hall");
       
  //     currentState.setText("You are" + currentPlayer + " and You are in Elevators");
     
    }
    }
     public int numGen(int count)
 {
   int  number = 0;
 
   Random randNum = new  Random();
 
   for(int counter = 1; counter<=1; counter++)
       {
          number =  1+randNum.nextInt(count);
          System.out.println("The random player selected is " + number);
        }
           return number;

    }
     
     }

}
     
     
