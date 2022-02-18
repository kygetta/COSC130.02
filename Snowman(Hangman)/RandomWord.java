
//@author Kylie Hall
//@date 1/14/2021

//This code will run the snowman(hangman) game. There will be a randomly generated word out of 20 with lengths from 4 to 12 letters long and the user will have to input possible characters for the secret word until they either win or input 6 incorrect guesses in which the user will lose. The user will get the option to play again.

import java.util.Scanner;

import java.util.Random;

public class RandomWord {
  // RandomWord rgen = new RandomWord();
  //public static void main(String[] args) {
 // }

  boolean[] dontRepeat = { false, false, false, false, false, false, false, false, false, false, false, false, false,
      false, false, false, false, false, false, false };
      //This is the created Boolean array to check if each word has been guessed.
  String[] words = { "balloon", "toaster", "eyeliner", "nachos", "turkey", "poodle", "potato", "bowling", "fridge",
      "sandwich", "plate", "pumpkin", "carnival", "spring", "skating", "quilt", "stove", "apple", "braid", "bird" };
      //This is the created String array of possible words that the user can guess.

//PreCondition: Initialize String word and declare randomInteger.
//PostCondition: word will be the word the user will guess (will be passed on). randomInteger will find a random index.
//MethodDescription: This method will generate a random word from the String array words as long as it hasn't been guessed before in the current round.
  public void wordGen() {
    String word = "";
    //declare String word

    Random R = new Random();

    // if statements to correlate the number with the word the user will guess. Then
    // it will print out the word selected.
for(int i=0;i<20;i++){
if(dontRepeat.equals(true)){
    wordGen();
    //this for loop and if statement will take in the word that was guessed, and set it equal to true in the Boolean dontRepeat array so the word will not be guessed again.
}
}

    int randomInteger = R.nextInt(20);
    // will select the generated number
    // from 1-20
    while (true) {
      if (dontRepeat[R.nextInt(20)]) {
        // If the number was used before, create a new number.
        randomInteger = R.nextInt(20);
        //This will create the new number generated.
      } else {
        //if all words have been guessed then break.
        break;
      }
    }
    word = words[randomInteger];
    //declares String word as the word at the randomly generated index.

    guessWord(word);
    
    //This calls for the method guessWord and sends out the perameter word that will be guessed by the user.
  }

//PreCondition: Declare String guess and emptyWord.
//PostCondition: guess will store user input as a one letter String. emptyWord will be the length of word with substituted underscores for each character.
//MethodDescription: In the method guessWord, the String word will be printed out with underscores substituting for each character. The user will then have 6 incorrect guesses to gues the word by entering in one letter Strings per guess.
  public void guessWord(String word) {

    Scanner input = new Scanner(System.in);

    String guess = "";
    //Declaring String guess.
    int countdown = 6;
    //Declaring int countdown equal to 6 (the amount of incorrect attempts the user has)
    String emptyWord = "";
    // Loop that will print out the underscores in replacement of the word the user
    // will guess.
    emptyWord = "";// Declares the string emptyWord
    for (int i = 0; i < word.length(); i++) {
      // this for loop will allow the command to work for i is less than 0 and i
      // is less than the length of the word to print the correct amount of underscores

      
      emptyWord = emptyWord + "_";
      // this declares emptyWord to store and underscore and will store one underscore
      // for each letter in the alphabet.

    }
    
    int b = 6;
    // declares b as 6 (this will be used in the while loop below)
    while (b >= 1) {
      // this while loop says that as 6 is greater than or equal to one it will
      // continue to do the following commands
      countdown = b;
      // this will update the countdown each time the while loop runs, this way the
      // countdown (number of incorrect guesses) can be tracked

      System.out.println("You have " + countdown + " incorrect guesses left.");
      // prints the amount of incorrect guesses
      // each round
      System.out.println(emptyWord);
      // prints the amount of underscore dashes in the randomly generated word
      System.out.println("what is your guess?");
      // asks the user to input a single letter string
      guess = input.next();
      // Stores user input as String guess
      guess = "" + guess.charAt(0);
      // Makes sure to store only one character(I decided to store as a String instead
      // of a character to make it easier to compare guess and emptyWord with no
      // error)

      boolean miss = true;
      // This sets a boolean value miss to be true
      for (int a = 0; a < word.length(); a++) {
        // this loop is inside the while loop and will run until the while loop
        // ends
        if (word.charAt(a) == guess.charAt(0)) {
          // if statement decides boolean false if a character in the randomly
          // generated word is equal to the user guess.
          miss = false;
          emptyWord = emptyWord.substring(0, a) + guess + emptyWord.substring(a + 1);
          // this will set emptyWord with the
          // correctly guessed character in
          // its correct spot.
          
        }
      }
      boolean correct = true;
      //Declares boolean correct equal to true.
      for (int j = 0; j < word.length(); j++) {
        if (word.charAt(j) != emptyWord.charAt(j)) {
          // goes through each guess and character of word. If they are not equal then boolean correct will be declared as false, otherwise it is true.
          correct = false;

        }
        
      }
      if(correct){
        giveOption(countdown, emptyWord, word);
          break;
          //This will allow the win option to be called. Without this, the code will not break and tell the user they have won.
      }

      if (miss) {
        // if statement will run if the guess does not equal any of the characters in
        // the word.

        b--;
        
        // this will take away one increment at a time until the incorrect answers while
        // loop (the user only has 6 incorrect guesses until the game ends and they
        // lose.)
      }
    }

    giveOption(0, emptyWord, word);
    //This will call for the giveOption method and it sends out the parameters of countdown equaling 0, emptyWord (which is the underscores), and word (the word the user is guessing).
  }

//PreCondition: Declare playAgain.
//PostCondition: playAgain will  be a user input in this method.
//MethodDescrption: In this method, the user will be given the option to play again or to stop playing. This will be done through if statements.
  public void giveOption(int countdown, String emptyWord, String word) {
    Scanner input = new Scanner(System.in);
    String playAgain = "";
    //Declares String playAgain
    if (countdown == 0) {
      
      //if int countdown is equal to 0, then the user ran out of tries.
      System.out.println("You lost. The word was " + word + ". Would you like to play again?");
      playAgain = input.next();
        
      
      //Asks if the user would like to play again then stores user input as String playAgain.
    } else{
      // the user wins.
      //System.out.println(word);
      System.out.println("You won! Would you like to play again?");
      playAgain = input.next();
      
    }
  
      getToOption(playAgain);
    //After storing if the user wants to play again or not, the program then calls for the getToOption method which sends out the String playAgain and String word.
      
  }
  
    //PreCondition: Calls in playAgain and String word. 
    //PostCondition: playagain will be in if statement. If each word in the array is equal to the passed in word, then break.
    //MethodDescription: In this method, the user's input for playAgain will be identified and either go throught the program again to allow them to play or the program will end if they decide they no longer want to play.
    public void getToOption(String playAgain){

        while(playAgain.equals("no") || playAgain.equals("No")){
          //If the user does not want to play again, the statement below will print and the code will exit.
     
    System.out.println("Thank you for playing!");
    
    System.out.println("******program ended******");
    //This statement will be printed if they decided they do not want to play again.

System.exit(1);
    break;
   //This will end the code.
      
    }
    if(playAgain.equals("yes") || playAgain.equals( "Yes")){
   
        wordGen();
        
        //if they want to play again, then it will generate a new word and run through the code again.
   
   
    }
    }
   }
  
    
    
  
  


