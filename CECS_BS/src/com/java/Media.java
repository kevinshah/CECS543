package com.java;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sony
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
    

    import javax.media.CannotRealizeException;
import javax.media.ControllerAdapter;
import javax.media.ControllerEvent;
import javax.media.IncompatibleSourceException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoDataSinkException;
import javax.media.NoDataSourceException;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.swing.JFrame;
    
    public class Media {
      
      static Player  player;
      //static Capture myFrame; 
    
      public void playMusic() throws NoDataSourceException, IOException, IncompatibleSourceException, CannotRealizeException, NoDataSinkException, NoPlayerException  {
        try{
        //CREATE FRAME.
        final JFrame  myFrame = new JFrame();
                      myFrame.setVisible(true);
                      myFrame.setSize(300,300);
                      myFrame.addWindowListener(
                        new WindowAdapter(){
                          public void windowClosing(WindowEvent event){  
                            player.stop();
                            player.close();
                            myFrame.dispose();
                          }
                        }
                      );            
        
        //CREATE PLAYER. 
        String filename = "file:///Users/Kevin/Desktop/CSULB/CECS543Project/CECS_BS/src/com/drawable/play.mp3";
       
        player = Manager.createPlayer(new MediaLocator(filename));
        player.addControllerListener(
            new ControllerAdapter(){
              public void controllerUpdate(ControllerEvent event){  
                if (event instanceof RealizeCompleteEvent) {
                  myFrame.add("Center",player.getVisualComponent());
                  myFrame.add("South" ,player.getControlPanelComponent());
                  myFrame.setVisible(false);
                  myFrame.validate();
                }
              }
            }
        );         
        player.start(); 
      }
 catch(Exception e){
     e.getMessage();
 }
      }
      
      public static void main(String[] args) {
    	 Media media = new Media();
    	 try{
    	  media.playMusic();
    	 }catch(Exception e){
    		 
    	 }
      }
    }