package org.String;

import java.lang.*;

public class StringDemo {

  public static void main(String[] args) {
  
    String str = "This is yiibai";
                   
    // prints character at 1st location
    System.out.println(str.charAt(0));
          
    // prints character at 5th location i.e white-space character
    System.out.println(str.charAt(4));
          
    // prints character at 18th location 
//    System.out.println(str.charAt(17));//StringIndexOutOfBoundsException
  }
} 