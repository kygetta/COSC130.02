/* 
Author Name: Kylie Hall
Date:1/22/21
Last date: 1/28/21

General description of the code: 

The goal of the code you will be writing is to remove, in alphabetic order, every letter from a String the user enters until there are no letters left. View full lab description here:
https://sites.google.com/smcm.edu/cosc-130-introduction-to-compu/lab-assignments/lab-0
*/
import java.util.Scanner;

public class Main {//All code will be done in the main method
  public static void main(String[] args) {
    //This code will take a String inputted by the user and then take away each letter in that string alphabetically until there are no letters left.

    Main m = new Main();//Implements/declares the main method.
    Scanner input = new Scanner(System.in);

    System.out.println("Please enter a string.");//This line asks the user to input a string.
    String word = input.nextLine();// this line stores the string as word.

    String Alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";//This String will be used to go through the alphabet and take away each letter in order.

    for (int j = 0; j < Alphabet.length(); j++) {// this for loop will loop the alphabet through int j. This will be used to scan the inputted word for each index
      
      for (int i = 0; i < word.length(); i++) {//This nested for loop will scan each character of the inputted word.
        if (word.charAt(i) == Alphabet.charAt(j)) {// This if statement will store a new word String if the character at i for word and j for Alphabet are equal.
          word = word.substring(0, i) + word.substring(i + 1);// Therefore, this line will store word as the substring of 0 to the character before i (the letter that is equal to Alphabet), then the substring one character after i and so on.

          i--;// this line will scan each character including the prior i that is taken away. This ensures every single character is scanned especially for inputted strings thats have multiples of a letter.

          System.out.println(word);// this line will print the word, taking away each letter in order until there is none left
        }
      }
    
    System.out.println( Alphabet.charAt(j) + ": " + word);//this line prints out the Alphabet char to show each letter it scans as well as printing the new word.

    if(word.length() == 0){//this if statement and return will stop printing the above statement (Line 36) once there are no characters left. (this makes it so that the alphabet does not continue after the word is gone.)
      return; 
    }
    }

  }
}