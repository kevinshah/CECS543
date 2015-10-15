package com.java;

import java.util.Random;

public class RandomNumberGenerator {
      
    public int numGenerator(){
      int  number = 0;
      Random randNumber = new  Random();  
      for(int idx = 1; idx<=1; idx++){
             number =  randNumber.nextInt(3);
             System.out.println("The random player selected is " + number);
           }
              return number;
       }
}