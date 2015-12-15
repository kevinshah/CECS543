/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sony
 */
public class Util {
    
    public void fillDeck(){
        
        int number=0;
        Random randNum = new  Random();
        for(int counter = 0; counter<40; counter++)
          {
             number =  1+randNum.nextInt(40);
             System.out.println("The random player selected is " + number);
          }
              return;

       }
    
    public List<Integer> dealDeck(){
                List<Integer> list = new ArrayList<Integer>();

                for(int i = 0; i < 40; i++){
    list.add(i+1);
}
Collections.shuffle(list);
for(int i = 0; i < 40; i++){
    System.out.println(" "+list.get(i));  
}
return list;
    }

public static void main(String[] args) {
        
    Util obj=new Util();
    obj.dealDeck();

}

}