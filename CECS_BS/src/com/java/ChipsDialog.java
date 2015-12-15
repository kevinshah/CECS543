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

    public class ChipsDialog extends JDialog{
    JLabel title= new JLabel("Please choose the quality point of your choice");
    private ImageIcon imageCard1 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Integrity.png");
    private ImageIcon imageCard2 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Learning.png");
    private ImageIcon imageCard3 = new ImageIcon("/Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/Craft.png");
    JLabel integrityPt= new JLabel(imageCard1);
    JLabel learningPt= new JLabel(imageCard2);
    JLabel craftPt= new JLabel(imageCard3);
    JPanel pnall= new JPanel();
    String sp;
    
    public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public ChipsDialog(){
    setTitle("Quality Points");
		((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setSize(800, 330);
		setResizable(false);
                
                integrityPt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setSp("Integrity");
                    	dispose();
                    System.out.println("you have selected Integrity chip");
                    }
                });
                
                learningPt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setSp("Learning");
                    	dispose();
                    System.out.println("you have Learning chip");
                    }
                });
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(title);
                
                craftPt.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	setSp("Craft");
                    	dispose();
                    }
                });
                add(pnall);
                
		pnall.add(integrityPt);
		pnall.add(learningPt);
		pnall.add(craftPt);
		setVisible(true);
    }
}
