import javax.swing.*;

import java.awt.*;
import javax.swing.Box;


public class Test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        JButton drawCardButton = new  JButton("Draw Card");
        JButton moveButton = new  JButton("Move");
        JButton playCardButton = new  JButton("Play Card");
        JPanel bottomPanel = new JPanel();
        JPanel buttonPanel1 = new JPanel();
        
       

       // 4 rows and 5 columns
        
        String[] columnNames = {"",
                "Learning",
                "Craft",
                "Intergrety",
                "Quality Points"};
        
        JTable table = new JTable(4, 5);
        
      //  Image image = new ImageIcon("C:\\Users\\vishalvibhandik\\workspace\\CECS_BS\\src\\CSULBMap3.png").getImage();
        Image image = new ImageIcon("/Users/Kevin/Documents/workspace/CECS_BS/src/CSULBMap3.png").getImage();
        
        JLabel jl = new JLabel(new ImageIcon(image));
        
        JLabel label1 = new JLabel("Niru");
        label1.setForeground(Color.blue);
        
        JLabel label2 = new JLabel("Kevin");
        label2.setForeground(Color.blue);
        
        JLabel label3 = new JLabel("Deeksha");
        label3.setForeground(Color.blue);
        
        //label1.setSize(150, 150);
        //label1.setOpaque(false);
       // label1.setLocation(1200, 400);
       //names
        frame.add(bottomPanel);
        //DrawCard, Move, PlayCard buttons
        frame.add(buttonPanel1);
        
        
        buttonPanel1.add(drawCardButton);
        buttonPanel1.add(moveButton);
        buttonPanel1.add(playCardButton);
        buttonPanel1.add(table);
       // frame.add(jl);
        
        bottomPanel.add(jl);
        jl.add(panel1);
        jl.add(panel2);
        jl.add(panel3);
        //Niru
        panel1.setOpaque(false);
        panel1.setBounds(0, 1370, 1750, 1420);
        panel1.add(label1);
        //kevin
        panel2.setOpaque(false);
        panel2.setBounds(0, 1420, 1750, 1420);
        panel2.add(label2);
        //Dee
        panel3.setOpaque(false);
        panel3.setBounds(0, 1470, 1750, 1420);
        panel3.add(label3);
        
        //Image image = new ImageIcon("C:\\Users\\vishalvibhandik\\workspace\\CECS_BS\\src\\CSULBMap3.png").getImage();
        
        

       
        JScrollPane scrollPane = new JScrollPane(bottomPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1280, 500);
       
        
       JScrollPane buttonPane1 = new JScrollPane(buttonPanel1);
       buttonPane1.setBounds(0, 500, 1280, 800);
     
       
     //  buttonPane1.add(moveButton, 2);
       

     
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1900, 1080));
        contentPane.add(scrollPane);
        contentPane.add(buttonPane1);
       // contentPane.add(tablePane);

        
                       
        
        
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

	}

}
