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
    JLabel title= new JLabel("Please choose the card that you wish to discard");
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
    
    public CardDialog(List playerOneDeck, int cnt){
    
    imageCard1 = new ImageIcon("D:\\piyush code\\Software Engineering\\Cards_Images\\card"+playerOneDeck.getItem(0)+".jpg");
    imageCard2 = new ImageIcon("D:\\piyush code\\Software Engineering\\Cards_Images\\card"+playerOneDeck.getItem(1)+".jpg");
    imageCard3 = new ImageIcon("D:\\piyush code\\Software Engineering\\Cards_Images\\card"+playerOneDeck.getItem(2)+".jpg");
    imageCard4 = new ImageIcon("D:\\piyush code\\Software Engineering\\Cards_Images\\card"+playerOneDeck.getItem(3)+".jpg");
    imageCard5 = new ImageIcon("D:\\piyush code\\Software Engineering\\Cards_Images\\card"+playerOneDeck.getItem(4)+".jpg");
    card1= new JLabel(imageCard1);
    card2= new JLabel(imageCard2);
    card3= new JLabel(imageCard3);
    card4= new JLabel(imageCard4);
    card5= new JLabel(imageCard5);

        setTitle("Discard Cards");
		((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setSize(1100, 330);
		setResizable(false);
                
                card1.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected 1st Card to be discarded");
                    }
                });
                
                card2.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected 2nd Card to be discarded");
                    }
                });
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
                
                card3.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected 3rd Card to be discarded");
                    }
                });
                
                card4.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected 4th Card to be discarded");
                    }
                });
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
                
                card5.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected 5th Card to be discarded");
                    }
                });

                //pnall.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
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
