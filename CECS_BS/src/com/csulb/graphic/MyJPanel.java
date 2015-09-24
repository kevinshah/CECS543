package com.csulb.graphic;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
 
public class MyJPanel extends JPanel {
	
	Image image;
public MyJPanel(){
    //this.setSize(1920, 720);
    //this.setLocation(400, 400);
    this.setOpaque(false);
    this.setPreferredSize(new Dimension(500,400));
    
    JLabel label1 = new JLabel("Niru");
    label1.setSize(350, 150);
    
    image = new ImageIcon("C:\\Users\\vishalvibhandik\\workspace\\CECS_BS\\src\\CSULBMap3.png").getImage();
    image = scaleImage(image);
    
    JPanel panel = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(50, 30, 300, 50);
    this.add(scrollPane);
    
        
}

 

@Override
public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(image, 0, 0, this);
}


private Image scaleImage(Image rawImage) {
    Image scaledImage = null;
    System.out.println("Scaling");
    try {
        int rawImageWidth = rawImage.getWidth(this);
        int rawImageHeight = rawImage.getHeight(this);
        int paneWidth = (int) getWidth();
        int paneHeight = (int) getHeight();
        System.out.println("Image W = " + rawImageWidth
                + ", H = " + rawImageHeight
                + "; Pane W = " + paneWidth
                + ", H = " + paneHeight);
        // preserve the original ratio  
        float widthRatio = (float) rawImageWidth / (float) paneWidth;
        float heightRatio = (float) rawImageHeight / (float) paneHeight;
        int widthFactor = -1;
        int heightFactor = -1;
        if ((widthRatio > heightRatio) && (widthRatio > 1.0)) {
            widthFactor = paneWidth;
        } else if ((heightRatio > widthRatio) && (heightRatio > 1.0)) {
            heightFactor = paneHeight;
        }
        System.out.println("widthRatio = "
                + String.format("%.3f", widthRatio)
                + ", heightRatio = "
                + String.format("%.3f", heightRatio));
        System.out.println("widthFactor = " + widthFactor
                + ", heightFactor = " + heightFactor);
        if ((widthFactor < 0) && (heightFactor < 0)) {
            scaledImage = rawImage;
        } else {
            scaledImage = rawImage.getScaledInstance(widthFactor, heightFactor,
                    Image.SCALE_SMOOTH);
            // load the new image, 'getScaledInstance' loads asynchronously  
            MediaTracker tracker = new MediaTracker(this);
            tracker.addImage(scaledImage, 0);
            tracker.waitForID(0);
        }
    } catch (InterruptedException ie) {
        System.err.println("load interrupt: " + ie.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return (scaledImage);
}
}
