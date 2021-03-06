package com.java;

import com.java.*;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
//import java.util.Arrays;


public class Test1 {

    public static void main(String[] args) {
    	List locallist= new List();
        try {
        	locallist.add("1");
        	locallist.add("2");
        	locallist.add("3");
        	locallist.add("4");
        	locallist.add("5");
            // TODO Auto-generated method stub
        } catch (Exception ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    private JPanel panelPlayer1 = new JPanel();
    private String gSelRoom = "";
    private String gSelRoom2 = "South Hall"; // Because the first move of all the players is South Hall
    private String gSelRoom3 = "South Hall";
    private ImageIcon imageCard ;
    private JLabel labelCard;
    private List DiscardedCardDeck = new List();
    private List commonDeck = new List();
    private List playerOneDeck = new List();
    private List playerTwoDeck = new List();
    private List playerThreeDeck = new List();
    private JButton moveButton = new JButton("Move");
    String[] PlayerName = {"Kevin", "Niru", "Deeksha"};
    String[] RoomNames = {"Brotman Hall", "ECS 302", "ECS 308", "Elevators", "South Hall", "Lactation Lounge", "Room of Retirement", "East Walkway", "LA5", "Library", "West Walkway", "North Hall", "Computer Lab", "Eat Club", "CECS Conference Room", "Forbidden Parking", "Rec Center", "Student Parking", "Walter Pyramid", "Japanese Garden", "George Allen Field"};
    //private ArrayList<RoomCoordinates> = new ArrayList<RoomCoordinates>();
    List movesList = new List();
    List movesList2 = new List();
    List movesList3 = new List();
    public JLabel currentState = new JLabel();
    String currentPlayer;
    RandomNumberGenerator generator = new RandomNumberGenerator();
    JPanel panelPlayer2 = new JPanel();
    JPanel panelPlayer3 = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel upperPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel panelCard = new JPanel();
    JLabel cardsCount = new JLabel("Cards in Deck: ");
    JLabel cardsCountValue = new JLabel("35");
    JLabel discardsCount = new JLabel("Discards out of play: ");
    JLabel discardsCountValue = new JLabel("0");
    int discardCardVal=0;
    JLabel playerOneLabel = new JLabel("Kevin");
    JLabel playerTwoLabel = new JLabel("Niru");
    JLabel playerThreeLabel = new JLabel("Deeksha");
    JButton cardButton = new JButton("Draw Card");
    JButton playButton = new JButton("Play Card");
    int cardCnt = 1;
    int moveCnt=0;
    int humanCount=0;
    Player hPlayer= new Player(); 
    Player a1Player= new Player();
    Player a2Player= new Player();
    Util objUtil= new Util();
    Integer[] deckArr;  
    private JTable scoreTable;
    Color customColor = new Color(125,125,235);
    int monitor;
    boolean year2=false;
    
    public void startGame(){
    
deckArr = objUtil.dealDeck().toArray( new Integer[objUtil.dealDeck().size()]);
        
        for(int p=0; p < deckArr.length; p++){
            commonDeck.add(deckArr[p].toString());
        }
        
        for(int p=0; p < deckArr.length; p++){
    //        System.out.println("commonDeck: "+commonDeck.getItem(p));
        }
        
        playerOneDeck.add(commonDeck.getItem(0));
        playerOneDeck.add(commonDeck.getItem(1));
        playerOneDeck.add(commonDeck.getItem(2));
        playerOneDeck.add(commonDeck.getItem(3));
        playerOneDeck.add(commonDeck.getItem(4));        
            playerTwoDeck.add(commonDeck.getItem(5));
            playerTwoDeck.add(commonDeck.getItem(6));
            playerTwoDeck.add(commonDeck.getItem(7));
            playerTwoDeck.add(commonDeck.getItem(8));
            playerTwoDeck.add(commonDeck.getItem(9));

            playerThreeDeck.add(commonDeck.getItem(10));
            playerThreeDeck.add(commonDeck.getItem(11));
            playerThreeDeck.add(commonDeck.getItem(12));
            playerThreeDeck.add(commonDeck.getItem(13));
            playerThreeDeck.add(commonDeck.getItem(14));
         
        if(!year2){    
		imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card" + playerOneDeck.getItem(0) + ".jpg");
        }else{
        	imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/year/card" + playerOneDeck.getItem(0) + ".jpg");
        }
		labelCard = new JLabel(imageCard);        

    }
    
    public Test1() {
        
        
        
    	startGame();
        
        int tempPlayer = 0;
        tempPlayer = generator.numGenerator();
       // tempPlayer--;
        currentPlayer = PlayerName[tempPlayer];

        System.out.println("" + currentPlayer + "'s a human player");
        
        currentState.setText("Hello " + currentPlayer + ", Let the game begin. You are in ECS 308");
        
//        use this code when all cards are ready
        labelCard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                if (cardCnt > 4) {
                    cardCnt = humanCount;
                }
                
                if(!year2){  
                imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card" + playerOneDeck.getItem(cardCnt) + ".jpg");
                }else{
                	imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/year/card" + playerOneDeck.getItem(cardCnt) + ".jpg");

                }
                labelCard.setIcon(imageCard);
                cardCnt++;
       //         System.out.println("you have clicked image");
            }
        });
        JFrame frame = new JFrame();

        JTextField notes = new JTextField(currentPlayer + "'s a human player", 6);

        playerOneLabel.setText(currentPlayer);
        customColor = new Color(51, 204, 51);
        playerOneLabel.setForeground(customColor);

        hPlayer.setChosenLabel(currentPlayer);
        hPlayer.setCraftChip(2);
        hPlayer.setIntegrityChip(2);
        hPlayer.setLearningChip(2);
        hPlayer.setCurrentLocation("ECS 308");
        hPlayer.setQualityPoints(0);

        a1Player.setChosenLabel("Niru");
        a1Player.setCraftChip(0);
        a1Player.setIntegrityChip(4);
        a1Player.setLearningChip(2);
        a1Player.setCurrentLocation("ECS 308");
        a1Player.setQualityPoints(0);

        a2Player.setChosenLabel("Deeksha");
        a2Player.setCraftChip(1);
        a2Player.setIntegrityChip(2);
        a2Player.setLearningChip(3);
        a2Player.setCurrentLocation("ECS 308");
        a2Player.setQualityPoints(0);

        
        customColor = new Color(255,0,255);

        playerTwoLabel.setForeground(customColor);
        if (currentPlayer.equalsIgnoreCase("Niru")) {
            playerTwoLabel.setText("Kevin");
        
        
        hPlayer.setCraftChip(2);
        hPlayer.setIntegrityChip(2);
        hPlayer.setLearningChip(2);
        hPlayer.setCurrentLocation("ECS 308");
        hPlayer.setQualityPoints(0);

        a1Player.setChosenLabel("Kevin");
        a1Player.setCraftChip(1);
        a1Player.setIntegrityChip(2);
        a1Player.setLearningChip(3);
        a1Player.setCurrentLocation("ECS 308");
        a1Player.setQualityPoints(0);

        a2Player.setChosenLabel("Deeksha");
        a2Player.setCraftChip(3);
        a2Player.setIntegrityChip(3);
        a2Player.setLearningChip(2);
        a2Player.setCurrentLocation("ECS 308");
        a2Player.setQualityPoints(0);

        }
        customColor = new Color(125,125,235);
        playerThreeLabel.setForeground(customColor);

        if (currentPlayer.equalsIgnoreCase("Deeksha")) {
            playerThreeLabel.setText("Kevin");
        hPlayer.setCraftChip(0);
        hPlayer.setIntegrityChip(2);
        hPlayer.setLearningChip(2);
        hPlayer.setCurrentLocation("ECS 308");
        hPlayer.setQualityPoints(0);

        a1Player.setChosenLabel("Niru");
        a1Player.setCraftChip(0);
        a1Player.setIntegrityChip(4);
        a1Player.setLearningChip(2);
        a1Player.setCurrentLocation("ECS 308");
        a1Player.setQualityPoints(0);

        a2Player.setChosenLabel("Kevin");
        a2Player.setCraftChip(2);
        a2Player.setIntegrityChip(2);
        a2Player.setLearningChip(2);
        a2Player.setCurrentLocation("ECS 308");
        a2Player.setQualityPoints(0);

        }


        // Nirupama /c/Nirupama/SEproject/CECS543    SEproject\CECS543\CECS_BS\src
        //  Image image = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\CSULBMap3.png").getImage();
        //  Image card1 = new ImageIcon("C:\\Nirupama\\SEproject\\CECS543\\CECS_BS\\src\\com\\drawable\\Card1.png").getImage();
          
          //Kevin  
          ImageIcon image = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/CSULBMap3.png");
          //Image card1 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Card1.png").getImage();
         
          //Deeksha
         // Image image = new ImageIcon("C:\\Users\\DEEKSHA\\Desktop\\CSULB\\CECS543\\CECS543\\CECS_BS\\src\\com\\drawable\\CSULBMap3.png").getImage();
        //  Image card1 = new ImageIcon("C:\\Users\\DEEKSHA\\Desktop\\CSULB\\CECS543\\CECS543\\CECS_BS\\src\\com\\drawable\\Card1.png").getImage();
        
        JLabel mapLabel = new JLabel(image);
        movesList.add("South Hall");
        movesList2.add("South Hall");
        movesList3.add("South Hall");
        movesList.addActionListener(new movePlayerLL());
        ImageIcon bottomImage = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Background.png");
        JLabel bottomLabel = new JLabel(bottomImage);
        
        

        String data[][] = {{"", "Learning", "Craft", "Integrity", "Quality Points"},
            {hPlayer.getChosenLabel(), ""+hPlayer.getLearningChip()+"",""+""+hPlayer.getCraftChip()+"", ""+hPlayer.getIntegrityChip()+"", ""+""+hPlayer.getQualityPoints()+""}, 
            {a1Player.getChosenLabel(), ""+a1Player.getLearningChip()+"",""+""+a1Player.getCraftChip()+"", ""+a1Player.getIntegrityChip()+"", ""+""+a1Player.getQualityPoints()+""},  
            {a2Player.getChosenLabel(), ""+a2Player.getLearningChip()+"",""+""+a2Player.getCraftChip()+"", ""+a2Player.getIntegrityChip()+"", ""+""+a2Player.getQualityPoints()+""},  };
        String column[] = {" ", "Learning", "Craft", "Integrity", "Quality Points"};

        scoreTable = new JTable(data, column);
        frame.add(upperPanel);
        frame.add(bottomPanel);
        labelCard.addMouseListener(null);

        cardButton.setOpaque(false);
        cardButton.setBounds(10, 10, 110, 33);
        cardButton.addActionListener(new cardDrawBB());
        bottomLabel.add(cardButton);

        moveButton.setOpaque(false);
        moveButton.setBounds(10, 47, 110, 33);
        moveButton.setEnabled(false);
        moveButton.addActionListener(new moveBB());
        bottomLabel.add(moveButton);

        playButton.setOpaque(false);
        playButton.setBounds(10, 85, 110, 33);
        playButton.setEnabled(false);
        playButton.addActionListener(new PlayCardListner());
        bottomLabel.add(playButton);

        labelCard.setOpaque(false);
        labelCard.setBounds(190, 10, 329, 320);
        bottomLabel.add(labelCard);

        movesList.setBounds(10, 130, 170, 100);
        bottomLabel.add(movesList);

        scoreTable.setBounds(600, 40, 500, 500);
        scoreTable.setOpaque(false);
        scoreTable.setGridColor(Color.red);
        scoreTable.setBackground(Color.LIGHT_GRAY);
        bottomLabel.add(scoreTable);

        cardsCount.setOpaque(false);
        cardsCount.setBounds(600, 130, 100, 10);
        cardsCount.setBackground(Color.LIGHT_GRAY);
        bottomLabel.add(cardsCount);
        bottomLabel.setBackground(Color.LIGHT_GRAY);
        cardsCountValue.setOpaque(false);
        cardsCountValue.setBounds(694, 130, 40, 10);
        cardsCountValue.setBackground(Color.LIGHT_GRAY);
        bottomLabel.add(cardsCountValue);

        discardsCount.setOpaque(false);
        discardsCount.setBounds(800, 130, 220, 10);
        discardsCount.setBackground(Color.LIGHT_GRAY);
        bottomLabel.add(discardsCount);
        discardsCountValue.setOpaque(false);
        discardsCountValue.setBounds(930, 130, 130, 14);
        bottomLabel.add(discardsCountValue);

        currentState.setOpaque(false);
        currentState.setBounds(600, 150, 500, 10);
        bottomLabel.add(currentState);

        notes.setOpaque(false);
        notes.setBounds(600, 180, 500, 50);
        bottomLabel.add(notes);
        bottomLabel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        upperPanel.add(mapLabel);
        bottomPanel.add(bottomLabel);
        mapLabel.add(panelPlayer1);

        panelPlayer1.setOpaque(false);
        panelPlayer1.setBounds(0, 1320, 1750, 1320);
        panelPlayer1.add(playerOneLabel);

        mapLabel.add(panelPlayer2);
        panelPlayer2.setOpaque(false);
        panelPlayer2.setBounds(0, 1370, 1750, 1370);
        panelPlayer2.add(playerTwoLabel);

        mapLabel.add(panelPlayer3);
        panelPlayer3.setOpaque(false);
        panelPlayer3.setBounds(0, 1420, 1750, 1420);
        panelPlayer3.add(playerThreeLabel);

        JScrollPane scrollPane = new JScrollPane(upperPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1440, 500);

        JScrollPane scrollPane2 = new JScrollPane(bottomPanel);
        scrollPane2.setBounds(0, 500, 1440, 800);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1900, 1080));
        contentPane.add(scrollPane);
        contentPane.add(scrollPane2);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    class movePlayerLL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gSelRoom = e.getActionCommand().toString();
        //    System.out.println("Selcted room: " + gSelRoom);

            moveButton.setEnabled(true);
        }
    }

    class cardDrawBB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        //    System.out.println("U have clicked Draw card button");
        cardButton.setEnabled(false); 
        moveButton.setEnabled(true);
        playButton.setEnabled(true);
            System.out.println("Selected card number is"+humanCount);
            System.out.println("Selected card name is Card"+ playerOneDeck.getItem(humanCount));//replace with list index 
         humanCount++;
         cardCnt = humanCount;
        }
        
    }
    
    class moveBB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveCnt++;
            if(moveCnt>=3){
                moveButton.setEnabled(false);
            }
            playButton.setEnabled(true);
            hPlayer.setCurrentLocation(gSelRoom);
            if (gSelRoom.equalsIgnoreCase("South Hall")) {
            //    System.out.println("Inside South Hall");
                panelPlayer1.setBounds(200, 1200, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("North Hall");
                movesList.add("ECS 302");
                movesList.add("Eat Club");
                movesList.add("CECS Conference Room");
                movesList.add("Lactation Lounge");
                movesList.add("East Walkway");
                movesList.add("ECS 308");
                currentState.setText("You are " + currentPlayer + " and You are in South Hall");
            }

            if (gSelRoom.equalsIgnoreCase("ECS 302")) {
          //      System.out.println("Inside ECS 302 room");
                panelPlayer1.setBounds(0, 1000, 1750, 1000);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("North Hall");
                movesList.add("South Hall");
                currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
            }

            if (gSelRoom.equalsIgnoreCase("Eat Club")) {
           //     System.out.println("Inside Eat Club");
                panelPlayer1.setBounds(200, 900, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("South Hall");
                currentState.setText("You are" + currentPlayer + " and You are in Eat Club");
            }

            if (gSelRoom.equalsIgnoreCase("CECS Conference Room")) {
           //     System.out.println("Inside CECS Conference Room");
                panelPlayer1.setBounds(350, 900, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in CECS Conference Room");
            }

            if (gSelRoom.equalsIgnoreCase("Lactation Lounge")) {
             //   System.out.println("Inside Lactation Lounge");
                panelPlayer1.setBounds(400, 1400, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in Lactation Lounge");
            }

            if (gSelRoom.equalsIgnoreCase("ECS 308")) {
            //    System.out.println("Inside ECS 308");
                panelPlayer1.setBounds(0, 1320, 1750, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("South Hall");
                currentState.setText("You are" + currentPlayer + " and You are in ECS 308");
            }

            if (gSelRoom.equalsIgnoreCase("East Walkway")) {
           //     System.out.println("Inside East Walkway");
                panelPlayer1.setBounds(580, 1100, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("South Hall");
                movesList.add("Brotman Hall");
                movesList.add("Forbidden Parking");
                currentState.setText("You are" + currentPlayer + " and You are in East Walkway");
            }

            if (gSelRoom.equalsIgnoreCase("Brotman Hall")) {
             //   System.out.println("Inside Brotman Hall");
                panelPlayer1.setBounds(300, 1800, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("East Walkway");
                movesList.add("LA5");
                currentState.setText("You are" + currentPlayer + " and You are in Brotman Hall");
            }

            if (gSelRoom.equalsIgnoreCase("Forbidden Parking")) {
           //     System.out.println("Inside Forbidden Parking");
                panelPlayer1.setBounds(350, 700, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");
                movesList.add("Rec Center");
                movesList.add("Student Parking");

                currentState.setText("You are" + currentPlayer + " and You are in Forbidden Parking");
            }

            if (gSelRoom.equalsIgnoreCase("Rec Center")) {
           //     System.out.println("Inside Rec Center");
                panelPlayer1.setBounds(-150, 700, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("Student Parking");
                movesList.add("George Allen Field");
                movesList.add("Walter Pyramid");
                movesList.add("Student Parking");
                movesList.add("West Walkway");
                currentState.setText("You are" + currentPlayer + " and You are in Rec Center");
            }

            if (gSelRoom.equalsIgnoreCase("Student Parking")) {
         //       System.out.println("Inside Student Parking");
                panelPlayer1.setBounds(350, 350, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("Walter Pyramid");
                movesList.add("Rec Center");
                movesList.add("Japanese Garden ");
                movesList.add("Forbidden Parking");
                currentState.setText("You are" + currentPlayer + " and You are in Student Parking");
            }

            if (gSelRoom.equalsIgnoreCase("Walter Pyramid")) {
           //     System.out.println("Inside Walter Pyramid");
                panelPlayer1.setBounds(-350, 350, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("Walter Pyramid");
                movesList.add("Rec Center");
                movesList.add("Japanese Garden ");
                movesList.add("Student Parking");
                movesList.add("George Allen Field");
                currentState.setText("You are" + currentPlayer + " and You are in Walter Pyramid");
            }

            if (gSelRoom.equalsIgnoreCase("Japanese Garden")) {
         //       System.out.println("Inside Japanese Garden");
                panelPlayer1.setBounds(-350, 150, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("Walter Pyramid");
                movesList.add("Student Parking");
                movesList.add("George Allen Field");
                currentState.setText("You are" + currentPlayer + " and You are in Japanese Garden");
            }

            if (gSelRoom.equalsIgnoreCase("George Allen Field")) {
         //       System.out.println("Inside George Allen Field");
                panelPlayer1.setBounds(-750, 70, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("Walter Pyramid");
                movesList.add("Japanese Garden");
                movesList.add("West Walkway");
                movesList.add("Rec Center");
                currentState.setText("You are" + currentPlayer + " and You are in George Allen Field");
            }

            if (gSelRoom.equalsIgnoreCase("West Walkway")) {
        //        System.out.println("Inside West Walkway");
                panelPlayer1.setBounds(-850, 1200, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("George Allen Field");
                movesList.add("North Hall");
                movesList.add("Library");
                currentState.setText("You are" + currentPlayer + " and You are in West Walkway");
            }

            if (gSelRoom.equalsIgnoreCase("North Hall")) {
         //       System.out.println("Inside North Hall");
                panelPlayer1.setBounds(-500, 1200, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("South Hall");
                movesList.add("ECS 302");
                movesList.add("Computer Lab");
                movesList.add("West Walkway");
                movesList.add("Elevators");
                movesList.add("Room of Retirement");
                currentState.setText("You are" + currentPlayer + " and You are in North Hall");
                moveButton.setEnabled(false);
            }

            if (gSelRoom.equalsIgnoreCase("Library")) {
                System.out.println("Inside Library");
                panelPlayer1.setBounds(-700, 1800, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("West Walkway");
                movesList.add("LA5");
                currentState.setText("You are" + currentPlayer + " and You are in Library");
            }

            if (gSelRoom.equalsIgnoreCase("Room of Retirement")) {
                System.out.println("Inside Room of Retirement");
                panelPlayer1.setBounds(-700, 1400, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("North Hall");
                currentState.setText("You are" + currentPlayer + " and You are in Room of Retirement");
            }

            if (gSelRoom.equalsIgnoreCase("Computer Lab")) {
                System.out.println("Inside Computer Lab");
                panelPlayer1.setBounds(-700, 950, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("North Hall");
                currentState.setText("You are" + currentPlayer + " and You are in Computer Lab");
            }
            
            if (gSelRoom.equalsIgnoreCase("LA5")) {
                System.out.println("Inside LA5");
                panelPlayer1.setBounds(-100, 1800, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("Library");
                movesList.add("Elevators");
                movesList.add("Brotman Hall");
                currentState.setText("You are" + currentPlayer + " and You are in LA5");
            }

            if (gSelRoom.equalsIgnoreCase("Elevators")) {
                System.out.println("Inside Elevators");
                panelPlayer1.setBounds(-300, 1400, 1900, 1320);
                panelPlayer1.repaint();
                movesList.removeAll();
                movesList.add("LA5");
                movesList.add("North Hall");

                currentState.setText("You are" + currentPlayer + " and You are in Elevators");

            }
        }
    }

    class PlayCardListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {            
         if(humanCount<5){
        	 if(!year2){
        	 imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card" + playerOneDeck.getItem(humanCount) + ".jpg");
        	 }else{
        		 imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/year/card" + playerOneDeck.getItem(humanCount) + ".jpg");
        	 }
        	 labelCard.setIcon(imageCard);
         }       
            
            if(humanCount>=5){
                humanCount=0;
            cardCnt=0;
                System.out.println("Please get new cards");
                playerOneDeck.removeAll();  
                playerOneDeck.add(commonDeck.getItem(15));
		        playerOneDeck.add(commonDeck.getItem(16));
		        playerOneDeck.add(commonDeck.getItem(17));
		        playerOneDeck.add(commonDeck.getItem(18));
		        playerOneDeck.add(commonDeck.getItem(19));        
		        playerTwoDeck.removeAll();    
		        playerTwoDeck.add(commonDeck.getItem(20));
	            playerTwoDeck.add(commonDeck.getItem(21));
	            playerTwoDeck.add(commonDeck.getItem(22));
	            playerTwoDeck.add(commonDeck.getItem(23));
	            playerTwoDeck.add(commonDeck.getItem(24));
	            playerThreeDeck.removeAll();
	            playerThreeDeck.add(commonDeck.getItem(25));
	            playerThreeDeck.add(commonDeck.getItem(26));
	            playerThreeDeck.add(commonDeck.getItem(27));
	            playerThreeDeck.add(commonDeck.getItem(28));
	            playerThreeDeck.add(commonDeck.getItem(29));
	            }else{            
		            hPlayer=sClass(hPlayer,Integer.parseInt(playerOneDeck.getItem(humanCount)));    
		            System.out.println("humanCount: "+humanCount);
		            scoreTable.setValueAt(""+hPlayer.getLearningChip()+"", 1, 1);
		            scoreTable.setValueAt(""+hPlayer.getCraftChip()+"", 1, 2);
		            scoreTable.setValueAt(""+hPlayer.getIntegrityChip()+"", 1, 3);
		            scoreTable.setValueAt(""+hPlayer.getQualityPoints()+"", 1, 4);
	            
                System.out.println("Integrity Points is: "+hPlayer.getLearningChip());
           
            if(hPlayer.isChooseQuality()){
                ChipsDialog objQualityD = new ChipsDialog();
            
            if(objQualityD.getSp().equalsIgnoreCase("Integrity")){
               
	        hPlayer.setIntegrityChip(hPlayer.getIntegrityChip()+1);
	        scoreTable.setValueAt(""+hPlayer.getIntegrityChip()+"", 1, 3);
	        
  
            }else if(objQualityD.getSp().equalsIgnoreCase("Learning")){
               hPlayer.setLearningChip(hPlayer.getLearningChip()+1);
                scoreTable.setValueAt(""+hPlayer.getLearningChip()+"", 1, 1); 
            }else{
             hPlayer.setCraftChip(hPlayer.getCraftChip()+1);   
                scoreTable.setValueAt(""+hPlayer.getCraftChip()+"", 1, 2);
            }
            
            }
            }
            System.out.println("played");
            System.out.println("Selcted room: " + gSelRoom);
            cardButton.setEnabled(true);
            playButton.setEnabled(false);

            int tempMove = 1;
            tempMove = numGen(movesList3.getItemCount());
            tempMove--;
            gSelRoom3 = movesList3.getItem(tempMove);
            aI3Move();
            a2Player= sClass(a2Player,Integer.parseInt(playerTwoDeck.getItem(humanCount-1)));
            scoreTable.setValueAt(""+a2Player.getLearningChip()+"", 3, 1);
            scoreTable.setValueAt(""+a2Player.getCraftChip()+"", 3, 2);
            scoreTable.setValueAt(""+a2Player.getIntegrityChip()+"", 3, 3);
            scoreTable.setValueAt(""+a2Player.getQualityPoints()+"", 3, 4);
 
           tempMove = numGen(movesList2.getItemCount());
            tempMove--;
            gSelRoom2 = movesList2.getItem(tempMove);
            aI2Move();
           a1Player= sClass(a1Player,Integer.parseInt(playerThreeDeck.getItem(humanCount-1)));
           scoreTable.setValueAt(""+a1Player.getLearningChip()+"", 2, 1);
            scoreTable.setValueAt(""+a1Player.getCraftChip()+"", 2, 2);
            scoreTable.setValueAt(""+a1Player.getIntegrityChip()+"", 2, 3);
            scoreTable.setValueAt(""+a1Player.getQualityPoints()+"", 2, 4);
            
            if(hPlayer.isDiscardCard()){
                CardDialog objDis= new CardDialog(playerOneDeck,humanCount-1, year2);
                playerOneDeck.remove(Integer.parseInt(objDis.getDc()));
                humanCount++;
                discardCardVal++;
            }
            
            monitor=hPlayer.getQualityPoints()+a1Player.getQualityPoints()+a2Player.getQualityPoints();
            if(monitor>=60){
                year2=true;
                System.out.print("Next level");
            }
            discardCardVal=discardCardVal+3;
            
            if(discardCardVal>=30){
            	discardCardVal=0;
            	System.out.println("deal the deck again");
            	startGame();
            	
            }
            discardsCountValue.setText(""+discardCardVal);
        }
        public void aI3Move() {
        	a2Player.setCurrentLocation(gSelRoom3);
            if (gSelRoom3.equalsIgnoreCase("South Hall")) {
            //    System.out.println("Inside South Hall");
                panelPlayer3.setBounds(60, 1200, 1900, 1320);
                panelPlayer3.repaint();	
                movesList3.removeAll();
                movesList3.add("North Hall");
                movesList3.add("ECS 302");
                movesList3.add("Eat Club");
                movesList3.add("CECS Conference Room");
                movesList3.add("Lactation Lounge");
                movesList3.add("East Walkway");
                movesList3.add("ECS 308");
            }


            if (gSelRoom3.equalsIgnoreCase("ECS 302")) {
         //       System.out.println("Inside ECS 302 room");
                panelPlayer3.setBounds(0, 950, 1750, 1000);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("North Hall");
                movesList3.add("South Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("Eat Club")) {
            //    System.out.println("Inside Eat Club");
                panelPlayer3.setBounds(200, 1000, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("South Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("CECS Conference Room")) {
           //     System.out.println("Inside CECS Conference Room");
                panelPlayer3.setBounds(370, 1000, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("Lactation Lounge")) {
         //       System.out.println("Inside Lactation Lounge");
                panelPlayer3.setBounds(400, 1500, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("South Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("ECS 308")) {
          //      System.out.println("Inside ECS 308");
                panelPlayer3.setBounds(0, 1420, 1750, 1420);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("South Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("East Walkway")) {
           //     System.out.println("Inside East Walkway");
                panelPlayer3.setBounds(580, 1200, 1900, 1320);
                panelPlayer3.repaint();	
                movesList3.removeAll();
                movesList3.add("South Hall");
                movesList3.add("Brotman Hall");
                movesList3.add("Forbidden Parking");
            }

            if (gSelRoom3.equalsIgnoreCase("Brotman Hall")) {
          //      System.out.println("Inside Brotman Hall");
                panelPlayer3.setBounds(300, 1900, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("East Walkway");
                movesList3.add("LA5");
            }

            if (gSelRoom3.equalsIgnoreCase("Forbidden Parking")) {
         //       System.out.println("Inside Forbidden Parking");
                panelPlayer3.setBounds(500, 750, 1900, 1320);
                panelPlayer3.repaint();	
                movesList3.removeAll();
                movesList3.add("South Hall");
                movesList3.add("Rec Center");
                movesList3.add("Student Parking");
            }

            if (gSelRoom3.equalsIgnoreCase("Rec Center")) {
             //   System.out.println("Inside Rec Center");
                panelPlayer3.setBounds(-150, 650, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("Student Parking");
                movesList3.add("George Allen Field");
                movesList3.add("Walter Pyramid");
                movesList3.add("Student Parking");
                movesList3.add("West Walkway");
            }

            if (gSelRoom3.equalsIgnoreCase("Student Parking")) {
        //        System.out.println("Inside Student Parking");
                panelPlayer3.setBounds(350, 400, 1900, 1320);
                panelPlayer3.repaint();	
                movesList3.removeAll();	
                movesList3.add("Walter Pyramid");
                movesList3.add("Rec Center");
                movesList3.add("Japanese Garden ");
                movesList3.add("Forbidden Parking");
            }

            if (gSelRoom3.equalsIgnoreCase("Walter Pyramid")) {
        //        System.out.println("Inside Walter Pyramid");
                panelPlayer3.setBounds(-350, 400, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("Walter Pyramid");
                movesList3.add("Rec Center");
                movesList3.add("Japanese Garden ");
                movesList3.add("Student Parking");
                movesList3.add("George Allen Field");
            }

            if (gSelRoom3.equalsIgnoreCase("Japanese Garden")) {
                System.out.println("Inside Japanese Garden");
                panelPlayer3.setBounds(-350, 50, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("Walter Pyramid");
                movesList3.add("Student Parking");
                movesList3.add("George Allen Field");
            }

            if (gSelRoom3.equalsIgnoreCase("George Allen Field")) {
                System.out.println("Inside George Allen Field");
                panelPlayer3.setBounds(-750, 150, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("Walter Pyramid");
                movesList3.add("Japanese Garden");
                movesList3.add("West Walkway");
                movesList3.add("Rec Center");
            }

            if (gSelRoom3.equalsIgnoreCase("West Walkway")) {
                System.out.println("Inside West Walkway");
                panelPlayer3.setBounds(-850, 1100, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("George Allen Field");
                movesList3.add("North Hall");
                movesList3.add("Library");
            }

            if (gSelRoom3.equalsIgnoreCase("North Hall")) {
                System.out.println("Inside North Hall");
                panelPlayer3.setBounds(-300, 1200, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("South Hall");
                movesList3.add("ECS 302");
                movesList3.add("Computer Lab");
                movesList3.add("West Walkway");
                movesList3.add("Elevators");
                movesList3.add("Room of Retirement");
                moveButton.setEnabled(false);
            }

            if (gSelRoom3.equalsIgnoreCase("Library")) {
                System.out.println("Inside Library");
                panelPlayer3.setBounds(-700, 1900, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("West Walkway");
                movesList3.add("LA5");
            }

            if (gSelRoom3.equalsIgnoreCase("Room of Retirement")) {
                System.out.println("Inside Room of Retirement");
                panelPlayer3.setBounds(-550, 1450, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("North Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("Computer Lab")) {
                System.out.println("Inside Computer Lab");
                panelPlayer3.setBounds(-700, 900, 1900, 1320);
                panelPlayer3.repaint();	
                movesList3.removeAll();
                movesList3.add("North Hall");
            }


            if (gSelRoom3.equalsIgnoreCase("LA5")) {
                System.out.println("Inside LA5");
                panelPlayer3.setBounds(-100, 1900, 1900, 1320);
                panelPlayer3.repaint();	
                movesList3.removeAll();
                movesList3.add("Library");
                movesList3.add("Elevators");
                movesList3.add("Brotman Hall");
            }

            if (gSelRoom3.equalsIgnoreCase("Elevators")) {
                System.out.println("Inside Elevators");
                panelPlayer3.setBounds(-280, 1500, 1900, 1320);
                panelPlayer3.repaint();
                movesList3.removeAll();
                movesList3.add("LA5");
                movesList3.add("North Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in Elevators");

            }
        }
        public void aI2Move() { 
            a1Player.setCurrentLocation(gSelRoom2); 
            if (gSelRoom2.equalsIgnoreCase("South Hall")) {
                System.out.println("Inside South Hall");
                panelPlayer2.setBounds(200, 1150, 1900, 1320);
                panelPlayer2.repaint();	
                movesList2.removeAll();
                movesList2.add("North Hall");
                movesList2.add("ECS 302");
                movesList2.add("Eat Club");
                movesList2.add("CECS Conference Room");
                movesList2.add("Lactation Lounge");
                movesList2.add("East Walkway");
                movesList2.add("ECS 308");
            }


            if (gSelRoom2.equalsIgnoreCase("ECS 302")) {
                System.out.println("Inside ECS 302 room");
                panelPlayer2.setBounds(0, 1050, 1750, 1000);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("North Hall");
                movesList2.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
            }

            if (gSelRoom2.equalsIgnoreCase("Eat Club")) {
                System.out.println("Inside Eat Club");
                panelPlayer2.setBounds(200, 950, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("South Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("CECS Conference Room")) {
                System.out.println("Inside CECS Conference Room");
                panelPlayer2.setBounds(370, 950, 1900, 1320);
                panelPlayer2.repaint();	
                movesList2.removeAll();
                movesList2.add("South Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("Lactation Lounge")) {
                System.out.println("Inside Lactation Lounge");
                panelPlayer2.setBounds(400, 1450, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("South Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("ECS 308")) {
                System.out.println("Inside ECS 308");
                panelPlayer2.setBounds(0, 1370, 1750, 13270);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("East Walkway")) {
                System.out.println("Inside East Walkway");
                panelPlayer2.setBounds(580, 1150, 1900, 1320);
                panelPlayer2.repaint();	
                movesList2.removeAll();
                movesList2.add("South Hall");
                movesList2.add("Brotman Hall");
                movesList2.add("Forbidden Parking");
            }

            if (gSelRoom2.equalsIgnoreCase("Brotman Hall")) {
                System.out.println("Inside Brotman Hall");
                panelPlayer2.setBounds(300, 1850, 1900, 1320);
                panelPlayer2.repaint();	
                movesList2.removeAll();
                movesList2.add("East Walkway");
                movesList2.add("LA5");
            }

            if (gSelRoom2.equalsIgnoreCase("Forbidden Parking")) {
                System.out.println("Inside Forbidden Parking");
                panelPlayer2.setBounds(350, 750, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");
                movesList2.add("Rec Center");
                movesList2.add("Student Parking");
            }

            if (gSelRoom2.equalsIgnoreCase("Rec Center")) {
                System.out.println("Inside Rec Center");
                panelPlayer2.setBounds(-150, 750, 1900, 1320);
                panelPlayer2.repaint();	
                movesList2.removeAll();	
                movesList2.add("Student Parking");
                movesList2.add("George Allen Field");
                movesList2.add("Walter Pyramid");
                movesList2.add("Student Parking");
                movesList2.add("West Walkway");
            }

            if (gSelRoom2.equalsIgnoreCase("Student Parking")) {
                System.out.println("Inside Student Parking");
                panelPlayer2.setBounds(350, 300, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();	
                movesList2.add("Walter Pyramid");
                movesList2.add("Rec Center");
                movesList2.add("Japanese Garden ");
                movesList2.add("Forbidden Parking");
            }

            if (gSelRoom2.equalsIgnoreCase("Walter Pyramid")) {
                System.out.println("Inside Walter Pyramid");
                panelPlayer2.setBounds(-350, 300, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("Walter Pyramid");
                movesList2.add("Rec Center");
                movesList2.add("Japanese Garden ");
                movesList2.add("Student Parking");
                movesList2.add("George Allen Field");
            }

            if (gSelRoom2.equalsIgnoreCase("Japanese Garden")) {
                System.out.println("Inside Japanese Garden");
                panelPlayer2.setBounds(-350, 100, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("Walter Pyramid");
                movesList2.add("Student Parking");
                movesList2.add("George Allen Field");
            }

            if (gSelRoom2.equalsIgnoreCase("George Allen Field")) {
                System.out.println("Inside George Allen Field");
                panelPlayer2.setBounds(-750, 100, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("Walter Pyramid");
                movesList2.add("Japanese Garden");
                movesList2.add("West Walkway");
                movesList2.add("Rec Center");
            }

            if (gSelRoom2.equalsIgnoreCase("West Walkway")) {
                System.out.println("Inside West Walkway");
                panelPlayer2.setBounds(-850, 1150, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("George Allen Field");
                movesList2.add("North Hall");
                movesList2.add("Library");
            }

            if (gSelRoom2.equalsIgnoreCase("North Hall")) {
                System.out.println("Inside North Hall");
                panelPlayer2.setBounds(-400, 1200, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("South Hall");
                movesList2.add("ECS 302");
                movesList2.add("Computer Lab");
                movesList2.add("West Walkway");
                movesList2.add("Elevators");
                movesList2.add("Room of Retirement");
                moveButton.setEnabled(false);
            }

            if (gSelRoom2.equalsIgnoreCase("Library")) {
                System.out.println("Inside Library");
                panelPlayer2.setBounds(-700, 1850, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("West Walkway");
                movesList2.add("LA5");
            }

            if (gSelRoom2.equalsIgnoreCase("Room of Retirement")) {
                System.out.println("Inside Room of Retirement");
                panelPlayer2.setBounds(-700, 1450, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("North Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("Computer Lab")) {
                System.out.println("Inside Computer Lab");
                panelPlayer2.setBounds(-700, 1000, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("North Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("LA5")) {
                System.out.println("Inside LA5");
                panelPlayer2.setBounds(-100, 1850, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("Library");
                movesList2.add("Elevators");
                movesList2.add("Brotman Hall");
            }

            if (gSelRoom2.equalsIgnoreCase("Elevators")) {
                System.out.println("Inside Elevators");
                panelPlayer2.setBounds(-290, 1450, 1900, 1320);
                panelPlayer2.repaint();
                movesList2.removeAll();
                movesList2.add("LA5");
                movesList2.add("North Hall");
            }

        
    }

        public Player sClass(Player player,int selectCnt){
            
            switch(selectCnt){
                case 1: if(year2){LBSUvsCSUCard lbsUvsCSU= new LBSUvsCSUCard(); player=lbsUvsCSU.play(player); }else{ CECS105Card6 CECS1056=new CECS105Card6();														player=CECS1056.play(player); }					break;
                case 2: ResearchCompilersCard ResearchCompilers=new ResearchCompilersCard(); 							player=ResearchCompilers.play(player); 			break;
                case 3: if(year2){CarPoolCard CarPool= new CarPoolCard(); player=CarPool.play(player); }else{ Math122Card Math122=new Math122Card();															player=Math122.play(player);} 					break;
                case 4: if(year2){CECS274Card CECS274= new CECS274Card(); player=CECS274.play(player); }else{ CECS174ClassCard CECS174Class=new CECS174ClassCard();											player=CECS174Class.play(player);}				break;
                case 5: LunchAtBratwrustHallCard LunchAtBratwrustHall=new LunchAtBratwrustHallCard();					player=LunchAtBratwrustHall.play(player);		break;
                case 6: if(year2){CECS201Card CECS201= new CECS201Card(); player=CECS201.play(player); }else{ CECS100Card CECS100=new CECS100Card(); 															player=CECS100.play(player);}					break;
                case 7: ExcercisingMindAndBodyCard ExcercisingMindAndBody=new ExcercisingMindAndBodyCard(); 			player=ExcercisingMindAndBody.play(player);		break;
                case 8: ParkingViolationCard ParkingViolation=new ParkingViolationCard();								player=ParkingViolation.play(player);			break;
                case 9: FindingTheLabCard FindingTheLab=new FindingTheLabCard();										player=FindingTheLab.play(player);				break;
                case 10: GoodByeProfessorCard GoodByeProfessor=new GoodByeProfessorCard(); 								player=GoodByeProfessor.play(player);			break;
                case 11: EnjyoyingThePeaceCard EnjyoyingThePeace=new EnjyoyingThePeaceCard(); 							player=EnjyoyingThePeace.play(player);			break;
                case 12: if(year2){ENGL317Card ENGL317= new ENGL317Card(); player=ENGL317.play(player); }else{ BuddyUpCard BuddyUp=new BuddyUpCard();															player=BuddyUp.play(player);}					break;
                case 13: LateForClassCard LateForClass=new LateForClassCard();											player=LateForClass.play(player);				break;
                case 14: if(year2){PHYS152Card PHYS152= new PHYS152Card(); player=PHYS152.play(player); }else{Physics151Card Physics151=new Physics151Card(); 												player=Physics151.play(player);	}				break;
                case 15: TheBigGameCard TheBigGame=new TheBigGameCard();												player=TheBigGame.play(player);					break;
                case 16: if(year2){PHIL270Card PHIL270= new PHIL270Card(); player=PHIL270.play(player); }else{KIN253LearningRulesSoccerCard KIN253LearningRulesSoccer=new KIN253LearningRulesSoccerCard();	player=KIN253LearningRulesSoccer.play(player);}	break;
                case 17: Math123Card Math123=new Math123Card();															player=Math123.play(player);					break;
                case 18: LearningNetbeansCard LearningNetbeans=new LearningNetbeansCard();								player=LearningNetbeans.play(player);			break;
                case 19: ChoosingAMajorCard ChoosingAMajor=new ChoosingAMajorCard();									player=ChoosingAMajor.play(player);				break;
                case 20: if(year2){CECS228Card CECS228= new CECS228Card(); player=CECS228.play(player); }else{PassSoccerClassCard PassSoccerClass=new PassSoccerClassCard(); 								player=PassSoccerClass.play(player);}			break;
                case 21: ScoreAGoalCard ScoreAGoal=new ScoreAGoalCard();												player=ScoreAGoal.play(player);					break;
                case 22: FallInThePondCard FallInThePond=new FallInThePondCard();										player=FallInThePond.play(player);				break;
                case 23: MakeTheDeanListCard MakeTheDeanList=new MakeTheDeanListCard();									player=MakeTheDeanList.play(player);			break;
                case 24: NewLaptopCard NewLaptop=new NewLaptopCard();													player=NewLaptop.play(player);					break;
                case 25: MeetTheDeanCard MeetTheDean=new MeetTheDeanCard();												player=MeetTheDean.play(player);				break;
                case 26: LoudBuzzingCard LoudBuzzing=new LoudBuzzingCard();												player=LoudBuzzing.play(player);				break;
                case 27: ProgramCrashesCard ProgramCrashes=new ProgramCrashesCard();									player=ProgramCrashes.play(player);				break;
                case 28: ProfessorEnglertCard ProfessorEnglert=new ProfessorEnglertCard();								player=ProfessorEnglert.play(player);			break;
                case 29: PressTheRightFloorCard PressTheRightFloor=new PressTheRightFloorCard();						player=PressTheRightFloor.play(player);			break;
                case 30: SoccerGoalieCard SoccerGoalie=new SoccerGoalieCard();											player=SoccerGoalie.play(player);				break;
                case 31: if(year2){CECS277Card CECS277= new CECS277Card(); player=CECS277.play(player); }else{ElectiveClassCard ElectiveClass=new ElectiveClassCard();										player=ElectiveClass.play(player);}				break;
                case 32: if(year2){CECS285Card CECS285= new CECS285Card(); player=CECS285.play(player); }else{OralCommunicationCard OralCommunication=new OralCommunicationCard();							player=OralCommunication.play(player);}			break;
                case 33: ProfessorHoffmanCard ProfessorHoffman=new ProfessorHoffmanCard();								player=ProfessorHoffman.play(player);			break;
                case 34: if(year2){CECS282Card CECS282= new CECS282Card(); player=CECS282.play(player); }else{Chem111Card Chem111=new Chem111Card();															player=Chem111.play(player);}					break;
                case 35: TheOutPostCard TheOutPost=new TheOutPostCard();												player=TheOutPost.play(player);					break;
                case 36: LearningLinuxCard LearningLinux=new LearningLinuxCard();										player=LearningLinux.play(player);				break;
                case 37: MakeAFriendCard MakeAFriend=new MakeAFriendCard();												player=MakeAFriend.play(player); 				break;
                case 38: EnjoyingNatureCard EnjoyingNature=new EnjoyingNatureCard(); 									player=EnjoyingNature.play(player); 			break;
                case 39: StudentParkingCard StudentParking = new StudentParkingCard();   								player=StudentParking.play(player);				break;
                case 40: if(year2){HaveaSwimCard HaveaSwim= new HaveaSwimCard(); player=HaveaSwim.play(player); }else{CECS100Card CECS1001 = new CECS100Card();														player=CECS1001.play(player);}					break;
            }
            return player;
        }
        public int numGen(int count) {
            int number = 0;

            Random randNum = new Random();

            for (int counter = 1; counter <= 1; counter++) {
                number = 1 + randNum.nextInt(count);
                System.out.println("The random player selected is " + number);
            }
            return number;

        }

    }   

        
}
