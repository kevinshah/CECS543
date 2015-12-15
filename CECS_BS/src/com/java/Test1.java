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

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
//import java.util.Arrays;

public class Test1 {

    /**
     * @param args
     */
    public static void main(String[] args) {

    	Test1 gb = new Test1();
     //   Test obj = new Test();
        
        try {
            //   obj.playMusic();
            // TODO Auto-generated method stub
        } catch (Exception ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    private JPanel panelPlayer1 = new JPanel();
    private String globalSelectedRoom = "";
    private String globalSelectedRoom2 = "South Hall"; // Because the first move of all the players is South Hall
    private String globalSelectedRoom3 = "South Hall";
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
    JLabel playerOneLabel = new JLabel("Kevin");
    JLabel playerTwoLabel = new JLabel("Niru");
    JLabel playerThreeLabel = new JLabel("Deeksha");
    JButton cardButton = new JButton("Draw Card");
    JButton playButton = new JButton("Play Card");
    int cardCnt = 1;
    int moveCnt=0;
    int humanCount=0;
    Player humanPlayer= new Player(); 
    Player playerAI1= new Player();
    Player playerAI2= new Player();
    Util objUtil= new Util();
    Integer[] deckArr;  
    private JTable scoreTable;
    Color customColor = new Color(125,125,235);
    public Test1() {
        
        
        
    deckArr = objUtil.dealDeck().toArray( new Integer[objUtil.dealDeck().size()]);
        
        for(int p=0; p < deckArr.length; p++){
            commonDeck.add(deckArr[p].toString());
        }
        
        for(int p=0; p < deckArr.length; p++){
            System.out.println("commonDeck: "+commonDeck.getItem(p));
        }
        
        
        
        int tempPlayer = 0;
        tempPlayer = generator.numGenerator();
       // tempPlayer--;
        currentPlayer = PlayerName[tempPlayer];

        System.out.println("" + currentPlayer + " is  human player");
        
        currentState.setText("Hello " + currentPlayer + ". The GAME BEGINS from 308");
        
//        use this code when all cards are ready
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
            
imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card" + playerOneDeck.getItem(0) + ".jpg");
labelCard = new JLabel(imageCard);        
//comment this code when all the cards are ready         
//        playerOneDeck.add("1");
//        playerOneDeck.add("2");
//        playerOneDeck.add("3");
//        playerOneDeck.add("4");
//        playerOneDeck.add("5");

        labelCard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                
                if (cardCnt > 4) {
                    cardCnt = humanCount;
                }
                
                imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card" + playerOneDeck.getItem(cardCnt) + ".jpg");
                labelCard.setIcon(imageCard);
                cardCnt++;
                //take value of cardCnt from human player deck
                             
                System.out.println("you have clicked image");
            }
        });
//        
//        Integer cardNum= new Integer(1);
//        cardNum=1;
//        while(cardNum<41){
//        commonDeck.add(cardNum.toString());
//        cardNum++;
//        }
//        
//        System.out.println("Cards in deck");
//        cardNum=0;
//        while(cardNum < 40){
//            System.out.println("--"+commonDeck.getItem(cardNum));         
//        cardNum++;
//        }
        JFrame frame = new JFrame();

        JTextField notes = new JTextField(currentPlayer + " is human player", 6);

        playerOneLabel.setText(currentPlayer);
        customColor = new Color(51, 204, 51);
        playerOneLabel.setForeground(customColor);
        //Font f = new Font("arial", Font.BOLD, 50);
        //playerOneLabel.setFont(f);
        
        humanPlayer.setChosenLabel(currentPlayer);
        humanPlayer.setCraftChip(2);
        humanPlayer.setIntegrityChip(2);
        humanPlayer.setLearningChip(2);
        humanPlayer.setCurrentLocation("ECS 308");
        humanPlayer.setQualityPoints(6);

        playerAI1.setChosenLabel("Niru");
        playerAI1.setCraftChip(0);
        playerAI1.setIntegrityChip(4);
        playerAI1.setLearningChip(2);
        playerAI1.setCurrentLocation("ECS 308");
        playerAI1.setQualityPoints(6);

        playerAI2.setChosenLabel("Deeksha");
        playerAI2.setCraftChip(0);
        playerAI2.setIntegrityChip(2);
        playerAI2.setLearningChip(4);
        playerAI2.setCurrentLocation("ECS 308");
        playerAI2.setQualityPoints(6);

        
        //playerTwoLabel.setFont(f);
        customColor = new Color(255,0,255);

        playerTwoLabel.setForeground(customColor);
        if (currentPlayer.equalsIgnoreCase("Niru")) {
            playerTwoLabel.setText("Kevin");
        
        
        humanPlayer.setCraftChip(0);
        humanPlayer.setIntegrityChip(4);
        humanPlayer.setLearningChip(2);
        humanPlayer.setCurrentLocation("ECS 308");
        humanPlayer.setQualityPoints(6);

        playerAI1.setChosenLabel("Kevin");
        playerAI1.setCraftChip(2);
        playerAI1.setIntegrityChip(2);
        playerAI1.setLearningChip(2);
        playerAI1.setCurrentLocation("ECS 308");
        playerAI1.setQualityPoints(6);

        playerAI2.setChosenLabel("Deeksha");
        playerAI2.setCraftChip(0);
        playerAI2.setIntegrityChip(2);
        playerAI2.setLearningChip(4);
        playerAI2.setCurrentLocation("ECS 308");
        playerAI2.setQualityPoints(6);

        }
        customColor = new Color(125,125,235);
        playerThreeLabel.setForeground(customColor);
       // playerThreeLabel.setFont(f);

        if (currentPlayer.equalsIgnoreCase("Deeksha")) {
            playerThreeLabel.setText("Kevin");
        humanPlayer.setCraftChip(0);
        humanPlayer.setIntegrityChip(2);
        humanPlayer.setLearningChip(4);
        humanPlayer.setCurrentLocation("ECS 308");
        humanPlayer.setQualityPoints(6);

        playerAI1.setChosenLabel("Niru");
        playerAI1.setCraftChip(0);
        playerAI1.setIntegrityChip(4);
        playerAI1.setLearningChip(2);
        playerAI1.setCurrentLocation("ECS 308");
        playerAI1.setQualityPoints(6);

        playerAI2.setChosenLabel("Kevin");
        playerAI2.setCraftChip(2);
        playerAI2.setIntegrityChip(2);
        playerAI2.setLearningChip(2);
        playerAI2.setCurrentLocation("ECS 308");
        playerAI2.setQualityPoints(6);

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


        /* movesList.add("Brotman Hall");
         movesList.add("ECS 302");
         movesList.add("ECS 308");
         movesList.add("Elevators");
         movesList.add("South Hall");
         movesList.add("Lactation Lounge");
         movesList.add("Room of Retirement");
         movesLi
        
        
         st.add("East Walkway");
         movesList.add("LA5");
         movesList.add("Library");
         movesList.add("West Walkway");
         movesList.add("North Hall");
         movesList.add("Computer Lab");
         movesList.add("Eat Club");
         movesList.add("CECS Conference Room");
         movesList.add("Forbidden Parking");
         movesList.add("Rec Center");
         movesList.add("Student Parking");
         movesList.add("Walter Pyramid");
         movesList.add("Japanese Garden");
         movesList.add("George Allen Field");*/
        movesList.add("South Hall");
        movesList2.add("South Hall");
        movesList3.add("South Hall");
        movesList.addActionListener(new SelectMoveListner());
        ImageIcon bottomImage = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Background.png");
        JLabel bottomLabel = new JLabel(bottomImage);
        
        

        String data[][] = {{"", "Learning", "Craft", "Integrity", "Quality Points"},
            {humanPlayer.getChosenLabel(), ""+humanPlayer.getLearningChip()+"",""+""+humanPlayer.getCraftChip()+"", ""+humanPlayer.getIntegrityChip()+"", ""+""+humanPlayer.getQualityPoints()+""}, 
            {playerAI1.getChosenLabel(), ""+playerAI1.getLearningChip()+"",""+""+playerAI1.getCraftChip()+"", ""+playerAI1.getIntegrityChip()+"", ""+""+playerAI1.getQualityPoints()+""},  
            {playerAI2.getChosenLabel(), ""+playerAI2.getLearningChip()+"",""+""+playerAI2.getCraftChip()+"", ""+playerAI2.getIntegrityChip()+"", ""+""+playerAI2.getQualityPoints()+""},  };
        String column[] = {" ", "Learning", "Craft", "Integrity", "Quality Points"};

        scoreTable = new JTable(data, column);
        //scoreTable.setValueAt("PPPP", 0, 1);
        // mapLabel.setLocation(0, 0);
        frame.add(upperPanel);
        frame.add(bottomPanel);
        //buttonPanel.setLocation(0, 500);
        labelCard.addMouseListener(null);
        //buttonPanel.repaint();
        //frame.add(buttonPanel);
        //buttonPanel.setBounds(0, 500, 100, 600);


        cardButton.setOpaque(false);
        cardButton.setBounds(10, 10, 110, 33);
        cardButton.addActionListener(new DrawButtonListner());
        bottomLabel.add(cardButton);

        moveButton.setOpaque(false);
        moveButton.setBounds(10, 47, 110, 33);
        moveButton.setEnabled(false);
        moveButton.addActionListener(new MoveButtonListner());
        bottomLabel.add(moveButton);

        playButton.setOpaque(false);
        playButton.setBounds(10, 85, 110, 33);
        playButton.setEnabled(false);
        playButton.addActionListener(new PlayCardListner());
        bottomLabel.add(playButton);

        labelCard.setOpaque(false);
        labelCard.setBounds(190, 10, 320, 280);
        bottomLabel.add(labelCard);

        movesList.setBounds(10, 130, 170, 100);
        bottomLabel.add(movesList);

        //scoreTable.setOpaque(false);
        scoreTable.setBounds(500, 10, 500, 500);
        scoreTable.setOpaque(false);
        scoreTable.setGridColor(Color.black);
        //scoreTable.setBackground(Color.gray);
        bottomLabel.add(scoreTable);

        cardsCount.setOpaque(false);
        cardsCount.setBounds(500, 100, 100, 10);
        bottomLabel.add(cardsCount);
        cardsCountValue.setOpaque(false);
        cardsCountValue.setBounds(590, 100, 40, 10);
        bottomLabel.add(cardsCountValue);

        discardsCount.setOpaque(false);
        discardsCount.setBounds(700, 100, 120, 10);
        bottomLabel.add(discardsCount);
        discardsCountValue.setOpaque(false);
        discardsCountValue.setBounds(820, 100, 40, 10);
        bottomLabel.add(discardsCountValue);

        currentState.setOpaque(false);
        currentState.setBounds(500, 120, 500, 10);
        bottomLabel.add(currentState);

        notes.setOpaque(false);
        notes.setBounds(500, 150, 500, 50);
        bottomLabel.add(notes);

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
        scrollPane.setBounds(0, 0, 1360, 500);

        JScrollPane scrollPane2 = new JScrollPane(bottomPanel);
        scrollPane2.setBounds(0, 500, 1360, 800);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1900, 1080));
        contentPane.add(scrollPane);
        contentPane.add(scrollPane2);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    class SelectMoveListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            globalSelectedRoom = e.getActionCommand().toString();
            System.out.println("Selcted room: " + globalSelectedRoom);

            moveButton.setEnabled(true);
        }
    }

    class DrawButtonListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("U have clicked Draw card button");
        cardButton.setEnabled(false); 
        moveButton.setEnabled(true);
        playButton.setEnabled(true);
            System.out.println("Selected card number is"+humanCount);
            System.out.println("Selected card name is Card"+ playerOneDeck.getItem(humanCount));//replace with list index 
         humanCount++;
         cardCnt = humanCount;
        }
        
    }
    
    class MoveButtonListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveCnt++;
            if(moveCnt>=3){
                moveButton.setEnabled(false);
            }
            playButton.setEnabled(true);
            //if(currentPlayer = PlayerName[0].toString())
            humanPlayer.setCurrentLocation(globalSelectedRoom);
            if (globalSelectedRoom.equalsIgnoreCase("South Hall")) {
                System.out.println("Inside South Hall");
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


            if (globalSelectedRoom.equalsIgnoreCase("ECS 302")) {
                System.out.println("Inside ECS 302 room");
                panelPlayer1.setBounds(0, 1000, 1750, 1000);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("North Hall");
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
            }

            if (globalSelectedRoom.equalsIgnoreCase("Eat Club")) {
                System.out.println("Inside Eat Club");
                panelPlayer1.setBounds(200, 900, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in Eat Club");
            }

            if (globalSelectedRoom.equalsIgnoreCase("CECS Conference Room")) {
                System.out.println("Inside CECS Conference Room");
                panelPlayer1.setBounds(350, 900, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in CECS Conference Room");
            }

            if (globalSelectedRoom.equalsIgnoreCase("Lactation Lounge")) {
                System.out.println("Inside Lactation Lounge");
                panelPlayer1.setBounds(400, 1400, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in Lactation Lounge");
            }

            if (globalSelectedRoom.equalsIgnoreCase("ECS 308")) {
                System.out.println("Inside ECS 308");
                panelPlayer1.setBounds(0, 1320, 1750, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");

                currentState.setText("You are" + currentPlayer + " and You are in ECS 308");
            }

            if (globalSelectedRoom.equalsIgnoreCase("East Walkway")) {
                System.out.println("Inside East Walkway");
                panelPlayer1.setBounds(580, 1100, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");
                movesList.add("Brotman Hall");
                movesList.add("Forbidden Parking");

                currentState.setText("You are" + currentPlayer + " and You are in East Walkway");
            }

            if (globalSelectedRoom.equalsIgnoreCase("Brotman Hall")) {
                System.out.println("Inside Brotman Hall");
                panelPlayer1.setBounds(300, 1800, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("East Walkway");
                movesList.add("LA5");


                currentState.setText("You are" + currentPlayer + " and You are in Brotman Hall");
            }

            if (globalSelectedRoom.equalsIgnoreCase("Forbidden Parking")) {
                System.out.println("Inside Forbidden Parking");
                panelPlayer1.setBounds(350, 700, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("South Hall");
                movesList.add("Rec Center");
                movesList.add("Student Parking");

                currentState.setText("You are" + currentPlayer + " and You are in Forbidden Parking");
            }

            if (globalSelectedRoom.equalsIgnoreCase("Rec Center")) {
                System.out.println("Inside Rec Center");
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

            if (globalSelectedRoom.equalsIgnoreCase("Student Parking")) {
                System.out.println("Inside Student Parking");
                panelPlayer1.setBounds(350, 350, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();

                movesList.add("Walter Pyramid");
                movesList.add("Rec Center");
                movesList.add("Japanese Garden ");
                movesList.add("Forbidden Parking");

                currentState.setText("You are" + currentPlayer + " and You are in Student Parking");
            }

            if (globalSelectedRoom.equalsIgnoreCase("Walter Pyramid")) {
                System.out.println("Inside Walter Pyramid");
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

            if (globalSelectedRoom.equalsIgnoreCase("Japanese Garden")) {
                System.out.println("Inside Japanese Garden");
                panelPlayer1.setBounds(-350, 150, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();

                movesList.add("Walter Pyramid");
                movesList.add("Student Parking");
                movesList.add("George Allen Field");

                currentState.setText("You are" + currentPlayer + " and You are in Japanese Garden");
            }

            if (globalSelectedRoom.equalsIgnoreCase("George Allen Field")) {
                System.out.println("Inside George Allen Field");
                panelPlayer1.setBounds(-750, 70, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();

                movesList.add("Walter Pyramid");
                movesList.add("Japanese Garden");
                movesList.add("West Walkway");
                movesList.add("Rec Center");

                currentState.setText("You are" + currentPlayer + " and You are in George Allen Field");
            }

            if (globalSelectedRoom.equalsIgnoreCase("West Walkway")) {
                System.out.println("Inside West Walkway");
                panelPlayer1.setBounds(-850, 1200, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();

                movesList.add("George Allen Field");
                movesList.add("North Hall");
                movesList.add("Library");

                currentState.setText("You are" + currentPlayer + " and You are in West Walkway");
            }

            if (globalSelectedRoom.equalsIgnoreCase("North Hall")) {
                System.out.println("Inside North Hall");
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

            if (globalSelectedRoom.equalsIgnoreCase("Library")) {
                System.out.println("Inside Library");
                panelPlayer1.setBounds(-700, 1800, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("West Walkway");
                movesList.add("LA5");

                currentState.setText("You are" + currentPlayer + " and You are in Library");

            }

            if (globalSelectedRoom.equalsIgnoreCase("Room of Retirement")) {
                System.out.println("Inside Room of Retirement");
                panelPlayer1.setBounds(-700, 1400, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("North Hall");

                currentState.setText("You are" + currentPlayer + " and You are in Room of Retirement");

            }

            if (globalSelectedRoom.equalsIgnoreCase("Computer Lab")) {
                System.out.println("Inside Computer Lab");
                panelPlayer1.setBounds(-700, 950, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("North Hall");

                currentState.setText("You are" + currentPlayer + " and You are in Computer Lab");

            }


            if (globalSelectedRoom.equalsIgnoreCase("LA5")) {
                System.out.println("Inside LA5");
                panelPlayer1.setBounds(-100, 1800, 1900, 1320);
                panelPlayer1.repaint();

                movesList.removeAll();
                movesList.add("Library");
                movesList.add("Elevators");
                movesList.add("Brotman Hall");

                currentState.setText("You are" + currentPlayer + " and You are in LA5");

            }

            if (globalSelectedRoom.equalsIgnoreCase("Elevators")) {
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
            //globalSelectedRoom=e.getActionCommand().toString();
            
         if(humanCount<5){
            imageCard = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card" + playerOneDeck.getItem(humanCount) + ".jpg");
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
            
                //switch statement goes here for all the cards
            
            humanPlayer=selectClass(humanPlayer,Integer.parseInt(playerOneDeck.getItem(humanCount-1)));    
            System.out.println("humanCount: "+humanCount);
            scoreTable.setValueAt(""+humanPlayer.getLearningChip()+"", 1, 1);
            scoreTable.setValueAt(""+humanPlayer.getCraftChip()+"", 1, 2);
            scoreTable.setValueAt(""+humanPlayer.getIntegrityChip()+"", 1, 3);
            scoreTable.setValueAt(""+humanPlayer.getQualityPoints()+"", 1, 4);
            
                System.out.println("Integrity Points is: "+humanPlayer.getLearningChip());
            if(humanPlayer.isDiscardCard()){
                CardDialog objDis= new CardDialog(playerOneDeck,humanCount);
            }
            if(humanPlayer.isChooseQuality()){
                ChipsDialog objQualityD = new ChipsDialog();
            }
            }
            System.out.println("played");
            System.out.println("Selcted room: " + globalSelectedRoom);
            cardButton.setEnabled(true);
            playButton.setEnabled(false);

            int tempMove = 1;
            tempMove = numGen(movesList3.getItemCount());
            tempMove--;
            globalSelectedRoom3 = movesList3.getItem(tempMove);
            aI3Move();
           playerAI2= selectClass(playerAI2,Integer.parseInt(playerTwoDeck.getItem(humanCount-1)));
           scoreTable.setValueAt(""+playerAI2.getLearningChip()+"", 3, 1);
            scoreTable.setValueAt(""+playerAI2.getCraftChip()+"", 3, 2);
            scoreTable.setValueAt(""+playerAI2.getIntegrityChip()+"", 3, 3);
            scoreTable.setValueAt(""+playerAI2.getQualityPoints()+"", 3, 4);
 
           tempMove = numGen(movesList2.getItemCount());
            tempMove--;
            globalSelectedRoom2 = movesList2.getItem(tempMove);
            aI2Move();
           playerAI1= selectClass(playerAI1,Integer.parseInt(playerThreeDeck.getItem(humanCount-1)));
           scoreTable.setValueAt(""+playerAI1.getLearningChip()+"", 2, 1);
            scoreTable.setValueAt(""+playerAI1.getCraftChip()+"", 2, 2);
            scoreTable.setValueAt(""+playerAI1.getIntegrityChip()+"", 2, 3);
            scoreTable.setValueAt(""+playerAI1.getQualityPoints()+"", 2, 4);
           //humanCount++;
        }

        public Player selectClass(Player player,int selectCnt){
            
            switch(selectCnt){
                case 1: CECS105Card6 objCard1=new CECS105Card6();
                        player=objCard1.play(player);
                        break;
                case 2: ResearchCompilersCard objCard2=new ResearchCompilersCard();
                        player=objCard2.play(player);
                        break;
                case 3: Math122Card objCard3=new Math122Card();
                        player=objCard3.play(player);
                        break;
                case 4: CECS174ClassCard objCard4=new CECS174ClassCard();
                        player=objCard4.play(player);
                        break;
                case 5: LunchAtBratwrustHallCard objCard5=new LunchAtBratwrustHallCard();
                        player=objCard5.play(player);
                        break;
                case 6: CECS100Card objCard6=new CECS100Card();
                        player=objCard6.play(player);
                        break;
                case 7: ExcercisingMindAndBodyCard objCard7=new ExcercisingMindAndBodyCard();
                        player=objCard7.play(player);
                        break;
                case 8: ParkingViolationCard objCard8=new ParkingViolationCard();
                        player=objCard8.play(player);
                        break;
                case 9: FindingTheLabCard objCard9=new FindingTheLabCard();
                        player=objCard9.play(player);
                        break;
                case 10: GoodByeProfessorCard objCard10=new GoodByeProfessorCard();
                        player=objCard10.play(player);
                        break;
                case 11: EnjyoyingThePeaceCard objCard11=new EnjyoyingThePeaceCard();
                        player=objCard11.play(player);
                        break;
                case 12: BuddyUpCard objCard12=new BuddyUpCard();
                        player=objCard12.play(player);
                        break;
                case 13: LateForClassCard objCard13=new LateForClassCard();
                        player=objCard13.play(player);
                        break;
                case 14: Physics151Card objCard14=new Physics151Card();
                        player=objCard14.play(player);
                        break;
                case 15: TheBigGameCard objCard15=new TheBigGameCard();
                        player=objCard15.play(player);
                        break;
                case 16: KIN253LearningRulesSoccerCard objCard16=new KIN253LearningRulesSoccerCard();
                        player=objCard16.play(player);
                        break;
                case 17: Math123Card objCard17=new Math123Card();
                        player=objCard17.play(player);
                        break;
                case 18: LearningNetbeansCard objCard18=new LearningNetbeansCard();
                        player=objCard18.play(player);
                        break;
                case 19: ChoosingAMajorCard objCard19=new ChoosingAMajorCard();
                        player=objCard19.play(player);
                        break;
                case 20: PassSoccerClassCard objCard20=new PassSoccerClassCard();
                        player=objCard20.play(player);
                        break;
                case 21: ScoreAGoalCard objCard21=new ScoreAGoalCard();
                        player=objCard21.play(player);
                        break;
                case 22: FallInThePondCard objCard22=new FallInThePondCard();
                        player=objCard22.play(player);
                        break;
                case 23: MakeTheDeanListCard objCard23=new MakeTheDeanListCard();
                        player=objCard23.play(player);
                        break;
                case 24: NewLaptopCard objCard24=new NewLaptopCard();
                        player=objCard24.play(player);
                        break;
                case 25: MeetTheDeanCard objCard25=new MeetTheDeanCard();
                        player=objCard25.play(player);
                        break;
                case 26: LoudBuzzingCard objCard26=new LoudBuzzingCard();
                        player=objCard26.play(player);
                        break;
                case 27: ProgramCrashesCard objCard27=new ProgramCrashesCard();
                        player=objCard27.play(player);
                        break;
                case 28: ProfessorEnglertCard objCard28=new ProfessorEnglertCard();
                        player=objCard28.play(player);
                        break;
                case 29: PressTheRightFloorCard objCard29=new PressTheRightFloorCard();
                        player=objCard29.play(player);
                        break;
                case 30: SoccerGoalieCard objCard30=new SoccerGoalieCard();
                        player=objCard30.play(player);
                        break;
                case 31: ElectiveClassCard objCard31=new ElectiveClassCard();
                        player=objCard31.play(player);
                        break;
                case 32: OralCommunicationCard objCard32=new OralCommunicationCard();
                        player=objCard32.play(player);
                        break;
                case 33: ProfessorHoffmanCard objCard33=new ProfessorHoffmanCard();
                        player=objCard33.play(player);
                        break;
                case 34: Chem111Card objCard34=new Chem111Card();
                        player=objCard34.play(player);
                        break;
                case 35: TheOutPostCard objCard35=new TheOutPostCard();
                        player=objCard35.play(player);
                        break;
                case 36: LearningLinuxCard objCard36=new LearningLinuxCard();
                        player=objCard36.play(player);
                        break;
                case 37: MakeAFriendCard objCard37=new MakeAFriendCard();
                        player=objCard37.play(player);
                        break;
                case 38: EnjoyingNatureCard objCard38=new EnjoyingNatureCard();
                        player=objCard38.play(player);
                        break;
                case 39: StudentParkingCard objCard39=new StudentParkingCard();
                        player=objCard39.play(player);
                        break;
                case 40: CECS100Card objCard40=new CECS100Card();
                        player=objCard40.play(player);
                        break;
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

        public void aI3Move() {

            playerAI2.setCurrentLocation(globalSelectedRoom3);
            if (globalSelectedRoom3.equalsIgnoreCase("South Hall")) {
                System.out.println("Inside South Hall");
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

                //   currentState.setText("You are " + currentPlayer +" and You are in South Hall");
            }


            if (globalSelectedRoom3.equalsIgnoreCase("ECS 302")) {
                System.out.println("Inside ECS 302 room");
                panelPlayer3.setBounds(0, 950, 1750, 1000);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("North Hall");
                movesList3.add("South Hall");

                //currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Eat Club")) {
                System.out.println("Inside Eat Club");
                panelPlayer3.setBounds(200, 1000, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in Eat Club");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("CECS Conference Room")) {
                System.out.println("Inside CECS Conference Room");
                panelPlayer3.setBounds(370, 1000, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in CECS Conference Room");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Lactation Lounge")) {
                System.out.println("Inside Lactation Lounge");
                panelPlayer3.setBounds(400, 1500, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in Lactation Lounge");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("ECS 308")) {
                System.out.println("Inside ECS 308");
                panelPlayer3.setBounds(0, 1420, 1750, 1420);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in ECS 308");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("East Walkway")) {
                System.out.println("Inside East Walkway");
                panelPlayer3.setBounds(580, 1200, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");
                movesList3.add("Brotman Hall");
                movesList3.add("Forbidden Parking");

                // currentState.setText("You are" + currentPlayer + " and You are in East Walkway");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Brotman Hall")) {
                System.out.println("Inside Brotman Hall");
                panelPlayer3.setBounds(300, 1900, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("East Walkway");
                movesList3.add("LA5");


                // currentState.setText("You are" + currentPlayer + " and You are in Brotman Hall");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Forbidden Parking")) {
                System.out.println("Inside Forbidden Parking");
                panelPlayer3.setBounds(500, 750, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("South Hall");
                movesList3.add("Rec Center");
                movesList3.add("Student Parking");

                // currentState.setText("You are" + currentPlayer + " and You are in Forbidden Parking");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Rec Center")) {
                System.out.println("Inside Rec Center");
                panelPlayer3.setBounds(-150, 650, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();

                movesList3.add("Student Parking");
                movesList3.add("George Allen Field");
                movesList3.add("Walter Pyramid");
                movesList3.add("Student Parking");
                movesList3.add("West Walkway");

                // currentState.setText("You are" + currentPlayer + " and You are in Rec Center");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Student Parking")) {
                System.out.println("Inside Student Parking");
                panelPlayer3.setBounds(350, 400, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();

                movesList3.add("Walter Pyramid");
                movesList3.add("Rec Center");
                movesList3.add("Japanese Garden ");
                movesList3.add("Forbidden Parking");

                //  currentState.setText("You are" + currentPlayer + " and You are in Student Parking");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Walter Pyramid")) {
                System.out.println("Inside Walter Pyramid");
                panelPlayer3.setBounds(-350, 400, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();

                movesList3.add("Walter Pyramid");
                movesList3.add("Rec Center");
                movesList3.add("Japanese Garden ");
                movesList3.add("Student Parking");
                movesList3.add("George Allen Field");

                // currentState.setText("You are" + currentPlayer + " and You are in Walter Pyramid");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Japanese Garden")) {
                System.out.println("Inside Japanese Garden");
                panelPlayer3.setBounds(-350, 50, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();

                movesList3.add("Walter Pyramid");
                movesList3.add("Student Parking");
                movesList3.add("George Allen Field");

                // currentState.setText("You are" + currentPlayer + " and You are in Japanese Garden");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("George Allen Field")) {
                System.out.println("Inside George Allen Field");
                panelPlayer3.setBounds(-750, 150, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();

                movesList3.add("Walter Pyramid");
                movesList3.add("Japanese Garden");
                movesList3.add("West Walkway");
                movesList3.add("Rec Center");

                //currentState.setText("You are" + currentPlayer + " and You are in George Allen Field");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("West Walkway")) {
                System.out.println("Inside West Walkway");
                panelPlayer3.setBounds(-850, 1100, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();

                movesList3.add("George Allen Field");
                movesList3.add("North Hall");
                movesList3.add("Library");

                //  currentState.setText("You are" + currentPlayer + " and You are in West Walkway");
            }

            if (globalSelectedRoom3.equalsIgnoreCase("North Hall")) {
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

                //    currentState.setText("You are" + currentPlayer + " and You are in North Hall");

                moveButton.setEnabled(false);
            }

            if (globalSelectedRoom3.equalsIgnoreCase("Library")) {
                System.out.println("Inside Library");
                panelPlayer3.setBounds(-700, 1900, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("West Walkway");
                movesList3.add("LA5");

                //  currentState.setText("You are" + currentPlayer + " and You are in Library");

            }

            if (globalSelectedRoom3.equalsIgnoreCase("Room of Retirement")) {
                System.out.println("Inside Room of Retirement");
                panelPlayer3.setBounds(-550, 1450, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("North Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in Room of Retirement");

            }

            if (globalSelectedRoom3.equalsIgnoreCase("Computer Lab")) {
                System.out.println("Inside Computer Lab");
                panelPlayer3.setBounds(-700, 900, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("North Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in Computer Lab");

            }


            if (globalSelectedRoom3.equalsIgnoreCase("LA5")) {
                System.out.println("Inside LA5");
                panelPlayer3.setBounds(-100, 1900, 1900, 1320);
                panelPlayer3.repaint();

                movesList3.removeAll();
                movesList3.add("Library");
                movesList3.add("Elevators");
                movesList3.add("Brotman Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in LA5");

            }

            if (globalSelectedRoom3.equalsIgnoreCase("Elevators")) {
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
            
            playerAI1.setCurrentLocation(globalSelectedRoom2); 
            if (globalSelectedRoom2.equalsIgnoreCase("South Hall")) {
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

                //   currentState.setText("You are " + currentPlayer +" and You are in South Hall");
            }


            if (globalSelectedRoom2.equalsIgnoreCase("ECS 302")) {
                System.out.println("Inside ECS 302 room");
                panelPlayer2.setBounds(0, 1050, 1750, 1000);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("North Hall");
                movesList2.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in ECS 302");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Eat Club")) {
                System.out.println("Inside Eat Club");
                panelPlayer2.setBounds(200, 950, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in Eat Club");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("CECS Conference Room")) {
                System.out.println("Inside CECS Conference Room");
                panelPlayer2.setBounds(370, 950, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in CECS Conference Room");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Lactation Lounge")) {
                System.out.println("Inside Lactation Lounge");
                panelPlayer2.setBounds(400, 1450, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in Lactation Lounge");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("ECS 308")) {
                System.out.println("Inside ECS 308");
                panelPlayer2.setBounds(0, 1370, 1750, 13270);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in ECS 308");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("East Walkway")) {
                System.out.println("Inside East Walkway");
                panelPlayer2.setBounds(580, 1150, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");
                movesList2.add("Brotman Hall");
                movesList2.add("Forbidden Parking");

                //currentState.setText("You are" + currentPlayer + " and You are in East Walkway");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Brotman Hall")) {
                System.out.println("Inside Brotman Hall");
                panelPlayer2.setBounds(300, 1850, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("East Walkway");
                movesList2.add("LA5");


                //  currentState.setText("You are" + currentPlayer + " and You are in Brotman Hall");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Forbidden Parking")) {
                System.out.println("Inside Forbidden Parking");
                panelPlayer2.setBounds(350, 750, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("South Hall");
                movesList2.add("Rec Center");
                movesList2.add("Student Parking");

                //  currentState.setText("You are" + currentPlayer + " and You are in Forbidden Parking");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Rec Center")) {
                System.out.println("Inside Rec Center");
                panelPlayer2.setBounds(-150, 750, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();

                movesList2.add("Student Parking");
                movesList2.add("George Allen Field");
                movesList2.add("Walter Pyramid");
                movesList2.add("Student Parking");
                movesList2.add("West Walkway");

                // currentState.setText("You are" + currentPlayer + " and You are in Rec Center");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Student Parking")) {
                System.out.println("Inside Student Parking");
                panelPlayer2.setBounds(350, 300, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();

                movesList2.add("Walter Pyramid");
                movesList2.add("Rec Center");
                movesList2.add("Japanese Garden ");
                movesList2.add("Forbidden Parking");

                // currentState.setText("You are" + currentPlayer + " and You are in Student Parking");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Walter Pyramid")) {
                System.out.println("Inside Walter Pyramid");
                panelPlayer2.setBounds(-350, 300, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();

                movesList2.add("Walter Pyramid");
                movesList2.add("Rec Center");
                movesList2.add("Japanese Garden ");
                movesList2.add("Student Parking");
                movesList2.add("George Allen Field");

                // currentState.setText("You are" + currentPlayer + " and You are in Walter Pyramid");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Japanese Garden")) {
                System.out.println("Inside Japanese Garden");
                panelPlayer2.setBounds(-350, 100, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();

                movesList2.add("Walter Pyramid");
                movesList2.add("Student Parking");
                movesList2.add("George Allen Field");

                //  currentState.setText("You are" + currentPlayer + " and You are in Japanese Garden");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("George Allen Field")) {
                System.out.println("Inside George Allen Field");
                panelPlayer2.setBounds(-750, 100, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();

                movesList2.add("Walter Pyramid");
                movesList2.add("Japanese Garden");
                movesList2.add("West Walkway");
                movesList2.add("Rec Center");

                // currentState.setText("You are" + currentPlayer + " and You are in George Allen Field");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("West Walkway")) {
                System.out.println("Inside West Walkway");
                panelPlayer2.setBounds(-850, 1150, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();

                movesList2.add("George Allen Field");
                movesList2.add("North Hall");
                movesList2.add("Library");

                //currentState.setText("You are" + currentPlayer + " and You are in West Walkway");
            }

            if (globalSelectedRoom2.equalsIgnoreCase("North Hall")) {
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

                //currentState.setText("You are" + currentPlayer + " and You are in North Hall");

                moveButton.setEnabled(false);
            }

            if (globalSelectedRoom2.equalsIgnoreCase("Library")) {
                System.out.println("Inside Library");
                panelPlayer2.setBounds(-700, 1850, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("West Walkway");
                movesList2.add("LA5");

                //currentState.setText("You are" + currentPlayer + " and You are in Library");

            }

            if (globalSelectedRoom2.equalsIgnoreCase("Room of Retirement")) {
                System.out.println("Inside Room of Retirement");
                panelPlayer2.setBounds(-700, 1450, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("North Hall");

                // currentState.setText("You are" + currentPlayer + " and You are in Room of Retirement");

            }

            if (globalSelectedRoom2.equalsIgnoreCase("Computer Lab")) {
                System.out.println("Inside Computer Lab");
                panelPlayer2.setBounds(-700, 1000, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("North Hall");

                //currentState.setText("You are" + currentPlayer + " and You are in Computer Lab");

            }


            if (globalSelectedRoom2.equalsIgnoreCase("LA5")) {
                System.out.println("Inside LA5");
                panelPlayer2.setBounds(-100, 1850, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("Library");
                movesList2.add("Elevators");
                movesList2.add("Brotman Hall");

                //currentState.setText("You are" + currentPlayer + " and You are in LA5");

            }

            if (globalSelectedRoom2.equalsIgnoreCase("Elevators")) {
                System.out.println("Inside Elevators");
                panelPlayer2.setBounds(-290, 1450, 1900, 1320);
                panelPlayer2.repaint();

                movesList2.removeAll();
                movesList2.add("LA5");
                movesList2.add("North Hall");

                //  currentState.setText("You are" + currentPlayer + " and You are in Elevators");

            }

        }
    }
}
