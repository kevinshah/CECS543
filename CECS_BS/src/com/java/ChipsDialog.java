package com.java;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sony
 */
    public class ChipsDialog extends JDialog{
    JLabel title= new JLabel("Please choose the quality point of your choice");
    private ImageIcon imageCard1 = new ImageIcon("D:\\piyush code\\Software Engineering\\QualityPoints\\Integrity.png");
    private ImageIcon imageCard2 = new ImageIcon("D:\\piyush code\\Software Engineering\\QualityPoints\\Learning.png");
    private ImageIcon imageCard3 = new ImageIcon("D:\\piyush code\\Software Engineering\\QualityPoints\\Craft.png");
    JLabel integrityPt= new JLabel(imageCard1);
    JLabel learningPt= new JLabel(imageCard2);
    JLabel craftPt= new JLabel(imageCard3);
    JPanel pnall= new JPanel();
    
    public ChipsDialog(){
    setTitle("Quality Points");
		((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setSize(800, 330);
		setResizable(false);
                
                integrityPt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected Integrity chip");
                    }
                });
                
                learningPt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have Learning chip");
                    }
                });
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
                
                craftPt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    System.out.println("you have selected Craft chip");
                    }
                });
                

                //pnall.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
                add(pnall);
                
		pnall.add(integrityPt);
		pnall.add(learningPt);
		pnall.add(craftPt);
		//this.add(Box.createVerticalStrut(10));		
		setVisible(true);
    }
}
