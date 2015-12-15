package com.java;


import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CardDialog extends JDialog{
    JLabel title= new JLabel("Select a card that you think you don't need and wish to be discarded.");
    private ImageIcon imageCard1 ;
    private ImageIcon imageCard2 ;
    private ImageIcon imageCard3 ;
    private ImageIcon imageCard4 ;
    private ImageIcon imageCard5 ;
    JLabel card1= new JLabel(imageCard1);
    JLabel card2= new JLabel(imageCard2);
    JLabel card3= new JLabel(imageCard3);
    JLabel card4= new JLabel(imageCard2);
    JLabel card5= new JLabel(imageCard3);
    JPanel pnall= new JPanel();
    String dc;
    
    
    
    public String getDc() {
		return dc;
	}



	public void setDc(String dc) {
		this.dc = dc;
	}



	public CardDialog(List playerOneDeck, int cnt){
    
    imageCard1 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card"+playerOneDeck.getItem(0)+".jpg");
    imageCard2 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card"+playerOneDeck.getItem(1)+".jpg");
    imageCard3 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card"+playerOneDeck.getItem(2)+".jpg");
    imageCard4 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card"+playerOneDeck.getItem(3)+".jpg");
    imageCard5 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/card"+playerOneDeck.getItem(4)+".jpg");
    card1= new JLabel(imageCard1);
    card2= new JLabel(imageCard2);
    card3= new JLabel(imageCard3);
    card4= new JLabel(imageCard4);
    card5= new JLabel(imageCard5);

        setTitle("Select a card to be discarded");
		((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setSize(1440, 450);
		setResizable(false);
                
                card1.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setDc("1");
                    	dispose();
                    System.out.println("You wish to discard the 1st Card.");
                    }
                });
                
                card2.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setDc("2");
                    	dispose();
                    System.out.println("You wish to discard the 2nd Card.");
                    }
                });
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
                
                card3.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setDc("3");
                    	dispose();
                    System.out.println("You wish to discard the 3rd Card.");
                    }
                });
                
                card4.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setDc("4");
                    	dispose();
                    System.out.println("You wish to discard the 4th Card.");
                    }
                });
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
                
                card5.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setDc("5");
                    	dispose();
                    System.out.println("You wish to discard the 5th Card.");
                    }
                });

                add(pnall);
                
		pnall.add(card1);
		pnall.add(card2);
		pnall.add(card3);
                pnall.add(card4);
		pnall.add(card5);
		//this.add(Box.createVerticalStrut(10));		
		setVisible(true);
    }
}
