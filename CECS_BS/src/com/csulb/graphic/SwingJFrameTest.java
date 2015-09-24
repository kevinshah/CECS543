/**
 * 
 */
package com.csulb.graphic;

/**
 * @author vishalvibhandik
 *
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingJFrameTest extends JFrame {
    public static void main(String[] args) {
        try {
        	MyJPanel south = new MyJPanel();
        	
            SwingJFrameTest frame = new SwingJFrameTest();
            
            frame.setContentPane(south);
            
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public SwingJFrameTest() {
        setSize(1920, 1080);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
  
    
}
